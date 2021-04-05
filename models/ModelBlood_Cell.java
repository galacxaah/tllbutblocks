// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelBlood_Cell extends EntityModel<Entity> {
	private final ModelRenderer bone;

	public ModelBlood_Cell() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 18.75F, 0.5F);
		bone.setTextureOffset(14, 16).addBox(-3.0F, -4.75F, 0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-5.0F, -4.75F, -0.5F, 10.0F, 10.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(14, 24).addBox(-5.0F, -4.75F, -1.5F, 2.0F, 10.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(0, 12).addBox(-5.0F, -4.75F, 0.5F, 2.0F, 10.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(0, 24).addBox(3.0F, -4.75F, -1.5F, 2.0F, 10.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(7, 16).addBox(3.0F, -4.75F, 0.5F, 2.0F, 10.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(22, 11).addBox(-3.0F, 3.25F, -1.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(7, 12).addBox(-3.0F, 3.25F, 0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(14, 20).addBox(-3.0F, -4.75F, -1.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone.rotateAngleX = f2 / 20.f;
	}
}