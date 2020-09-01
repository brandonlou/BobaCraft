package com.blou.bobacraft.util;

import net.minecraft.client.renderer.RenderType;

public class RenderHelper {

    public static boolean getSolidOrTranslucent(RenderType layer) {
        return layer == RenderType.getSolid() || layer == RenderType.getTranslucent();
    }

}
