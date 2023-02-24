package dev.dcox.twmod.events;

import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.entities.Firesnake;
import dev.dcox.twmod.init.EntityInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = TwMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(EntityInit.FIRESNAKE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE,
                    Firesnake::canSpawn);
        });

    }

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(EntityInit.FIRESNAKE.get(), Firesnake.getFiresnakeAttributes().build());
    }
}
