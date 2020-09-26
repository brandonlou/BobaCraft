package com.blou.bobacraft.loot;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Mod.EventBusSubscriber(modid="bobacraft", bus=Mod.EventBusSubscriber.Bus.MOD, value=Dist.CLIENT)
public class FernHarvestModifier extends LootModifier {

    public FernHarvestModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @SubscribeEvent
    public static void registerLootModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {

        event.getRegistry().register(new FernHarvestModifier.Serializer().setRegistryName(
                new ResourceLocation("bobacraft", "fern_harvest")));

    }

    @Override
    @Nonnull
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {

        BlockPos blockPos = new BlockPos(Objects.requireNonNull(context.get(LootParameters.field_237457_g_)));
        Biome biome = context.getWorld().getBiome(blockPos);

        // 1/20 or 5% chance of dropping a cassava seed if in jungle.
        if(biome.getCategory() == Biome.Category.JUNGLE && new Random().nextInt(20) == 0) {

            Item cassavaSeedItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("bobacraft:cassava_seed_item"));
            generatedLoot.add(new ItemStack(cassavaSeedItem, 1));

        }

        return generatedLoot;

    }

    private static class Serializer extends GlobalLootModifierSerializer<FernHarvestModifier> {

        @Override
        public FernHarvestModifier read(ResourceLocation name, JsonObject json, ILootCondition[] conditions) {
            return new FernHarvestModifier(conditions);
        }

        @Override
        public JsonObject write(FernHarvestModifier instance) {
            return this.makeConditions(instance.conditions);
        }

    }

}
