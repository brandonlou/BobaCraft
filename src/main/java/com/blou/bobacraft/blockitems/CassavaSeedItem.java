package com.blou.bobacraft.blockitems;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;

public class CassavaSeedItem extends BlockItem {

    private static final int maxStackSize = 64;

    public CassavaSeedItem(Block block, ItemGroup itemGroup) {
        super(block, new Item.Properties()
            .group(itemGroup)
            .maxStackSize(maxStackSize)
            .rarity(Rarity.COMMON));
    }

}
