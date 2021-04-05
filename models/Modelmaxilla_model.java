// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelmaxilla_model extends EntityModel<Entity> {
	private final ModelRenderer maxilla;
	private final ModelRenderer right_leg_back;
	private final ModelRenderer cube_r1;
	private final ModelRenderer right_leg_middle;
	private final ModelRenderer cube_r2;
	private final ModelRenderer right_leg_front;
	private final ModelRenderer cube_r3;
	private final ModelRenderer left_leg_back;
	private final ModelRenderer left_leg_middle;
	private final ModelRenderer left_leg_front;
	private final ModelRenderer peanut;
	private final ModelRenderer cube_r4;
	private final ModelRenderer head;
	private final ModelRenderer left_arm;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer right_arm;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer upper_jaw;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;

	public Modelmaxilla_model() {
		textureWidth = 64;
		textureHeight = 64;

		maxilla = new ModelRenderer(this);
		maxilla.setRotationPoint(0.0F, 21.0F, 0.0F);
		maxilla.setTextureOffset(32, 0).addBox(-5.0F, -8.35F, 4.0F, 10.0F, 6.0F, 1.0F, 0.01F, false);
		maxilla.setTextureOffset(13, 26).addBox(-4.0F, -4.35F, -6.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		maxilla.setTextureOffset(0, 26).addBox(4.0F, -4.35F, -6.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
		maxilla.setTextureOffset(23, 26).addBox(-5.0F, -4.35F, -6.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
		maxilla.setTextureOffset(0, 13).addBox(-5.0F, -2.35F, -6.0F, 10.0F, 2.0F, 11.0F, 0.0F, false);

		right_leg_back = new ModelRenderer(this);
		right_leg_back.setRotationPoint(-4.0F, -1.0F, 2.0F);
		maxilla.addChild(right_leg_back);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-6.25F, -1.5F, -0.5F);
		right_leg_back.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.48F);
		cube_r1.setTextureOffset(0, 43).addBox(5.5F, -1.5F, -0.5F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		right_leg_middle = new ModelRenderer(this);
		right_leg_middle.setRotationPoint(-4.0F, -1.0F, -1.0F);
		maxilla.addChild(right_leg_middle);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-6.25F, -1.5F, -0.5F);
		right_leg_middle.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.48F);
		cube_r2.setTextureOffset(32, 13).addBox(5.5F, -1.5F, -0.5F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		right_leg_front = new ModelRenderer(this);
		right_leg_front.setRotationPoint(-4.0F, -1.0F, -4.0F);
		maxilla.addChild(right_leg_front);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-6.25F, -1.5F, -0.5F);
		right_leg_front.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.48F);
		cube_r3.setTextureOffset(0, 26).addBox(5.5F, -1.5F, -0.5F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		left_leg_back = new ModelRenderer(this);
		left_leg_back.setRotationPoint(4.0F, -1.0F, -4.0F);
		maxilla.addChild(left_leg_back);
		setRotationAngle(left_leg_back, 0.0F, 0.0F, -0.48F);
		left_leg_back.setTextureOffset(14, 43).addBox(-0.2309F, -0.0565F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		left_leg_middle = new ModelRenderer(this);
		left_leg_middle.setRotationPoint(4.0F, -1.0F, -1.0F);
		maxilla.addChild(left_leg_middle);
		setRotationAngle(left_leg_middle, 0.0F, 0.0F, -0.48F);
		left_leg_middle.setTextureOffset(43, 8).addBox(-0.2217F, -0.1154F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		left_leg_front = new ModelRenderer(this);
		left_leg_front.setRotationPoint(4.0F, -1.0F, 2.0F);
		maxilla.addChild(left_leg_front);
		setRotationAngle(left_leg_front, 0.0F, 0.0F, -0.48F);
		left_leg_front.setTextureOffset(7, 43).addBox(-0.2874F, -0.0756F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		peanut = new ModelRenderer(this);
		peanut.setRotationPoint(0.0F, 0.0F, 0.0F);
		maxilla.addChild(peanut);
		peanut.setTextureOffset(36, 39).addBox(-1.5F, -5.35F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -1.0F, 0.0F);
		peanut.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.5236F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(13, 30).addBox(-1.5F, -5.2191F, 0.025F, 3.0F, 2.0F, 3.0F, 0.01F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -5.8F, -0.75F);
		peanut.addChild(head);
		head.setTextureOffset(23, 39).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 3.0F, 3.0F, 0.02F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(2.0F, -4.75F, -0.5F);
		peanut.addChild(left_arm);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 1.3F, -0.25F);
		left_arm.addChild(cube_r5);
		setRotationAngle(cube_r5, -1.0472F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(35, 46).addBox(-0.5F, -1.175F, -1.6691F, 1.0F, 3.0F, 1.0F, 0.02F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-4.0F, 0.934F, -1.616F);
		left_arm.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.5236F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(26, 30).addBox(3.5F, -2.6691F, -0.825F, 1.0F, 3.0F, 1.0F, -0.2F, false);
		cube_r6.setTextureOffset(0, 7).addBox(3.5F, -2.6691F, -0.825F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-2.0F, -4.75F, -0.5F);
		peanut.addChild(right_arm);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 0.934F, -1.616F);
		right_arm.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.5236F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(30, 46).addBox(-0.5F, -2.6691F, -0.825F, 1.0F, 3.0F, 1.0F, -0.2F, false);
		cube_r7.setTextureOffset(6, 0).addBox(-0.5F, -2.6691F, -0.825F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(4.0F, 1.3F, -0.25F);
		right_arm.addChild(cube_r8);
		setRotationAngle(cube_r8, -1.0472F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(36, 26).addBox(-4.5F, -1.175F, -1.6691F, 1.0F, 3.0F, 1.0F, 0.02F, false);

		upper_jaw = new ModelRenderer(this);
		upper_jaw.setRotationPoint(0.0F, -8.0F, 4.0F);
		maxilla.addChild(upper_jaw);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-5.0F, 1.75F, -0.25F);
		upper_jaw.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.7854F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(0, 13).addBox(-0.5F, -1.4546F, -1.5454F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(5.25F, 2.0F, -0.25F);
		upper_jaw.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.7854F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(0, 0).addBox(-0.5F, -1.4546F, -1.5454F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 7.0F, -4.0F);
		upper_jaw.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.48F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(32, 13).addBox(-5.0F, -7.8974F, -9.0234F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		cube_r11.setTextureOffset(36, 24).addBox(4.0F, -7.8974F, -9.0234F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, 1.0F, 1.0F);
		upper_jaw.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.48F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(0, 39).addBox(-5.0F, -0.1974F, -11.6234F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r12.setTextureOffset(0, 0).addBox(-5.0F, -2.1974F, -11.6234F, 10.0F, 2.0F, 11.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-2.0F, -1.8435F, -8.7936F);
		upper_jaw.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.3927F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(43, 15).addBox(-1.0F, -2.3472F, -0.8334F, 2.0F, 2.0F, 2.0F, 0.2F, false);
		cube_r13.setTextureOffset(21, 46).addBox(3.0F, -2.3472F, -0.8334F, 2.0F, 2.0F, 2.0F, 0.2F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		maxilla.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.left_leg_middle.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.left_leg_back.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_leg_back.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.right_leg_middle.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_leg_front.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.left_leg_front.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}