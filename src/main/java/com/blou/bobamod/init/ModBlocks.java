package com.blou.bobamod.init;

import com.blou.bobamod.BobaMod;
import com.blou.bobamod.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BobaMod.MOD_ID);

//    public static final RegistryObject<Block> BLACK_MILK_TEA_BLOCK = BLOCKS.register("black_milk_tea_block", BlackMilkTeaBlock::new);
//    public static final RegistryObject<Block> THAI_MILK_TEA_BLOCK = BLOCKS.register("thai_milk_tea_block", ThaiMilkTeaBlock::new);
//    public static final RegistryObject<Block> GREEN_MILK_TEA_BLOCK = BLOCKS.register("green_milk_tea_block", GreenMilkTeaBlock::new);
//    public static final RegistryObject<Block> JASMINE_MILK_TEA_BLOCK = BLOCKS.register("jasmine_milk_tea_block", JasmineMilkTeaBlock::new);
    public static final RegistryObject<Block> TARO_MILK_TEA_BLOCK = BLOCKS.register("taro_milk_tea_block", TaroMilkTeaBlock::new);
    public static final RegistryObject<Block> STRAWBERRY_MILK_TEA_BLOCK = BLOCKS.register("strawberry_milk_tea_block", StrawberryMilkTeaBlock::new);

}
