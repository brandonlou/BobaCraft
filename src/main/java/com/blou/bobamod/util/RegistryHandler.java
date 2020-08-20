package com.blou.bobamod.util;

import com.blou.bobamod.Boba;
import com.blou.bobamod.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Boba.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> BLACK_TEA = ITEMS.register("black_tea", ItemBase::new);

}
