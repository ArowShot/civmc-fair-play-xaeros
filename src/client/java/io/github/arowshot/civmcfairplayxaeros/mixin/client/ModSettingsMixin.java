package io.github.arowshot.civmcfairplayxaeros.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xaero.common.settings.ModSettings;

@Mixin(ModSettings.class)
public class ModSettingsMixin {
    @Shadow
    private boolean entityRadar;

    @Overwrite(remap = false)
    public boolean getEntityRadar() {
        return entityRadar;
    }
}
