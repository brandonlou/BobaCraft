package com.blou.bobamod.init;

import com.blou.bobamod.BobaMod;
import com.blou.bobamod.blocks.TaroMilkTeaBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BobaMod.MOD_ID);

    public static final RegistryObject<Block> TARO_MILK_TEA_BLOCK = BLOCKS.register("taro_milk_tea_block", TaroMilkTeaBlock::new);

}
