// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelhandmond_model extends EntityModel<Entity> {
	private final ModelRenderer torso;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer head;
	private final ModelRenderer cube_r5;
	private final ModelRenderer tail;
	private final ModelRenderer tail_2;
	private final ModelRenderer cube_r6;
	private final ModelRenderer tail_3;
	private final ModelRenderer cube_r7;
	private final ModelRenderer tail_4;
	private final ModelRenderer cube_r8;
	private final ModelRenderer tail_5;
	private final ModelRenderer cube_r9;
	private final ModelRenderer tail_6;
	private final ModelRenderer cube_r10;
	private final ModelRenderer hand;
	private final ModelRenderer finger;
	private final ModelRenderer cube_r11;
	private final ModelRenderer hand2;
	private final ModelRenderer finger2;
	private final ModelRenderer cube_r12;

	public Modelhandmond_model() {
		textureWidth = 48;
		textureHeight = 48;

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 12.75F, -2.75F);
		torso.setTextureOffset(24, 23).addBox(0.5F, -5.75F, -1.5F, 3.0F, 5.0F, 1.0F, 0.0F, false);
		torso.setTextureOffset(24, 23).addBox(-3.5F, -5.75F, -1.5F, 3.0F, 5.0F, 1.0F, 0.0F, false);
		torso.setTextureOffset(22, 40).addBox(0.25F, -6.75F, -1.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		torso.setTextureOffset(22, 40).addBox(-2.25F, -6.75F, -1.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.25F, -0.5F, -1.75F);
		torso.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.7854F);
		cube_r1.setTextureOffset(32, 27).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.7F, -4.95F, -1.25F);
		torso.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.7854F);
		cube_r2.setTextureOffset(14, 44).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -4.25F, -1.25F);
		torso.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
		cube_r3.setTextureOffset(0, 44).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		torso.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.0436F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(8, 31).addBox(-0.5F, -7.7763F, -0.4549F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -7.75F, 0.5F);
		torso.addChild(head);
		head.setTextureOffset(0, 13).addBox(-3.0F, -4.0F, -3.75F, 6.0F, 4.0F, 6.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -4.0F, 0.0F);
		head.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.2618F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(0, 0).addBox(-4.0F, -3.025F, -5.0F, 8.0F, 4.0F, 9.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 2.125F, 0.75F);
		torso.addChild(tail);
		tail.setTextureOffset(24, 13).addBox(-2.5F, -2.125F, -2.0F, 5.0F, 2.0F, 4.0F, 0.0F, false);

		tail_2 = new ModelRenderer(this);
		tail_2.setRotationPoint(0.0F, -0.125F, -0.25F);
		tail.addChild(tail_2);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.75F);
		tail_2.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.2618F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(0, 23).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 3.0F, 0.0F, false);

		tail_3 = new ModelRenderer(this);
		tail_3.setRotationPoint(0.0F, 4.0F, 1.25F);
		tail_2.addChild(tail_3);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.5F, 0.0F, 0.0F);
		tail_3.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.7854F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(14, 23).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		tail_4 = new ModelRenderer(this);
		tail_4.setRotationPoint(0.0F, 2.625F, 2.75F);
		tail_3.addChild(tail_4);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-1.5F, -0.0658F, -0.8451F);
		tail_4.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.789F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(12, 31).addBox(0.5F, 0.0F, -1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		tail_5 = new ModelRenderer(this);
		tail_5.setRotationPoint(0.0F, -1.0F, 3.875F);
		tail_4.addChild(tail_5);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, -0.1376F, 0.6366F);
		tail_5.addChild(cube_r9);
		setRotationAngle(cube_r9, 2.8798F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(18, 31).addBox(-0.7F, -1.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		tail_6 = new ModelRenderer(this);
		tail_6.setRotationPoint(0.5F, -4.625F, 1.125F);
		tail_5.addChild(tail_6);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-1.0F, 1.0179F, 0.8354F);
		tail_6.addChild(cube_r10);
		setRotationAngle(cube_r10, 1.8762F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(12, 40).addBox(0.0F, -1.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		hand = new ModelRenderer(this);
		hand.setRotationPoint(5.0F, -2.125F, -2.375F);
		torso.addChild(hand);
		setRotationAngle(hand, -0.6981F, 0.0F, 0.0F);
		hand.setTextureOffset(6, 40).addBox(-1.0F, 0.125F, -0.625F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		finger = new ModelRenderer(this);
		finger.setRotationPoint(0.0F, 2.125F, -0.125F);
		hand.addChild(finger);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 0.6F, 0.7F);
		finger.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.5236F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(10, 44).addBox(-0.8F, -1.0F, -0.7F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		hand2 = new ModelRenderer(this);
		hand2.setRotationPoint(-5.25F, -2.125F, -2.375F);
		torso.addChild(hand2);
		setRotationAngle(hand2, -0.6981F, 0.0F, 0.0F);
		hand2.setTextureOffset(6, 40).addBox(-1.0F, 0.125F, -0.625F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		finger2 = new ModelRenderer(this);
		finger2.setRotationPoint(0.0F, 2.125F, -0.125F);
		hand2.addChild(finger2);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, 0.6F, 0.7F);
		finger2.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.5236F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(10, 44).addBox(-0.9F, -1.0F, -0.7F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.hand2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.hand.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}