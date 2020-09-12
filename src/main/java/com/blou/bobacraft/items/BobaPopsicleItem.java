package com.blou.bobacraft.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;

public class BobaPopsicleItem extends Item {

    private static final int maxStackSize = 16;
    private static final int hunger = 16; // Restores 8 hearts.
    private static final float saturation = 1.2f;

    public BobaPopsicleItem(ItemGroup itemGroup) {
        super(new Item.Properties()
            .group(itemGroup)
            .maxStackSize(maxStackSize)
            .rarity(Rarity.COMMON)
            .food(new Food.Builder()
                    .hunger(hunger)
                    .saturation(saturation)
                    .setAlwaysEdible()
                    .build()));
    }

}
