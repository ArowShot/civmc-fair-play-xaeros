package io.github.arowshot.civmcfairplayxaeros.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import xaero.common.core.XaeroMinimapCore;
import xaero.hud.minimap.radar.color.RadarColorHelper;

@Mixin(RadarColorHelper.class)
public class RadarColorHelperMixin {
    @ModifyVariable(method = "getEntityColor", at = @At("HEAD"), ordinal = 1)
    private boolean modifyHeightBasedFade(boolean original) {
        if(XaeroMinimapCore.modMain.isFairPlay()) {
            return false;
        } else {
            return original;
        }
    }
}
