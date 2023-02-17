package dev.dcox.twmod.client.models;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.entities.Firesnake;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class FiresnakeModel extends EntityModel<Firesnake> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TwMod.MODID, "firesnake"), "main");
	private final ModelPart body;

	public FiresnakeModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition parts = meshdefinition.getRoot();

		PartDefinition body = parts.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -2.0F, -6.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		body.addOrReplaceChild("BodySection_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, -4.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.6082F, -3.1416F));

		body.addOrReplaceChild("BodySection_r2", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, -2.0F, -8.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(9, 15).addBox(-2.0F, -2.0F, -6.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, -3.1416F));

		body.addOrReplaceChild("BodySection_r3", CubeListBuilder.create().texOffs(10, 9).addBox(1.0F, -2.0F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		body.addOrReplaceChild("BodySection_r4", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -2.0F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.9976F, -3.1416F));

		body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -2.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 18).addBox(-1.0F, -2.0F, -8.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -2.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}


	@Override
	public void setupAnim(Firesnake p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}