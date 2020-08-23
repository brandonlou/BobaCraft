package com.blou.bobamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.stream.Stream;

public class ThaiMilkTeaBlock extends BobaBlockBase {

    @Override
    VoxelShape getShapeN() {
        return Stream.of(
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
        ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    }

    @Override
    VoxelShape getShapeE() {
        return Stream.of(
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
        ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    }

    @Override
    VoxelShape getShapeS() {
        return Stream.of(
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
        ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    }

    @Override
    VoxelShape getShapeW() {
        return Stream.of(
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
        ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    }

}
