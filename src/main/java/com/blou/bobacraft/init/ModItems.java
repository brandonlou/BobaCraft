package com.blou.bobacraft.init;

import com.blou.bobacraft.BobaCraft;
import com.blou.bobacraft.blockitems.*;
import com.blou.bobacraft.items.BobaBallItem;
import com.blou.bobacraft.items.CassavaRootItem;
import com.blou.bobacraft.items.TapiocaStarchItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    private static ModItems instance;
    public static ModItems getInstance(BobaCraft bobacraft) {
        if (instance == null) instance = new ModItems(bobacraft);
        return instance;
    }

    private final ModBlocks modBlocks;
    private final DeferredRegister<Item> items;
    private final RegistryObject<BlockItem> blackMilkTeaBlockItem;
    private final RegistryObject<Item> cassavaSeedItem;

    private ModItems(BobaCraft bobaCraft) {

        modBlocks = ModBlocks.getInstance(bobaCraft);
        items = DeferredRegister.create(ForgeRegistries.ITEMS, bobaCraft.getModID());

        // Regular items

        items.register("cassava_root_item", () -> new CassavaRootItem(bobaCraft));
        items.register("tapioca_starch_item", () -> new TapiocaStarchItem(bobaCraft));
        items.register("boba_ball_item", () -> new BobaBallItem(bobaCraft));

        // Block items

        blackMilkTeaBlockItem = items.register("black_milk_tea_block",
                () -> new BlackMilkTeaItem(modBlocks.getBlackMilkTeaBlock(), bobaCraft));

        items.register("jasmine_milk_tea_block",
                () -> new JasmineMilkTeaItem(modBlocks.getJasmineMilkTeaBlock(), bobaCraft));

        items.register("green_milk_tea_block",
                () -> new GreenMilkTeaItem(modBlocks.getGreenMilkTeaBlock(), bobaCraft));

        items.register("thai_milk_tea_block",
                () -> new ThaiMilkTeaItem(modBlocks.getThaiMilkTeaBlock(), bobaCraft));

        items.register("taro_milk_tea_block",
                () -> new TaroMilkTeaItem(modBlocks.getTaroMilkTeaBlock(), bobaCraft));

        items.register("strawberry_milk_tea_block",
                () -> new StrawberryMilkTeaItem(modBlocks.getStrawberryMilkTeaBlock(), bobaCraft));

        cassavaSeedItem = items.register("cassava_seed_item",
                () -> new BlockItem(modBlocks.getCassavaCropBlock(), new Item.Properties().group(bobaCraft.getTab())));

    }

    public DeferredRegister<Item> getItemsRegister() {
        return items;
    }

    public IItemProvider getCreativeTabIcon() {
        return blackMilkTeaBlockItem.get();
    }

    public IItemProvider getCassavaSeedItem() {
        return cassavaSeedItem.get();
    }

}
