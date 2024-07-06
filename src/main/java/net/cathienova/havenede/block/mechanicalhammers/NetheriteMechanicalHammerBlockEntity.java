package net.cathienova.havenede.block.mechanicalhammers;

import net.cathienova.havenede.block.ModBlockEntities;
import net.cathienova.havenede.config.HavenConfig;
import net.cathienova.havenede.menu.mechanicalhammers.NetheriteMechanicalHammerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thedarkcolour.exdeorum.blockentity.AbstractMachineBlockEntity;
import thedarkcolour.exdeorum.blockentity.helper.ItemHelper;
import thedarkcolour.exdeorum.loot.HammerLootModifier;
import thedarkcolour.exdeorum.recipe.RecipeUtil;
import thedarkcolour.exdeorum.recipe.hammer.HammerRecipe;
import thedarkcolour.exdeorum.tag.EItemTags;

import java.util.Objects;

public class NetheriteMechanicalHammerBlockEntity extends AbstractMachineBlockEntity<NetheriteMechanicalHammerBlockEntity> implements MenuProvider {
    public static final int TOTAL_PROGRESS = 10000000;
    private static final int BASE_PROGRESS_INTERVAL = 50000;
    private static final int NOT_RUNNING = -1;
    private int progress = NOT_RUNNING;
    private float efficiency;

    public NetheriteMechanicalHammerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.NETHERITE_MECHANICAL_HAMMER.get(), pos, state, NetheriteMechanicalHammerBlockEntity::createInventory, HavenConfig.netherite_mechanical_hammer_energyStorage);
        this.efficiency = 1.0F;
    }

    private static ItemHelper createInventory(NetheriteMechanicalHammerBlockEntity entity) {
        return new ItemHelper(3) {
            @Override
            public boolean isItemValid(int slot, ItemStack stack) {
                if (slot == 0) {
                    return RecipeUtil.getHammerRecipe(stack.getItem()) != null;
                } else if (slot == 1) {
                    return stack.is(EItemTags.HAMMERS);
                }
                return false;
            }

            @Override
            public int getSlotLimit(int slot) {
                return slot == 1 ? 1 : super.getSlotLimit(slot);
            }

            @Override
            public boolean canMachineExtract(int slot) {
                return slot == 2;
            }

            @Override
            protected void onContentsChanged(int slot) {
                if (slot == 1) {
                    entity.onHammerChanged();
                } else if (slot == 0 && this.getStackInSlot(0).isEmpty()) {
                    entity.progress = NOT_RUNNING;
                    entity.setRunning(false);
                }
            }
        };
    }

    @Override
    protected int getEnergyConsumption() {
        return HavenConfig.netherite_mechanical_hammer_energyConsumption;
    }

    private float calculateEfficiency() {
        return efficiency + (0.1F * HavenConfig.netherite_mechanical_hammer_speed);
    }

    @Override
    protected void runMachineTick() {
        ItemStack input = this.inventory.getStackInSlot(0);
        if (!input.isEmpty()) {
            HammerRecipe recipe = this.canFitResultIntoOutput(input);
            if (recipe != null) {
                float efficiencyMultiplier = calculateEfficiency();
                int progressIncrement = (int) (BASE_PROGRESS_INTERVAL * efficiencyMultiplier);
                this.progress += progressIncrement;
                if (this.progress >= TOTAL_PROGRESS) {
                    LootContext ctx = RecipeUtil.emptyLootContext((ServerLevel) this.level);
                    int resultCount = recipe.resultAmount.getInt(ctx);
                    resultCount += HammerLootModifier.calculateFortuneBonus(this.inventory.getStackInSlot(1), ctx.getRandom(), resultCount == 0);
                    ItemStack output = this.inventory.getStackInSlot(2);
                    if (output.isEmpty()) {
                        ItemStack stack = new ItemStack(recipe.result, resultCount);
                        stack.setTag(recipe.getResultNbt());
                        this.inventory.setStackInSlot(2, stack);
                    } else {
                        output.setCount(Math.min(output.getMaxStackSize(), resultCount + output.getCount()));
                    }

                    input.shrink(1);
                    this.damageHammer(ctx.getRandom());
                    this.setChanged();

                    this.progress = 0;
                }
                this.setRunning(true);
            } else {
                this.progress = NOT_RUNNING;
                this.setRunning(false);
            }
        } else {
            this.setRunning(false);
        }
    }

    private HammerRecipe canFitResultIntoOutput(ItemStack input) {
        ItemStack output = this.inventory.getStackInSlot(2);
        if (output.isEmpty() || output.getCount() < output.getMaxStackSize()) {
            HammerRecipe recipe = RecipeUtil.getHammerRecipe(input.getItem());
            if (recipe != null && (output.isEmpty() || matchesStack(recipe.result, recipe.getRawResultNbt(), output))) {
                return recipe;
            }
        }
        return null;
    }

    private static boolean matchesStack(Item item, @Nullable CompoundTag itemNbt, ItemStack stack) {
        return Objects.equals(itemNbt, stack.getTag()) && item == stack.getItem();
    }

    private void damageHammer(RandomSource rand) {
        ItemStack hammer = this.inventory.getStackInSlot(1);
        if (hammer.isDamageableItem() && hammer.hurt(1, rand, (ServerPlayer) null)) {
            hammer.shrink(1);
            if (hammer.isEmpty()) {
                this.inventory.setStackInSlot(1, ItemStack.EMPTY);
            }
        }
    }

    private boolean hasEnergy() {
        return getEnergyStored() >= getEnergyConsumption();
    }

    private boolean hasValidInput() {
        ItemStack input = this.inventory.getStackInSlot(0);
        return RecipeUtil.getHammerRecipe(input.getItem()) != null && !input.isEmpty();
    }

    private void consumeEnergy() {
        this.energy.extractEnergy(getEnergyConsumption(), false);
    }

    private void onHammerChanged() {
        ItemStack hammer = this.inventory.getStackInSlot(1);
        if (hammer.isEmpty()) {
            this.efficiency = 1.0F;
        } else {
            this.efficiency = 2.0F + (float)hammer.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY) * 0.33F;
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, NetheriteMechanicalHammerBlockEntity entity) {
        if (level != null && !level.isClientSide) {
            if (entity.redstoneMode == 0 || entity.redstoneMode == 1 != entity.hasRedstonePower) {
                if (entity.hasEnergy() && entity.hasValidInput()) {
                    entity.consumeEnergy();
                    entity.runMachineTick();
                } else {
                    entity.noEnergyTick();
                }
            }
        }
    }

    protected void noEnergyTick() {
        this.setRunning(false);
    }

    @Override
    protected boolean isRunning() {
        return this.progress != NOT_RUNNING;
    }

    @Override
    protected void tryStartRunning() {
        this.setRunning(true);
    }

    private void setRunning(boolean running) {
        this.level.setBlock(this.worldPosition, this.getBlockState().setValue(NetheriteMechanicalHammerBlock.RUNNING, running), 3);
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getEnergyStored() {
        return this.energy.getEnergyStored();
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.havenede.netherite_mechanical_hammer");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, @NotNull Player player) {
        return new NetheriteMechanicalHammerMenu(id, playerInventory, this);
    }

    public static boolean isValidInput(ItemStack stack) {
        return RecipeUtil.getHammerRecipe(stack.getItem()) != null;
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
