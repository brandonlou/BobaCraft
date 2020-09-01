package com.blou.bobacraft;

import com.blou.bobacraft.init.ModBlocks;
import com.blou.bobacraft.init.ModItems;
import com.blou.bobacraft.util.RenderHelper;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nonnull;

// The value here should match an entry in the META-INF/mods.toml file.
@Mod("bobacraft")
public class BobaCraft {

    private final ModBlocks modBlocks;
    private final ModItems modItems;
    private final ItemGroup tab;

    public BobaCraft() {
        modBlocks = ModBlocks.getInstance(this);
        modItems = ModItems.getInstance(this);
        tab = new ItemGroup("bobaTab") {
            @Override @Nonnull
            public ItemStack createIcon() {
                return new ItemStack(modItems.getCreativeTabIcon());
            }
        };

        // Register the setup method for modloading.
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register the doClientStuff method for modloading.
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register our custom blocks and items with the event bus.
        modBlocks.getBlocksRegister().register(FMLJavaModLoadingContext.get().getModEventBus());
        modItems.getItems().register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ourselves for server and other game events we are interested in.
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {

        String[] blocksToRender = {"black_milk_tea_block", "jasmine_milk_tea_block", "green_milk_tea_block",
                "thai_milk_tea_block", "taro_milk_tea_block", "strawberry_milk_tea_block"};

        for(String block : blocksToRender) {
            RenderTypeLookup.setRenderLayer(modBlocks.getBlock(block), RenderHelper::getSolidOrTranslucent);
        }

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public String getModID() {
        return "bobacraft";
    }

    public ItemGroup getTab() {
        return tab;
    }

}
