package com.blou.bobamod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TaroMilkTeaBlock extends Block {

    public TaroMilkTeaBlock() {
        super(AbstractBlock.Properties
                .create(Material.ICE)
                .hardnessAndResistance(1.0f, 1.0f)
                .sound(SoundType.SNOW)
                .harvestLevel(0) // Minimum wood tier
                .harvestTool(ToolType.HOE));
    }

}
