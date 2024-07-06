package net.cathienova.havenede.block.mechanicalhammers;

import net.cathienova.havenede.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import thedarkcolour.exdeorum.block.MechanicalHammerBlock;

public class DiamondMechanicalHammerBlock extends MechanicalHammerBlock {
    public static final BooleanProperty RUNNING = BooleanProperty.create("running");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public DiamondMechanicalHammerBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(RUNNING, false));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return Block.box(0, 0, 0, 16, 16, 16);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DiamondMechanicalHammerBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, ModBlockEntities.DIAMOND_MECHANICAL_HAMMER.get(), DiamondMechanicalHammerBlockEntity::tick);
    }

    @Nullable
    private static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> wantedType, BlockEntityType<E> foundType, BlockEntityTicker<? super E> ticker) {
        return foundType == wantedType ? (BlockEntityTicker<A>) ticker : null;
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DiamondMechanicalHammerBlockEntity) {
                ((DiamondMechanicalHammerBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(state, world, pos, newState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof DiamondMechanicalHammerBlockEntity entity) {
            return entity.use(level, player, hand);
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, RUNNING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        CompoundTag nbt = BlockItem.getBlockEntityData(context.getItemInHand());
        BlockState state = this.defaultBlockState();
        if (nbt != null && nbt.contains("progress") && nbt.getInt("progress") != -1) {
            state = (BlockState)state.setValue(RUNNING, true);
        }

        return (BlockState)state.setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.is(state.getBlock())) {
            BlockEntity var7 = level.getBlockEntity(pos);
            if (var7 instanceof DiamondMechanicalHammerBlockEntity hammer) {
                hammer.checkPoweredState(level, pos);
            }
        }

    }

    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        BlockEntity var8 = level.getBlockEntity(pos);
        if (var8 instanceof DiamondMechanicalHammerBlockEntity hammer) {
            hammer.checkPoweredState(level, pos);
        }

    }
}
