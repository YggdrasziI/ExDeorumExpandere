package net.cathienova.havenede.block.mechanicalsieves;

import net.cathienova.havenede.block.ModBlockEntities;
import net.cathienova.havenede.config.HavenConfig;
import net.cathienova.havenede.networking.ModMessages;
import net.cathienova.havenede.networking.packet.SieveDataSyncPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemHandlerHelper;
import net.cathienova.havenede.menu.mechanicalsieves.DiamondMechanicalSieveMenu;
import net.minecraftforge.network.PacketDistributor;
import thedarkcolour.exdeorum.blockentity.AbstractMachineBlockEntity;
import thedarkcolour.exdeorum.blockentity.helper.EnergyHelper;
import thedarkcolour.exdeorum.blockentity.helper.ItemHelper;
import thedarkcolour.exdeorum.blockentity.logic.SieveLogic;
import thedarkcolour.exdeorum.recipe.RecipeUtil;
import thedarkcolour.exdeorum.tag.EItemTags;

public class DiamondMechanicalSieveBlockEntity extends AbstractMachineBlockEntity<DiamondMechanicalSieveBlockEntity> implements SieveLogic.Owner {
    private static final Component TITLE = Component.translatable("havenede.container.diamond_mechanical_sieve");
    private static final int INPUT_SLOT = 0;
    public static final int MESH_SLOT = 1;
    private final SieveLogic logic = new SieveLogic(this, true);
    private final EnergyHelper energyHelper;

    public DiamondMechanicalSieveBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DIAMOND_MECHANICAL_SIEVE.get(), pos, state, ItemHandler::new, HavenConfig.diamond_mechanical_sieve_energyStorage);
        this.energyHelper = new EnergyHelper(HavenConfig.diamond_mechanical_sieve_energyStorage);
    }

    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        this.logic.saveNbt(nbt);
    }

    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.logic.loadNbt(nbt);
    }

    protected boolean isRunning() {
        return !this.logic.getContents().isEmpty();
    }

    protected void tryStartRunning() {
        ItemStack input = this.inventory.getStackInSlot(0);
        if (this.logic.isValidInput(input)) {
            this.logic.startSifting(input.copy());
            input.shrink(1);
        }
        if (level != null && !level.isClientSide)
        {
            if (this.level.getGameTime() % 5 == 0)
            {
                ModMessages.INSTANCE.send(PacketDistributor.ALL.noArg(), new SieveDataSyncPacket(this.energy.getEnergyStored(),
                        this.logic.getProgress(), this.worldPosition));
            }
        }
    }
    @Override
    protected void runMachineTick() {
        this.logic.sift((float)HavenConfig.diamond_mechanical_sieve_speed, Long.MAX_VALUE);
    }

    protected int getEnergyConsumption() {
        return HavenConfig.diamond_mechanical_sieve_energyConsumption;
    }

    public void writeVisualData(FriendlyByteBuf buffer) {
        buffer.writeItem(this.logic.getMesh());
        buffer.writeFloat(this.logic.getProgress());
        buffer.writeItem(this.logic.getContents());
    }

    public void readVisualData(FriendlyByteBuf buffer) {
        this.logic.setMesh(buffer.readItem(), false);
        this.logic.setProgress(buffer.readFloat());
        this.logic.setContents(buffer.readItem());
    }

    public boolean handleResultItem(ItemStack result, ServerLevel level, RandomSource rand) {
        ItemStack remainder = result.copy();

        for (int i = 2; i < 22; ++i) {
            ItemStack existing = this.inventory.getStackInSlot(i);
            int limit = this.inventory.getSlotLimit(i);
            if (!existing.isEmpty()) {
                if (!ItemHandlerHelper.canItemStacksStack(remainder, existing)) {
                    continue;
                }

                limit -= existing.getCount();
            }

            if (limit > 0) {
                boolean splitRemainder = remainder.getCount() > limit;
                if (existing.isEmpty()) {
                    this.inventory.setStackInSlot(i, splitRemainder ? ItemHandlerHelper.copyStackWithSize(remainder, limit) : remainder);
                } else {
                    existing.grow(splitRemainder ? limit : remainder.getCount());
                }

                if (!splitRemainder) {
                    return true;
                }

                remainder = ItemHandlerHelper.copyStackWithSize(remainder, remainder.getCount() - limit);
            }
        }

        return remainder.getCount() < result.getCount();
    }

    public Component getDisplayName() {
        return TITLE;
    }

    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player pPlayer) {
        return new DiamondMechanicalSieveMenu(containerId, playerInventory, this);
    }

    public EnergyHelper getEnergyHelper() {
        return energyHelper;
    }

    public SieveLogic getLogic() {
        return this.logic;
    }

    public ServerLevel getServerLevel() {
        return (ServerLevel)this.level;
    }

    private static class ItemHandler extends ItemHelper {
        private final DiamondMechanicalSieveBlockEntity sieve;

        public ItemHandler(DiamondMechanicalSieveBlockEntity sieve) {
            super(22);
            this.sieve = sieve;
        }

        public boolean isItemValid(int slot, ItemStack stack) {
            if (slot == 0) {
                return !RecipeUtil.getSieveRecipes(this.getStackInSlot(1).getItem(), stack).isEmpty();
            } else {
                return slot == 1 ? stack.is(EItemTags.SIEVE_MESHES) : false;
            }
        }

        public int getSlotLimit(int slot) {
            return slot == 1 ? 1 : super.getSlotLimit(slot);
        }

        public boolean canMachineExtract(int slot) {
            return slot > 1;
        }

        protected void onContentsChanged(int slot) {
            if (slot == 1) {
                this.sieve.logic.setMesh(this.sieve.inventory.getStackInSlot(1));
            }
        }

        protected void onLoad() {
            this.sieve.logic.setMesh(this.sieve.inventory.getStackInSlot(1), false);
        }
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(this.inventory.getSlots());
        for (int i = 0; i < this.inventory.getSlots(); i++) {
            inventory.setItem(i, this.inventory.getStackInSlot(i));
        }
        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
}
