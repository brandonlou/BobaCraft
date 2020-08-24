package com.blou.bobamod.init;

import com.blou.bobamod.BobaMod;
import com.blou.bobamod.blockitems.*;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    private static ModItems instance;
    public static ModItems getInstance(BobaMod bobaMod) {
        if(instance == null) instance = new ModItems(bobaMod);
        return instance;
    }

    private final ModBlocks modBlocks;
    private final DeferredRegister<Item> ITEMS;
    private final RegistryObject<Item>[] BOBA_ITEMS;

    private ModItems(BobaMod bobaMod) {
        modBlocks = ModBlocks.getInstance(bobaMod);
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, bobaMod.getModID());
        BOBA_ITEMS = new RegistryObject[]{
                ITEMS.register("black_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("black_milk_tea_block"), bobaMod)),
                ITEMS.register("jasmine_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("jasmine_milk_tea_block"), bobaMod)),
                ITEMS.register("green_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("green_milk_tea_block"), bobaMod)),
                ITEMS.register("thai_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("thai_milk_tea_block"), bobaMod)),
                ITEMS.register("taro_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("taro_milk_tea_block"), bobaMod)),
                ITEMS.register("strawberry_milk_tea_block", () -> new BobaItemBase(modBlocks.getBlock("strawberry_milk_tea_block"), bobaMod)),
        };
    }

    public DeferredRegister<Item> getItems() {
        return ITEMS;
    }

    public IItemProvider getCreativeTabIcon() {
        return BOBA_ITEMS[0].get();
    }

}
