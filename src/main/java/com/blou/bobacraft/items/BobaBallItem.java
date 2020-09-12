package com.blou.bobacraft.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;

public class BobaBallItem extends Item {

    private static final int maxStackSize = 64;
    private static final int hunger = 1; // Restores half a heart.
    private static final float saturation = 0.5f;

    public BobaBallItem(ItemGroup itemGroup) {

        super(new Item.Properties()
                .group(itemGroup)
                .maxStackSize(maxStackSize)
                .rarity(Rarity.COMMON)
                .food(new Food.Builder()
                        .hunger(hunger)
                        .saturation(saturation)
                        .fastToEat()
                        .setAlwaysEdible()
                        .build())
        );

    }

}
