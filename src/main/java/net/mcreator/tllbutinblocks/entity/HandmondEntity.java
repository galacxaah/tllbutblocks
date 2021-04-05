
package net.mcreator.tllbutinblocks.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.tllbutinblocks.procedures.HandmondEntityIsHurtProcedure;
import net.mcreator.tllbutinblocks.procedures.HandmondEntityDiesProcedure;
import net.mcreator.tllbutinblocks.itemgroup.TllmobsItemGroup;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TllButInBlocksModElements.ModElement.Tag
public class HandmondEntity extends TllButInBlocksModElements.ModElement {
	public static EntityType entity = null;
	public HandmondEntity(TllButInBlocksModElements instance) {
		super(instance, 1);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("handmond")
						.setRegistryName("handmond");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -6684724, -26215, new Item.Properties().group(TllmobsItemGroup.tab))
				.setRegistryName("handmond_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("plains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("tll_but_in_blocks:flesh_islands")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 5, 1, 1));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
		DungeonHooks.addDungeonMob(entity, 180);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelhandmond_model(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tll_but_in_blocks:textures/handmond_texture.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 4;
			setNoAI(false);
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
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
			this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 0.8, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, BlazeEntity.class, false, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tll_but_in_blocks:handmond_living"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound(
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tll_but_in_blocks:handmond_walks")),
					0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tll_but_in_blocks:handmond_hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tll_but_in_blocks:handmond_dies"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				HandmondEntityIsHurtProcedure.executeProcedure($_dependencies);
			}
			if (source == DamageSource.FALL)
				return false;
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
				HandmondEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
			this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(0.2D);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.4);
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			torso.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.hand2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.hand.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
