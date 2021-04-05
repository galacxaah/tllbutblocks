// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


public class whimstlop_model extends EntityModel<Entity> {
	private final ModelRenderer whims;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;
	private final ModelRenderer head;
	private final ModelRenderer cube_r1;
	private final ModelRenderer eye;

	public whimstlop_model() {
		textureWidth = 64;
		textureHeight = 64;

		whims = new ModelRenderer(this);
		whims.setRotationPoint(0.0F, 1.25F, 1.5F);
		whims.setTextureOffset(0, 17).addBox(-4.5F, 2.75F, -1.25F, 9.0F, 11.0F, 4.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(0.0F, 13.75F, 0.75F);
		whims.addChild(left_leg);
		left_leg.setTextureOffset(9, 33).addBox(1.5F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		left_leg.setTextureOffset(23, 17).addBox(1.5F, 8.0F, -3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.5F, 13.75F, 0.75F);
		whims.addChild(right_leg);
		right_leg.setTextureOffset(18, 33).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		right_leg.setTextureOffset(37, 7).addBox(-1.0F, 8.0F, -3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 3.6667F, 0.5F);
		whims.addChild(head);
		setRotationAngle(head, 0.3491F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-5.0F, -7.7079F, -3.9715F, 10.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(27, 34).addBox(-2.0F, -6.7079F, 4.0285F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(27, 42).addBox(-4.5F, -7.2079F, -11.9715F, 9.0F, 3.0F, 8.0F, 0.01F, false);
		head.setTextureOffset(27, 27).addBox(-5.0F, -7.7079F, -13.9715F, 10.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(31, 17).addBox(-4.5F, -7.2079F, -11.9715F, 9.0F, 2.0F, 7.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -5.7079F, 5.0285F);
		head.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.6109F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(29, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 0.0F, 0.0F, false);

		eye = new ModelRenderer(this);
		eye.setRotationPoint(-0.5F, -6.2079F, -7.2215F);
		head.addChild(eye);
		setRotationAngle(eye, -0.7854F, 0.0F, 0.0F);
		eye.setTextureOffset(17, 49).addBox(-0.5F, -1.2071F, -1.2929F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		whims.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}