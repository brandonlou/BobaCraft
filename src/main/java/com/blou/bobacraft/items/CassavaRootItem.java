package com.blou.bobacraft.items;

import com.blou.bobacraft.BobaCraft;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class CassavaRootItem extends Item {

    private static final int maxStackSize = 64;
    private static final int hunger = 4; // Restores 2 hearts.
    private static final float saturation = 1.0f;

    public CassavaRootItem(BobaCraft bobaCraft) {

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
