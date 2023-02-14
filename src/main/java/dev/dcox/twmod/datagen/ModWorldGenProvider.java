package dev.dcox.twmod.datagen;

import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.init.ConfiguredFeatureInit;
import dev.dcox.twmod.init.PlacedFeatureInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE,
            ConfiguredFeatureInit::bootstrap).add(Registries.PLACED_FEATURE, PlacedFeatureInit::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Collections.singleton(TwMod.MODID));
    }
}
