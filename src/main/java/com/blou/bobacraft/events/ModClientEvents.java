//package com.blou.bobacraft.events;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.Biomes;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.event.world.BlockEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.ForgeRegistries;
//
//@Mod.EventBusSubscriber(modid="bobacraft", bus=Mod.EventBusSubscriber.Bus.FORGE, value=Dist.CLIENT)
//public class ModClientEvents {
//
//    @SubscribeEvent
//    public static void onBreakGrassInJungle(BlockEvent.BreakEvent event) {
//
//        Block currentBlock = event.getState().getBlock();
//        Biome currentBiome = event.getWorld().getBiome(event.getPos());
//
//        boolean isGrassBlock = (currentBlock == Blocks.TALL_GRASS);
//        boolean inJungle = (currentBiome == ForgeRegistries.BIOMES.getValue(Biomes.JUNGLE.getRegistryName()));
//
//        if(isGrassBlock && inJungle) {
////            ItemStack stack =
////            currentBlock.spawnAdditionalDrops(event.getState(), , event.getPos(), stack);
//        }
//
//    }
//
//}
