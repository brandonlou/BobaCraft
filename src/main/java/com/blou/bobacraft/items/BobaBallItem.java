package com.blou.bobacraft.items;

import com.blou.bobacraft.BobaCraft;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class BobaItem extends Item {

    public BobaItem(BobaCraft bobaCraft) {
        super(new Item.Properties()
                .group(bobaCraft.getTab())
                .maxStackSize(64)
                .food(new Food.Builder()
                        .hunger(16)
                        .saturation(0.5f)
                        .setAlwaysEdible()
                        .build())
        );
    }

}
