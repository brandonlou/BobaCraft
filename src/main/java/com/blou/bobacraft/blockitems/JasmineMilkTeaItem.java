package com.blou.bobacraft.blockitems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class JasmineMilkTeaItem extends BobaItemBase {

    private static final int duration = 300; // 300 ticks * 1 sec/20 ticks = 15 sec
    private static final int amplifier = 0; // Level 1 effect.

    public JasmineMilkTeaItem(Block block, ItemGroup itemGroup) {

        super(block, () -> new EffectInstance(Effects.SPEED, duration, amplifier), itemGroup);

    }

}
