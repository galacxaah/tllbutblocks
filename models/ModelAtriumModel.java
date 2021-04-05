// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelAtriumModel extends EntityModel<Entity> {
	private final ModelRenderer heart;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;
	private final ModelRenderer tophat;

	public ModelAtriumModel() {
		textureWidth = 64;
		textureHeight = 64;

		heart = new ModelRenderer(this);
		heart.setRotationPoint(0.4286F, 19.0F, 0.0F);
		heart.setTextureOffset(0, 0).addBox(-6.4286F, -9.0F, -3.0F, 12.0F, 7.0F, 6.0F, 0.0F, false);
		heart.setTextureOffset(19, 24).addBox(0.5714F, -10.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		heart.setTextureOffset(25, 14).addBox(-4.4286F, -2.0F, -2.0F, 8.0F, 2.0F, 4.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-6.4286F, -6.5F, 0.0F);
		heart.addChild(right_arm);
		right_arm.setTextureOffset(5, 35).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(5.5714F, -6.5F, 0.0F);
		heart.addChild(left_arm);
		left_arm.setTextureOffset(0, 35).addBox(0.0F, -0.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.4286F, 0.0F, 0.5F);
		heart.addChild(right_leg);
		right_leg.setTextureOffset(34, 28).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(1.5714F, 0.0F, 0.5F);
		heart.addChild(left_leg);
		left_leg.setTextureOffset(25, 30).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		tophat = new ModelRenderer(this);
		tophat.setRotationPoint(-3.4286F, -8.0F, 0.0F);
		heart.addChild(tophat);
		setRotationAngle(tophat, 0.0F, 0.0F, -0.2182F);
		tophat.setTextureOffset(0, 14).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		tophat.setTextureOffset(0, 24).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.1F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		heart.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}