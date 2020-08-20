package com.blou.bobamod.items;

import com.blou.bobamod.Boba;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ThaiTea extends Item {

    public ThaiTea() {
        super(new Item.Properties()
                .group(Boba.TAB)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(1.2f)
                        // 50% chance for level 1 jump boost effect for 15 seconds (15 secs * 20 ticks/sec = 300 ticks)
                        .effect(() -> new EffectInstance(Effects.JUMP_BOOST, 300, 0), 0.5f)
                        .setAlwaysEdible() // You can eat it even if you're not hungry.
                        .build())
        );
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

}
