package com.blou.bobacraft.loot;

import com.blou.bobacraft.BobaCraft;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid="bobacraft", bus=Mod.EventBusSubscriber.Bus.MOD, value=Dist.CLIENT)
public class GrassHarvestModifier extends LootModifier {

    public GrassHarvestModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @SubscribeEvent
    public static void registerLootModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {

        event.getRegistry().register(new GrassHarvestModifier.Serializer().setRegistryName(
                new ResourceLocation("bobacraft", "grass_harvest")));

    }

    @Override
    @Nonnull
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {

        List<ItemStack> newLoot = new ArrayList<>();
        Item cassavaSeedItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("bobacraft:cassava_seed_item"));
        newLoot.add(new ItemStack(cassavaSeedItem, 1));

        return newLoot;

    }

    private static class Serializer extends GlobalLootModifierSerializer<GrassHarvestModifier> {

        @Override
        public GrassHarvestModifier read(ResourceLocation name, JsonObject json, ILootCondition[] conditions) {
            return new GrassHarvestModifier(conditions);
        }

        @Override
        public JsonObject write(GrassHarvestModifier instance) {
            return this.makeConditions(instance.conditions);
        }

    }

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

}
