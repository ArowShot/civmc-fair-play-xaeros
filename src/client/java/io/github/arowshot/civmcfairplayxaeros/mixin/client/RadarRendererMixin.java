package io.github.arowshot.civmcfairplayxaeros.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import xaero.common.core.XaeroMinimapCore;
import xaero.hud.minimap.radar.render.element.RadarRenderer;

@Mixin(RadarRenderer.class)
public class RadarRendererMixin {
    @ModifyVariable(method = "renderIcon", at = @At("STORE"), ordinal = 1)
    private float modifyIconBrightness(float original) {
        if(XaeroMinimapCore.modMain.isFairPlay()) {
            return 1f;
        } else {
            return original;
        }
    }
}
