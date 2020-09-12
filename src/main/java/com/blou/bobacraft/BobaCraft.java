package com.blou.bobacraft;

import com.blou.bobacraft.init.ModBlocks;
import com.blou.bobacraft.init.ModItems;
import com.blou.bobacraft.util.RenderHelper;
import net.minecraft.client.renderer.RenderType;
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
        modItems.getItemsRegister().register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ourselves for server and other game events we are interested in.
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {

        RenderTypeLookup.setRenderLayer(modBlocks.getCassavaCropBlock(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(modBlocks.getBlackMilkTeaBlock(), RenderHelper::getSolidOrTranslucent);
        RenderTypeLookup.setRenderLayer(modBlocks.getThaiMilkTeaBlock(), RenderHelper::getSolidOrTranslucent);
        RenderTypeLookup.setRenderLayer(modBlocks.getGreenMilkTeaBlock(), RenderHelper::getSolidOrTranslucent);
        RenderTypeLookup.setRenderLayer(modBlocks.getJasmineMilkTeaBlock(), RenderHelper::getSolidOrTranslucent);
        RenderTypeLookup.setRenderLayer(modBlocks.getTaroMilkTeaBlock(), RenderHelper::getSolidOrTranslucent);
        RenderTypeLookup.setRenderLayer(modBlocks.getStrawberryMilkTeaBlock(), RenderHelper::getSolidOrTranslucent);

    }

    private void doClientStuff(final FMLClientSetupEvent event) {}

    public String getModID() {
        return "bobacraft";
    }

    public ItemGroup getTab() {
        return tab;
    }

}
