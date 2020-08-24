package com.blou.bobamod.init;

import com.blou.bobamod.BobaMod;
import com.blou.bobamod.blockitems.*;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    private static ModItems instance;
    public static ModItems getInstance(BobaMod bobaMod) {
        if (instance == null) instance = new ModItems(bobaMod);
        return instance;
    }

    private final ModBlocks modBlocks;
    private final DeferredRegister<Item> items;
    private final List<RegistryObject<Item>> bobaItems;

    private ModItems(BobaMod bobaMod) {
        modBlocks = ModBlocks.getInstance(bobaMod);
        items = DeferredRegister.create(ForgeRegistries.ITEMS, bobaMod.getModID());

        bobaItems = new ArrayList<RegistryObject<Item>>() {{
            add(items.register("black_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("black_milk_tea_block"), bobaMod)));
            add(items.register("jasmine_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("jasmine_milk_tea_block"), bobaMod)));
            add(items.register("green_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("green_milk_tea_block"), bobaMod)));
            add(items.register("thai_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("thai_milk_tea_block"), bobaMod)));
            add(items.register("taro_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("taro_milk_tea_block"), bobaMod)));
            add(items.register("strawberry_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("strawberry_milk_tea_block"), bobaMod)));
        }};

    }

    public DeferredRegister<Item> getItems() {
        return items;
    }

    public IItemProvider getCreativeTabIcon() {
        return bobaItems.get(0).get();
    }

}
