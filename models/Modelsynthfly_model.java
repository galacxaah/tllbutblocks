// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelsynthfly_model extends EntityModel<Entity> {
	private final ModelRenderer Synthfly;
	private final ModelRenderer cube_r1;
	private final ModelRenderer right_wing;
	private final ModelRenderer left_wing;

	public Modelsynthfly_model() {
		textureWidth = 128;
		textureHeight = 128;

		Synthfly = new ModelRenderer(this);
		Synthfly.setRotationPoint(0.0F, 9.0F, -1.0F);
		Synthfly.setTextureOffset(21, 22).addBox(-4.0F, -5.0F, -2.75F, 8.0F, 10.0F, 6.0F, 0.0F, false);
		Synthfly.setTextureOffset(0, 39).addBox(-4.0F, 5.0F, -2.75F, 8.0F, 8.0F, 6.0F, 0.0F, false);
		Synthfly.setTextureOffset(0, 0).addBox(0.0F, 1.5F, 3.25F, 0.0F, 14.0F, 13.0F, 0.0F, false);
		Synthfly.setTextureOffset(0, 28).addBox(-3.5F, -4.0F, 3.25F, 7.0F, 7.0F, 3.0F, 0.0F, false);
		Synthfly.setTextureOffset(29, 39).addBox(-4.0F, -10.0F, -2.75F, 8.0F, 5.0F, 6.0F, 0.0F, false);
		Synthfly.setTextureOffset(50, 16).addBox(-4.5F, -5.0F, -4.75F, 9.0F, 10.0F, 2.0F, 0.1F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-0.25F, -4.1F, -6.0F);
		Synthfly.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.4363F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(59, 44).addBox(-2.25F, -7.25F, -3.75F, 0.0F, 8.0F, 6.0F, 0.0F, false);
		cube_r1.setTextureOffset(59, 44).addBox(2.75F, -7.25F, -3.75F, 0.0F, 8.0F, 6.0F, 0.0F, false);
		cube_r1.setTextureOffset(59, 44).addBox(0.2F, -7.45F, -3.75F, 0.0F, 8.0F, 6.0F, 0.0F, false);

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(-4.5F, -4.0F, -1.75F);
		Synthfly.addChild(right_wing);
		setRotationAngle(right_wing, -0.7854F, 0.0F, 0.0F);
		right_wing.setTextureOffset(13, 0).addBox(-12.75F, 0.0F, -1.0F, 13.0F, 1.0F, 6.0F, 0.3F, false);

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(4.5F, -4.0F, -1.75F);
		Synthfly.addChild(left_wing);
		setRotationAngle(left_wing, -0.7854F, 0.0F, 0.0F);
		left_wing.setTextureOffset(27, 8).addBox(-0.25F, 0.0F, -1.0F, 13.0F, 1.0F, 6.0F, 0.3F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Synthfly.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.right_wing.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_wing.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.Synthfly.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Synthfly.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}