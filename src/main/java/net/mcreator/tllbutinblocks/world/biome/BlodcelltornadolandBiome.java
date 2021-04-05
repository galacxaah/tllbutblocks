
package net.mcreator.tllbutinblocks.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityClassification;

import net.mcreator.tllbutinblocks.entity.WhitebloodcellEntity;
import net.mcreator.tllbutinblocks.entity.BloodCellEntity;
import net.mcreator.tllbutinblocks.block.BluefleshBlock;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

@TllButInBlocksModElements.ModElement.Tag
public class BlodcelltornadolandBiome extends TllButInBlocksModElements.ModElement {
	@ObjectHolder("tll_but_in_blocks:blodcelltornadoland")
	public static final CustomBiome biome = null;
	public BlodcelltornadolandBiome(TllButInBlocksModElements instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.2f).temperature(1f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(-13261).waterFogColor(-6711040)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BluefleshBlock.block.getDefaultState(),
							BluefleshBlock.block.getDefaultState(), BluefleshBlock.block.getDefaultState())));
			setRegistryName("blodcelltornadoland");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(BloodCellEntity.entity, 70, 10, 19));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(WhitebloodcellEntity.entity, 20, 10, 19));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(BloodCellEntity.entity, 20, 10, 19));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(BloodCellEntity.entity, 20, 10, 19));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(WhitebloodcellEntity.entity, 20, 10, 19));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(WhitebloodcellEntity.entity, 20, 10, 19));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(BloodCellEntity.entity, 20, 10, 19));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -65485;
		}
	}
}
