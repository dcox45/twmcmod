package dev.dcox.twmod.events;

import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.entities.Firesnake;
import dev.dcox.twmod.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TwMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(EntityInit.FIRESNAKE.get(), Firesnake.getFiresnakeAttributes().build());
    }
}
