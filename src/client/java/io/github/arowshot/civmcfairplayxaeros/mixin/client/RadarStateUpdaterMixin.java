package io.github.arowshot.civmcfairplayxaeros.mixin.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xaero.common.HudMod;
import xaero.common.core.XaeroMinimapCore;
import xaero.hud.minimap.radar.state.RadarStateUpdater;

@Mixin(RadarStateUpdater.class)
public class RadarStateUpdaterMixin {
	@Redirect(method = "update", at = @At(value = "INVOKE", target = "Lxaero/common/HudMod;isFairPlay()Z"))
	private boolean isFairPlay(HudMod instance) {
		return false;
	}

	@ModifyVariable(method = "update", at = @At("STORE"), ordinal = 0)
	private int modifyHeightLimit(int original) {
		if(XaeroMinimapCore.modMain.isFairPlay()) {
			return 1024;
		} else {
			return original;
		}
	}

	@Inject(method = "isInvisibleTo", at = @At("HEAD"), cancellable = true)
	private void isInvisibleTo(Entity entity, PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
		if(XaeroMinimapCore.modMain.isFairPlay()) {
			cir.setReturnValue(false);
		}
	}
}