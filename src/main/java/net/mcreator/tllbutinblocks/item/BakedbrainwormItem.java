
package net.mcreator.tllbutinblocks.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.tllbutinblocks.itemgroup.TllItemsItemGroup;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

@TllButInBlocksModElements.ModElement.Tag
public class BakedbrainwormItem extends TllButInBlocksModElements.ModElement {
	@ObjectHolder("tll_but_in_blocks:bakedbrainworm")
	public static final Item block = null;
	public BakedbrainwormItem(TllButInBlocksModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(TllItemsItemGroup.tab).maxStackSize(5).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(10).saturation(10f).meat().build()));
			setRegistryName("bakedbrainworm");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
