package com.blou.bobamod.init;

import com.blou.bobamod.BobaMod;
import com.blou.bobamod.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;

public class ModBlocks {

    private static ModBlocks instance;
    public static ModBlocks getInstance(BobaMod bobaMod) {
        if(instance == null) instance = new ModBlocks(bobaMod);
        return instance;
    }

    private final DeferredRegister<Block> BLOCKS;
    private final HashMap<String, RegistryObject<Block>> BOBA_BLOCKS;

    private ModBlocks(BobaMod bobaMod) {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, bobaMod.getModID());
        BOBA_BLOCKS = new HashMap<String, RegistryObject<Block>>() {{
            put("black_milk_tea_block", BLOCKS.register("black_milk_tea_block", BlackMilkTeaBlock::new));
            put("thai_milk_tea_block", BLOCKS.register("thai_milk_tea_block", ThaiMilkTeaBlock::new));
            put("green_milk_tea_block", BLOCKS.register("green_milk_tea_block", GreenMilkTeaBlock::new));
            put("jasmine_milk_tea_block", BLOCKS.register("jasmine_milk_tea_block", JasmineMilkTeaBlock::new));
            put("taro_milk_tea_block", BLOCKS.register("taro_milk_tea_block", TaroMilkTeaBlock::new));
            put("strawberry_milk_tea_block", BLOCKS.register("strawberry_milk_tea_block", StrawberryMilkTeaBlock::new));
        }};

    }

    public DeferredRegister<Block> getBlocksRegister() {
        return BLOCKS;
    }

    public Block getBlock(String key) {
        return BOBA_BLOCKS.get(key).get();
    }

}
