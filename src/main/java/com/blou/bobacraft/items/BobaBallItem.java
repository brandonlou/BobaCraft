package com.blou.bobacraft.items;

import com.blou.bobacraft.BobaCraft;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class BobaBallItem extends Item {

    public BobaBallItem(BobaCraft bobaCraft) {
        super(new Item.Properties()
                .group(bobaCraft.getTab())
                .maxStackSize(64)
                .rarity(Rarity.UNCOMMON)
                .food(new Food.Builder()
                        .hunger(16)
                        .saturation(0.5f)
                        .setAlwaysEdible()
                        .build())
        );
    }

}
