
package net.mcreator.tllbutinblocks.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.tllbutinblocks.world.dimension.OrganicDimensionDimension;
import net.mcreator.tllbutinblocks.itemgroup.TLLItemGroup;
import net.mcreator.tllbutinblocks.item.BloodclotItem;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@TllButInBlocksModElements.ModElement.Tag
public class BloodyfleshblockBlock extends TllButInBlocksModElements.ModElement {
	@ObjectHolder("tll_but_in_blocks:bloodyfleshblock")
	public static final Block block = null;
	public BloodyfleshblockBlock(TllButInBlocksModElements instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(TLLItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.SLIME).hardnessAndResistance(1f, 10f).lightValue(0));
			setRegistryName("bloodyfleshblock");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(BloodclotItem.block, (int) (1)));
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new OreFeature(OreFeatureConfig::deserialize) {
				@Override
				public boolean place(IWorld world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					DimensionType dimensionType = world.getDimension().getType();
					boolean dimensionCriteria = false;
					if (dimensionType == OrganicDimensionDimension.type)
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					return super.place(world, generator, rand, pos, config);
				}
			}.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("bloodyfleshblock", "bloodyfleshblock", blockAt -> {
				boolean blockCriteria = false;
				return blockCriteria;
			}), block.getDefaultState(), 31)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(31, 0, 0, 256))));
		}
	}
}
