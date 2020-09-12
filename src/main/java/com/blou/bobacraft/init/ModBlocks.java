package com.blou.bobacraft.init;

import com.blou.bobacraft.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    private static ModBlocks instance;
    public static ModBlocks getInstance(ItemGroup itemGroup, String modID) {
        if(instance == null) instance = new ModBlocks(itemGroup, modID);
        return instance;
    }

    private final DeferredRegister<Block> blocks;
    private final RegistryObject<Block> blackMilkTeaBlock, thaiMilkTeaBlock, greenMilkTeaBlock, jasmineMilkTeaBlock,
        taroMilkTeaBlock, strawberryMilkTeaBlock, cassavaCropBlock;

    private ModBlocks(ItemGroup itemGroup, String modID) {

        blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, modID);

        blackMilkTeaBlock = blocks.register("black_milk_tea_block", BlackMilkTeaBlock::new);
        thaiMilkTeaBlock = blocks.register("thai_milk_tea_block", ThaiMilkTeaBlock::new);
        greenMilkTeaBlock = blocks.register("green_milk_tea_block", GreenMilkTeaBlock::new);
        jasmineMilkTeaBlock = blocks.register("jasmine_milk_tea_block", JasmineMilkTeaBlock::new);
        taroMilkTeaBlock = blocks.register("taro_milk_tea_block", TaroMilkTeaBlock::new);
        strawberryMilkTeaBlock = blocks.register("strawberry_milk_tea_block", StrawberryMilkTeaBlock::new);
        cassavaCropBlock = blocks.register("cassava_crop_block", () -> new CassavaCropBlock(itemGroup, modID));

    }

    public DeferredRegister<Block> getBlocksRegister() {
        return blocks;
    }

    public Block getBlackMilkTeaBlock() {
        return blackMilkTeaBlock.get();
    }

    public Block getThaiMilkTeaBlock() {
        return thaiMilkTeaBlock.get();
    }

    public Block getGreenMilkTeaBlock() {
        return greenMilkTeaBlock.get();
    }

    public Block getJasmineMilkTeaBlock() {
        return jasmineMilkTeaBlock.get();
    }

    public Block getTaroMilkTeaBlock() {
        return taroMilkTeaBlock.get();
    }

    public Block getStrawberryMilkTeaBlock() {
        return strawberryMilkTeaBlock.get();
    }

    public Block getCassavaCropBlock() {
        return cassavaCropBlock.get();
    }

}
