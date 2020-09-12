package com.blou.bobacraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;

public class TapiocaStarchItem extends Item {

    public TapiocaStarchItem(ItemGroup itemGroup) {

        super(new Item.Properties()
            .group(itemGroup)
            .maxStackSize(64)
            .rarity(Rarity.COMMON)
        );

    }
}
