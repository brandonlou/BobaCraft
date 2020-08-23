package com.blou.bobamod;

import com.blou.bobamod.init.ModBlocks;
import com.blou.bobamod.init.ModItems;
import com.blou.bobamod.util.RenderHelper;
import net.minecraft.client.renderer.RenderType;
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

    // Directly reference a log4j logger.
//    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "bobamod";

    public BobaMod() {

        // Register the setup method for modloading.
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register the doClientStuff method for modloading.
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register our custom blocks and items with the event bus.
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ourselves for server and other game events we are interested in.
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.THAI_MILK_TEA_BLOCK.get(), RenderHelper::getSolidOrTranslucent);
        RenderTypeLookup.setRenderLayer(ModBlocks.TARO_MILK_TEA_BLOCK.get(), RenderHelper::getSolidOrTranslucent);
        RenderTypeLookup.setRenderLayer(ModBlocks.STRAWBERRY_MILK_TEA_BLOCK.get(), RenderHelper::getSolidOrTranslucent);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    // Create custom creative tab.
    public static final ItemGroup TAB = new ItemGroup("bobaTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.STRAWBERRY_MILK_TEA_BLOCK_ITEM.get()); // TODO: Change to black milk tea
        }
    };

}
