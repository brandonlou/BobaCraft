package com.blou.bobamod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.ParametersAreNonnullByDefault;

public abstract class BobaBlockBase extends DirectionalBlock {

    private static final float HARDNESS_AND_RESISTANCE = 0.3f;
    private static final float LIGHT_VALUE = 0.5f;

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

    abstract VoxelShape getShapeN();
    abstract VoxelShape getShapeE();
    abstract VoxelShape getShapeS();
    abstract VoxelShape getShapeW();

    @Override
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return getShapeN();
            case EAST:
                return getShapeE();
            case SOUTH:
                return getShapeS();
            case WEST:
                return getShapeW();
            default:
                return getShapeN();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
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

}
