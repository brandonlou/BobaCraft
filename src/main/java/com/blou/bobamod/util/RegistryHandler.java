package com.blou.bobamod.util;

import com.blou.bobamod.BobaMod;
import com.blou.bobamod.blocks.BlockItemBase;
import com.blou.bobamod.blocks.TaroMilkTeaBlock;
import com.blou.bobamod.items.ItemBase;
import com.blou.bobamod.items.ThaiTea;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BobaMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BobaMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> BLACK_TEA = ITEMS.register("black_tea", ItemBase::new);
    public static final RegistryObject<ThaiTea> THAI_TEA = ITEMS.register("thai_tea", ThaiTea::new);

    // Blocks
    public static final RegistryObject<Block> TARO_MILK_TEA_BLOCK = BLOCKS.register("taro_milk_tea_block", TaroMilkTeaBlock::new);

    // Block Items
    public static final RegistryObject<Item> TARO_MILK_TEA_BLOCK_ITEM = ITEMS.register("taro_milk_tea_block", () -> new BlockItemBase(TARO_MILK_TEA_BLOCK.get()));

}
