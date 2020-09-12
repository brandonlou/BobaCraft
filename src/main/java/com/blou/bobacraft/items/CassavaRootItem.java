package com.blou.bobacraft.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;

public class CassavaRootItem extends Item {

    private static final int maxStackSize = 64;
    private static final int hunger = 4; // Restores 2 hearts.
    private static final float saturation = 1.0f;

    public CassavaRootItem(ItemGroup itemGroup) {

        super(new Item.Properties()
            .group(itemGroup)
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
