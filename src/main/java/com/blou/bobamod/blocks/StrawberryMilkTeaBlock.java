package com.blou.bobamod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.stream.Stream;

public class StrawberryMilkTeaBlock extends DirectionalBlock {

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7.5, 12.25, 7.5, 8.5, 16, 8.5),
            Block.makeCuboidShape(6, 0, 4, 10, 12, 5),
            Block.makeCuboidShape(6, 0, 11, 10, 12, 12),
            Block.makeCuboidShape(6, 12, 11, 10, 12.25, 12.5),
            Block.makeCuboidShape(6, 12, 3.5, 10, 12.25, 5),
            Block.makeCuboidShape(4, 0, 6, 5, 12, 10),
            Block.makeCuboidShape(11, 0, 6, 12, 12, 10),
            Block.makeCuboidShape(11, 12, 6, 12.5, 12.25, 10),
            Block.makeCuboidShape(3.5, 12, 6, 5, 12.25, 10),
            Block.makeCuboidShape(9.353553390593273, 0, 4.560660171779822, 12.181980515293272, 12, 5.560660171779822),
            Block.makeCuboidShape(4.060660171812483, 0, 9.853553390625937, 6.889087296512482, 12, 10.853553390625937),
            Block.makeCuboidShape(3.310660171779821, 12, 9.707106781186548, 6.8461940776798205, 12.25, 10.957106781186548),
            Block.makeCuboidShape(5.042893218813452, 12, 3.310660171779821, 6.292893218813452, 12.25, 6.8461940776798205),
            Block.makeCuboidShape(10.659009742307118, 12, 8.926776695319786, 11.909009742307118, 12.25, 12.462310601219786),
            Block.makeCuboidShape(8.926776695319786, 12, 4.090990257692881, 12.462310601219786, 12.25, 5.340990257692881),
            Block.makeCuboidShape(10.439339828187517, 0, 9.353553390625937, 11.439339828187517, 12, 12.181980515325936),
            Block.makeCuboidShape(5.146446609406727, 0, 4.060660171779821, 6.146446609406727, 12, 6.88908729647982),
            Block.makeCuboidShape(5, 0, 5, 11, 12, 11),
            Block.makeCuboidShape(5, 12, 5, 11, 12.25, 11))
            .reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(7.5, 12.25, 7.5, 8.5, 16, 8.5),
            Block.makeCuboidShape(4, 0, 6, 5, 12, 10),
            Block.makeCuboidShape(11, 0, 6, 12, 12, 10),
            Block.makeCuboidShape(11, 12, 6, 12.5, 12.25, 10),
            Block.makeCuboidShape(3.5, 12, 6, 5, 12.25, 10),
            Block.makeCuboidShape(6, 0, 11, 10, 12, 12),
            Block.makeCuboidShape(6, 0, 4, 10, 12, 5),
            Block.makeCuboidShape(6, 12, 3.5, 10, 12.25, 5),
            Block.makeCuboidShape(6, 12, 11, 10, 12.25, 12.5),
            Block.makeCuboidShape(6.585786437626904, 0, 3.757359312880716, 9.414213562326903, 12, 4.757359312880716),
            Block.makeCuboidShape(6.585786437673097, 0, 11.242640687119286, 9.414213562373096, 12, 12.242640687119286),
            Block.makeCuboidShape(6.232233047033631, 12, 11.34619407771256, 9.76776695293363, 12.25, 12.59619407771256),
            Block.makeCuboidShape(3.4038059222874395, 12, 6.232233047033631, 4.6538059222874395, 12.25, 9.76776695293363),
            Block.makeCuboidShape(11.346194077712559, 12, 6.232233047066369, 12.596194077712559, 12.25, 9.767766952966369),
            Block.makeCuboidShape(6.232233047066369, 12, 3.4038059222874395, 9.767766952966369, 12.25, 4.6538059222874395),
            Block.makeCuboidShape(11.242640687119286, 0, 6.585786437673097, 12.242640687119286, 12, 9.414213562373096),
            Block.makeCuboidShape(3.757359312880716, 0, 6.585786437626904, 4.757359312880716, 12, 9.414213562326903),
            Block.makeCuboidShape(5, 0, 5, 11, 12, 11),
            Block.makeCuboidShape(5, 12, 5, 11, 12.25, 11))
            .reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7.5, 12.25, 7.5, 8.5, 16, 8.5),
            Block.makeCuboidShape(6, 0, 11, 10, 12, 12),
            Block.makeCuboidShape(6, 0, 4, 10, 12, 5),
            Block.makeCuboidShape(6, 12, 3.5, 10, 12.25, 5),
            Block.makeCuboidShape(6, 12, 11, 10, 12.25, 12.5),
            Block.makeCuboidShape(11, 0, 6, 12, 12, 10),
            Block.makeCuboidShape(4, 0, 6, 5, 12, 10),
            Block.makeCuboidShape(3.5, 12, 6, 5, 12.25, 10),
            Block.makeCuboidShape(11, 12, 6, 12.5, 12.25, 10),
            Block.makeCuboidShape(3.757359312880716, 0, 6.585786437673097, 4.757359312880716, 12, 9.414213562373096),
            Block.makeCuboidShape(11.242640687119286, 0, 6.585786437626904, 12.242640687119286, 12, 9.414213562326903),
            Block.makeCuboidShape(11.34619407771256, 12, 6.232233047066369, 12.59619407771256, 12.25, 9.767766952966369),
            Block.makeCuboidShape(6.232233047033631, 12, 11.34619407771256, 9.76776695293363, 12.25, 12.59619407771256),
            Block.makeCuboidShape(6.232233047066369, 12, 3.4038059222874413, 9.767766952966369, 12.25, 4.653805922287441),
            Block.makeCuboidShape(3.4038059222874395, 12, 6.232233047033631, 4.6538059222874395, 12.25, 9.76776695293363),
            Block.makeCuboidShape(6.585786437673097, 0, 3.7573593128807143, 9.414213562373096, 12, 4.757359312880714),
            Block.makeCuboidShape(6.585786437626904, 0, 11.242640687119284, 9.414213562326903, 12, 12.242640687119284),
            Block.makeCuboidShape(5, 0, 5, 11, 12, 11),
            Block.makeCuboidShape(5, 12, 5, 11, 12.25, 11))
            .reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7.5, 12.25, 7.5, 8.5, 16, 8.5),
            Block.makeCuboidShape(11, 0, 6, 12, 12, 10),
            Block.makeCuboidShape(4, 0, 6, 5, 12, 10),
            Block.makeCuboidShape(3.5, 12, 6, 5, 12.25, 10),
            Block.makeCuboidShape(11, 12, 6, 12.5, 12.25, 10),
            Block.makeCuboidShape(6, 0, 4, 10, 12, 5),
            Block.makeCuboidShape(6, 0, 11, 10, 12, 12),
            Block.makeCuboidShape(6, 12, 11, 10, 12.25, 12.5),
            Block.makeCuboidShape(6, 12, 3.5, 10, 12.25, 5),
            Block.makeCuboidShape(11.242640687119284, 0, 6.585786437626904, 12.242640687119284, 12, 9.414213562326903),
            Block.makeCuboidShape(3.7573593128807143, 0, 6.585786437673097, 4.757359312880714, 12, 9.414213562373096),
            Block.makeCuboidShape(3.4038059222874395, 12, 6.232233047033631, 4.6538059222874395, 12.25, 9.76776695293363),
            Block.makeCuboidShape(6.232233047066369, 12, 3.4038059222874395, 9.767766952966369, 12.25, 4.6538059222874395),
            Block.makeCuboidShape(6.232233047033631, 12, 11.346194077712559, 9.76776695293363, 12.25, 12.596194077712559),
            Block.makeCuboidShape(11.34619407771256, 12, 6.232233047066369, 12.59619407771256, 12.25, 9.767766952966369),
            Block.makeCuboidShape(6.585786437626904, 0, 11.242640687119286, 9.414213562326903, 12, 12.242640687119286),
            Block.makeCuboidShape(6.585786437673097, 0, 3.757359312880716, 9.414213562373096, 12, 4.757359312880716),
            Block.makeCuboidShape(5, 0, 5, 11, 12, 11),
            Block.makeCuboidShape(5, 12, 5, 11, 12.25, 11))
            .reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public StrawberryMilkTeaBlock() {
        super(AbstractBlock.Properties
                .create(Material.ICE)
                .hardnessAndResistance(0.3f)
                .sound(SoundType.SNOW)
                .notSolid()
                .variableOpacity()
                .setAllowsSpawn(StrawberryMilkTeaBlock::neverAllowSpawn)
                .setOpaque(StrawberryMilkTeaBlock::isntSolid)
                .setSuffocates(StrawberryMilkTeaBlock::isntSolid)
                .setBlocksVision(StrawberryMilkTeaBlock::isntSolid));
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

//    public VoxelShape getRayTraceShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
//        return VoxelShapes.empty();
//    }

    @Override
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
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
        return 0.5f;
    }

}
