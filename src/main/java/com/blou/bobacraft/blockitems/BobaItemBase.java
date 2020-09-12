package com.blou.bobacraft.blockitems;

import com.blou.bobacraft.BobaCraft;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class BobaItemBase extends BlockItem {

    private static final int MAX_STACK_SIZE = 16;
    private static final int HEALTH_REGEN = 16;

    public BobaItemBase(Block block, BobaCraft bobaCraft) {
        super(block, new Item.Properties()
                .group(bobaCraft.getTab())
                .maxStackSize(MAX_STACK_SIZE)
                .rarity(Rarity.UNCOMMON)
                .food(new Food.Builder()
                        .hunger(HEALTH_REGEN)
                        .saturation(1.2f)
                        // 25% chance for level 1 speed effect for 15 seconds (15 secs * 20 ticks/sec = 300 ticks)
                        .effect(() -> new EffectInstance(Effects.SPEED, 300, 0), 0.25f)
                        .setAlwaysEdible() // You can eat it even if you're not hungry.
                        .build()));
    }

    @Override @Nonnull
    @ParametersAreNonnullByDefault
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

}
