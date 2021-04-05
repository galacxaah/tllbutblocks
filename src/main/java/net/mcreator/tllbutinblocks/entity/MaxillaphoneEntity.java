
package net.mcreator.tllbutinblocks.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.tllbutinblocks.procedures.MaxillaphoneEntityDiesProcedure;
import net.mcreator.tllbutinblocks.itemgroup.TllmobsItemGroup;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TllButInBlocksModElements.ModElement.Tag
public class MaxillaphoneEntity extends TllButInBlocksModElements.ModElement {
	public static EntityType entity = null;
	public MaxillaphoneEntity(TllButInBlocksModElements instance) {
		super(instance, 4);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 0.9f)).build("maxillaphone")
						.setRegistryName("maxillaphone");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13108, -103, new Item.Properties().group(TllmobsItemGroup.tab))
				.setRegistryName("maxillaphone_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("river")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("swamp")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("tll_but_in_blocks:flesh_islands")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 1, 3));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelmaxilla_model(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tll_but_in_blocks:textures/maxillaphone_texture.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 3;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, SilverfishEntity.class, true, true));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, SlimeEntity.class, true, true));
			this.goalSelector.addGoal(8, new RandomWalkingGoal(this, 0.8));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("tll_but_in_blocks:maxillaphone_living"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tll_but_in_blocks:maxillaphone_hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tll_but_in_blocks:maxillaphone_dies"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MaxillaphoneEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			maxilla.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
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
}
