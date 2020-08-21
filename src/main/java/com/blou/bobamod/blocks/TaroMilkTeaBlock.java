package com.blou.bobamod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TaroMilkTeaBlock extends Block {

    public TaroMilkTeaBlock() {
        super(AbstractBlock.Properties
                .create(Material.ICE)
                .hardnessAndResistance(1.0f)
                .sound(SoundType.SNOW)
                .variableOpacity());
    }

}
