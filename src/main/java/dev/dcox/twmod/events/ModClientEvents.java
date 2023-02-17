package dev.dcox.twmod.events;

import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.client.models.FiresnakeModel;
import dev.dcox.twmod.client.renderer.FiresnakeRenderer;
import dev.dcox.twmod.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TwMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void EntityRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(EntityInit.FIRESNAKE.get(), FiresnakeRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FiresnakeModel.LAYER_LOCATION, FiresnakeModel::createBodyLayer);
    }
}
