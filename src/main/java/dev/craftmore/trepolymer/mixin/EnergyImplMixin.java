package dev.craftmore.trepolymer.mixin;

import eu.pb4.polymer.core.api.other.PolymerComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.reborn.energy.impl.EnergyImpl;

/**
 * TR Energy registers the {@code team_reborn_energy:energy} item data component from its own
 * init entrypoint. Vanilla clients disconnect on unknown synced components, so it's marked
 * server-only as soon as it's registered. Polymer then strips it from stacks sent to clients.
 * TODO(gap): vanilla clients get no energy bar; ports show charge through tooltips.
 */
@Mixin(value = EnergyImpl.class, remap = false)
public class EnergyImplMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private static void trePolymer$markServerOnly(CallbackInfo ci) {
        PolymerComponent.registerDataComponent(EnergyImpl.ENERGY_COMPONENT);
    }
}
