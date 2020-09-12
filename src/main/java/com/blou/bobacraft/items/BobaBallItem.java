package com.blou.bobacraft.items;

import com.blou.bobacraft.BobaCraft;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class BobaBallItem extends Item {

    private static final int maxStackSize = 64;
    private static final int hunger = 16;
    private static final float saturation = 1.0f;

    public BobaBallItem(BobaCraft bobaCraft) {

        super(new Item.Properties()
                .group(bobaCraft.getTab())
                .maxStackSize(maxStackSize)
                .rarity(Rarity.UNCOMMON)
                .food(new Food.Builder()
                        .hunger(hunger)
                        .saturation(saturation)
                        .setAlwaysEdible()
                        .build())
        );

    }

}
