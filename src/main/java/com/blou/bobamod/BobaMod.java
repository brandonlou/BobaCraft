package com.blou.bobamod;

import com.blou.bobamod.init.ModBlocks;
import com.blou.bobamod.init.ModItems;
import com.blou.bobamod.util.RenderHelper;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file.
@Mod("bobamod")
public class BobaMod {

    private final ModBlocks modBlocks;
    private final ModItems modItems;
    private final ItemGroup TAB;

    public BobaMod() {

        modBlocks = ModBlocks.getInstance(this);
        modItems = ModItems.getInstance(this);
        TAB = new ItemGroup("bobaTab") {
            @Override
            public ItemStack createIcon() {
                return new ItemStack(modItems.getCreativeTabIcon()); // TODO: Change to black milk tea
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

    public String getModID() {
        return "bobamod";
    }

    private void setup(final FMLCommonSetupEvent event) {
        RenderTypeLookup.setRenderLayer(modBlocks.getBlock("thai_milk_tea_block"), RenderHelper::getSolidOrTranslucent);
        RenderTypeLookup.setRenderLayer(modBlocks.getBlock("taro_milk_tea_block"), RenderHelper::getSolidOrTranslucent);
        RenderTypeLookup.setRenderLayer(modBlocks.getBlock("strawberry_milk_tea_block"), RenderHelper::getSolidOrTranslucent);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public ItemGroup getTab() {
        return TAB;
    }

}
