package com.blou.bobamod.init;

import com.blou.bobamod.BobaMod;
import com.blou.bobamod.blockitems.BlackMilkTeaItem;
import com.blou.bobamod.blockitems.StrawberryMilkTeaItem;
import com.blou.bobamod.blockitems.TaroMilkTeaItem;
import com.blou.bobamod.blockitems.ThaiMilkTeaItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BobaMod.MOD_ID);

//    public static final RegistryObject<BlackMilkTeaItem> BLACK_MILK_TEA_BLOCK_ITEM = ITEMS.register("black_milk_tea_block",
//            () -> new BlackMilkTeaItem(ModBlocks.BLACK_MILK_TEA_BLOCK.get()));
//
    public static final RegistryObject<ThaiMilkTeaItem> THAI_MILK_TEA_BLOCK_ITEM = ITEMS.register("thai_milk_tea_block",
            () -> new ThaiMilkTeaItem(ModBlocks.THAI_MILK_TEA_BLOCK.get()));

    public static final RegistryObject<TaroMilkTeaItem> TARO_MILK_TEA_BLOCK_ITEM = ITEMS.register("taro_milk_tea_block",
            () -> new TaroMilkTeaItem(ModBlocks.TARO_MILK_TEA_BLOCK.get()));

    public static final RegistryObject<StrawberryMilkTeaItem> STRAWBERRY_MILK_TEA_BLOCK_ITEM = ITEMS.register("strawberry_milk_tea_block",
            () -> new StrawberryMilkTeaItem(ModBlocks.STRAWBERRY_MILK_TEA_BLOCK.get()));

}
