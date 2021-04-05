// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelWhiteBloodCell extends EntityModel<Entity> {
	private final ModelRenderer white_b_cell;

	public ModelWhiteBloodCell() {
		textureWidth = 32;
		textureHeight = 32;

		white_b_cell = new ModelRenderer(this);
		white_b_cell.setRotationPoint(0.0F, 21.5F, 0.0F);
		white_b_cell.setTextureOffset(0, 0).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		white_b_cell.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.white_b_cell.rotateAngleX = f2 / 20.f;
	}
}