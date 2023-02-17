package dev.dcox.twmod.client.renderer;

import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.client.models.FiresnakeModel;
import dev.dcox.twmod.entities.Firesnake;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FiresnakeRenderer extends MobRenderer<Firesnake, FiresnakeModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(TwMod.MODID, "textures/entities/firesnake.png");

    public FiresnakeRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new FiresnakeModel(ctx.bakeLayer(FiresnakeModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Firesnake entity) {
        return TEXTURE;
    }
}
