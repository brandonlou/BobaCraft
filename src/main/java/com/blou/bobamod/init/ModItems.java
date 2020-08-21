package com.blou.bobamod.init;

import com.blou.bobamod.BobaMod;
import com.blou.bobamod.blocks.BlockItemBase;
import com.blou.bobamod.items.ItemBase;
import com.blou.bobamod.items.ThaiTea;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BobaMod.MOD_ID);

    // Items
    public static final RegistryObject<Item> BLACK_TEA = ITEMS.register("black_tea", ItemBase::new);
    public static final RegistryObject<ThaiTea> THAI_TEA = ITEMS.register("thai_tea", ThaiTea::new);

    // Block Items
    public static final RegistryObject<Item> TARO_MILK_TEA_BLOCK_ITEM = ITEMS.register("taro_milk_tea_block",
            () -> new BlockItemBase(ModBlocks.TARO_MILK_TEA_BLOCK.get()));

}
