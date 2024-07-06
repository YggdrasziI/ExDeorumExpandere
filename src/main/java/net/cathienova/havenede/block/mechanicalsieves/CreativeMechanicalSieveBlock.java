package net.cathienova.havenede.block.mechanicalsieves;

import net.cathienova.havenede.block.ModBlockEntities;
import net.cathienova.havenede.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import thedarkcolour.exdeorum.block.EBlock;

import java.util.List;

public class CreativeMechanicalSieveBlock extends EBlock {
    private static final VoxelShape SHAPE = Shapes.or(box(0.0, 8.0, 0.0, 16.0, 16.0, 16.0), box(1.0, 0.0, 1.0, 3.0, 8.0, 3.0), box(1.0, 0.0, 13.0, 3.0, 8.0, 15.0), box(13.0, 0.0, 1.0, 15.0, 8.0, 3.0), box(13.0, 0.0, 13.0, 15.0, 8.0, 15.0));

    public CreativeMechanicalSieveBlock(BlockBehaviour.Properties properties) {
        super(properties, ModBlockEntities.CREATIVE_MECHANICAL_SIEVE);
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == ModBlockEntities.CREATIVE_MECHANICAL_SIEVE.get() && !level.isClientSide ? (BlockEntityTicker<T>) new CreativeMechanicalSieveBlockEntity.ServerTicker<CreativeMechanicalSieveBlockEntity>() : null;
    }

    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        CompoundTag nbt = BlockItem.getBlockEntityData(stack);
        if (nbt != null) {
            CompoundTag inventoryNbt = nbt.getCompound("inventory");
            ItemStackHandler inventory = new ItemStackHandler();
            inventory.deserializeNBT(inventoryNbt);
            ItemStack mesh = inventory.getStackInSlot(1);
            if (!mesh.isEmpty()) {
                tooltip.add(Component.translatable("item.havenede.creative_mechanical_sieve.mesh_label").append(Component.translatable(mesh.getDescriptionId())));
            }

            int energy = nbt.getInt("energy");
            tooltip.add(Component.translatable("gui.havenede.energy_label").append(Component.translatable("item.havenede.energy_display", energy, HavenConfig.creative_mechanical_sieve_energyStorage)).append(" FE"));
        }
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative() && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof CreativeMechanicalSieveBlockEntity sieve) {
                if (!sieve.getLogic().getMesh().isEmpty()) {
                    ItemStack stack = new ItemStack(this);
                    BlockItem.setBlockEntityData(stack, ModBlockEntities.CREATIVE_MECHANICAL_SIEVE.get(), sieve.saveWithoutMetadata());
                    ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack);
                    itemEntity.setDefaultPickUpDelay();
                    level.addFreshEntity(itemEntity);
                }
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.is(state.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof CreativeMechanicalSieveBlockEntity sieve) {
                sieve.checkPoweredState(level, pos);
            }
        }
    }

    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CreativeMechanicalSieveBlockEntity sieve) {
            sieve.checkPoweredState(level, pos);
        }
    }

    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CreativeMechanicalSieveBlockEntity) {
                ((CreativeMechanicalSieveBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(state, world, pos, newState, isMoving);
    }
}
