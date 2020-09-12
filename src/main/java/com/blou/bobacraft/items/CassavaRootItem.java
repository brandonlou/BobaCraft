package com.blou.bobacraft.items;

import com.blou.bobacraft.BobaCraft;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class CassavaRootItem extends Item {

    public CassavaRootItem(BobaCraft bobaCraft) {

        super(new Item.Properties()
            .group(bobaCraft.getTab())
                .maxStackSize(64)
                .rarity(Rarity.UNCOMMON)
        );

    }
}
