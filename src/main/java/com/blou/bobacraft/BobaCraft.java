package com.blou.bobacraft;

import com.blou.bobacraft.init.ModBlocks;
import com.blou.bobacraft.init.ModItems;
import com.blou.bobacraft.util.RenderHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

// The value here should match an entry in the META-INF/mods.toml file.
@Mod("bobacraft")
public class BobaCraft {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    private final String modID;
    private final ItemGroup tab;
    private final ModBlocks modBlocks;
    private final ModItems modItems;

    public BobaCraft() {

        modID = "bobacraft";

        tab = new ItemGroup("bobaTab") {
            @Override @Nonnull
            public ItemStack createIcon() {
                return new ItemStack(modItems.getCreativeTabIcon());
            }
        };

        modBlocks = ModBlocks.getInstance(tab, modID);
        modItems = ModItems.getInstance(tab, modID);

        // Register the setup method for modloading.
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register the doClientStuff method for modloading.
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        });

        // Register our custom blocks and items with the event bus.
        modBlocks.getBlocksRegister().register(FMLJavaModLoadingContext.get().getModEventBus());
        modItems.getItemsRegister().register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ourselves for server and other game events we are interested in.
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        // Array of all translucent blocks to be rendered.
        Block[] translucentBlocks = {
                modBlocks.getBlackMilkTeaBlock(),
                modBlocks.getThaiMilkTeaBlock(),
                modBlocks.getJasmineMilkTeaBlock(),
                modBlocks.getGreenMilkTeaBlock(),
                modBlocks.getTaroMilkTeaBlock(),
                modBlocks.getStrawberryMilkTeaBlock()
        };

        // Render each solid and translucent layer of these blocks appropriately.
        for(Block block : translucentBlocks) {
            RenderTypeLookup.setRenderLayer(block, RenderHelper::getSolidOrTranslucent);
        }

        // Render crops to look like crops.
        RenderTypeLookup.setRenderLayer(modBlocks.getCassavaCropBlock(), RenderType.getCutout());

    }

}
