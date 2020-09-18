package com.blou.bobacraft.init;

import com.blou.bobacraft.blockitems.*;
import com.blou.bobacraft.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    private static ModItems instance;
    public static ModItems getInstance(ItemGroup itemGroup, String modID) {
        if (instance == null) instance = new ModItems(itemGroup, modID);
        return instance;
    }

    private final ModBlocks modBlocks;
    private final DeferredRegister<Item> items;
    private final RegistryObject<Item> bobaBallItem, cassavaSeedItem;

    private ModItems(ItemGroup itemGroup, String modID) {

        modBlocks = ModBlocks.getInstance(itemGroup, modID);
        items = DeferredRegister.create(ForgeRegistries.ITEMS, modID);

        // Block items

        items.register("black_milk_tea_block",
                () -> new BlackMilkTeaItem(modBlocks.getBlackMilkTeaBlock(), itemGroup));

        items.register("jasmine_milk_tea_block",
                () -> new JasmineMilkTeaItem(modBlocks.getJasmineMilkTeaBlock(), itemGroup));

        items.register("green_milk_tea_block",
                () -> new GreenMilkTeaItem(modBlocks.getGreenMilkTeaBlock(), itemGroup));

        items.register("thai_milk_tea_block",
                () -> new ThaiMilkTeaItem(modBlocks.getThaiMilkTeaBlock(), itemGroup));

        items.register("taro_milk_tea_block",
                () -> new TaroMilkTeaItem(modBlocks.getTaroMilkTeaBlock(), itemGroup));

        items.register("strawberry_milk_tea_block",
                () -> new StrawberryMilkTeaItem(modBlocks.getStrawberryMilkTeaBlock(), itemGroup));

        cassavaSeedItem = items.register("cassava_seed_item",
                () -> new CassavaSeedItem(modBlocks.getCassavaCropBlock(), itemGroup));

        // Regular items

        bobaBallItem = items.register("boba_ball_item", () -> new BobaBallItem(itemGroup));
        items.register("boba_popsicle_item", () -> new BobaPopsicleItem(itemGroup));
        items.register("popcorn_chicken_item", () -> new PopcornChickenItem(itemGroup));
        items.register("cassava_root_item", () -> new CassavaRootItem(itemGroup));
        items.register("tapioca_starch_item", () -> new TapiocaStarchItem(itemGroup));

    }

    public DeferredRegister<Item> getItemsRegister() {
        return items;
    }

    public IItemProvider getCreativeTabIcon() {
        return bobaBallItem.get();
    }

    public IItemProvider getCassavaSeedItem() {
        return cassavaSeedItem.get();
    }

}
