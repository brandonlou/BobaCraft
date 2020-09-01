package com.blou.bobacraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.stream.Stream;

public abstract class BobaBlockBase extends DirectionalBlock {

    private static final float HARDNESS_AND_RESISTANCE = 0.3f;
    private static final float LIGHT_VALUE = 0.5f;

    private static final VoxelShape NORTH = Stream.of(
            Block.makeCuboidShape(5.75, 6, 10.25, 10.25, 9, 10.5),
            Block.makeCuboidShape(5.75, 0, 5.75, 10.25, 0.25, 10.25),
            Block.makeCuboidShape(5.75, 8.75, 5.75, 10.25, 9, 10.25),
            Block.makeCuboidShape(5.75, 0.25, 10, 10.25, 6, 10.25),
            Block.makeCuboidShape(10, 0.25, 6, 10.25, 6, 10),
            Block.makeCuboidShape(5.75, 0.25, 6, 6, 6, 10),
            Block.makeCuboidShape(5.5, 6, 5.5, 5.75, 9, 10.5),
            Block.makeCuboidShape(10.25, 6, 5.5, 10.5, 9, 10.5),
            Block.makeCuboidShape(5.75, 0.25, 5.75, 10.25, 6, 6),
            Block.makeCuboidShape(5.75, 6, 5.5, 10.25, 9, 5.75),
            Block.makeCuboidShape(7.5, 8.75, 7.5, 8.5, 12, 8.5),
            Block.makeCuboidShape(6, 0.25, 6, 10, 6, 10),
            Block.makeCuboidShape(5.75, 6, 5.75, 10.25, 8.75, 10.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape EAST = Stream.of(
            Block.makeCuboidShape(10.25, 6, 5.75, 10.5, 9, 10.25),
            Block.makeCuboidShape(5.75, 0, 5.75, 10.25, 0.25, 10.25),
            Block.makeCuboidShape(5.75, 8.75, 5.75, 10.25, 9, 10.25),
            Block.makeCuboidShape(10, 0.25, 5.75, 10.25, 6, 10.25),
            Block.makeCuboidShape(6, 0.25, 5.75, 10, 6, 6),
            Block.makeCuboidShape(6, 0.25, 10, 10, 6, 10.25),
            Block.makeCuboidShape(5.5, 6, 10.25, 10.5, 9, 10.5),
            Block.makeCuboidShape(5.5, 6, 5.5, 10.5, 9, 5.75),
            Block.makeCuboidShape(5.75, 0.25, 5.75, 6, 6, 10.25),
            Block.makeCuboidShape(5.5, 6, 5.75, 5.75, 9, 10.25),
            Block.makeCuboidShape(7.5, 8.75, 7.5, 8.5, 12, 8.5),
            Block.makeCuboidShape(6, 0.25, 6, 10, 6, 10),
            Block.makeCuboidShape(5.75, 6, 5.75, 10.25, 8.75, 10.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SOUTH = Stream.of(
            Block.makeCuboidShape(5.75, 6, 5.5, 10.25, 9, 5.75),
            Block.makeCuboidShape(5.75, 0, 5.75, 10.25, 0.25, 10.25),
            Block.makeCuboidShape(5.75, 8.75, 5.75, 10.25, 9, 10.25),
            Block.makeCuboidShape(5.75, 0.25, 5.75, 10.25, 6, 6),
            Block.makeCuboidShape(5.75, 0.25, 6, 6, 6, 10),
            Block.makeCuboidShape(10, 0.25, 6, 10.25, 6, 10),
            Block.makeCuboidShape(10.25, 6, 5.5, 10.5, 9, 10.5),
            Block.makeCuboidShape(5.5, 6, 5.5, 5.75, 9, 10.5),
            Block.makeCuboidShape(5.75, 0.25, 10, 10.25, 6, 10.25),
            Block.makeCuboidShape(5.75, 6, 10.25, 10.25, 9, 10.5),
            Block.makeCuboidShape(7.5, 8.75, 7.5, 8.5, 12, 8.5),
            Block.makeCuboidShape(6, 0.25, 6, 10, 6, 10),
            Block.makeCuboidShape(5.75, 6, 5.75, 10.25, 8.75, 10.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape WEST = Stream.of(
            Block.makeCuboidShape(5.5, 6, 5.75, 5.75, 9, 10.25),
            Block.makeCuboidShape(5.75, 0, 5.75, 10.25, 0.25, 10.25),
            Block.makeCuboidShape(5.75, 8.75, 5.75, 10.25, 9, 10.25),
            Block.makeCuboidShape(5.75, 0.25, 5.75, 6, 6, 10.25),
            Block.makeCuboidShape(6, 0.25, 10, 10, 6, 10.25),
            Block.makeCuboidShape(6, 0.25, 5.75, 10, 6, 6),
            Block.makeCuboidShape(5.5, 6, 5.5, 10.5, 9, 5.75),
            Block.makeCuboidShape(5.5, 6, 10.25, 10.5, 9, 10.5),
            Block.makeCuboidShape(10, 0.25, 5.75, 10.25, 6, 10.25),
            Block.makeCuboidShape(10.25, 6, 5.75, 10.5, 9, 10.25),
            Block.makeCuboidShape(7.5, 8.75, 7.5, 8.5, 12, 8.5),
            Block.makeCuboidShape(6, 0.25, 6, 10, 6, 10),
            Block.makeCuboidShape(5.75, 6, 5.75, 10.25, 8.75, 10.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public BobaBlockBase() {
        super(AbstractBlock.Properties
                .create(Material.ICE)
                .hardnessAndResistance(HARDNESS_AND_RESISTANCE)
                .sound(SoundType.SNOW)
                .notSolid()
                .variableOpacity()
                .setAllowsSpawn(BobaBlockBase::neverAllowSpawn)
                .setOpaque(BobaBlockBase::isntSolid)
                .setSuffocates(BobaBlockBase::isntSolid)
                .setBlocksVision(BobaBlockBase::isntSolid));
    }

    private static boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return false;
    }

    private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    @Override @Nonnull
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return NORTH;
            case EAST:
                return EAST;
            case SOUTH:
                return SOUTH;
            case WEST:
                return WEST;
            default:
                return NORTH;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override @Nonnull
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override @Nonnull
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    @ParametersAreNonnullByDefault
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return LIGHT_VALUE;
    }

    @Override @Nonnull
    @ParametersAreNonnullByDefault
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return !worldIn.isAirBlock(pos.down());
    }

}
