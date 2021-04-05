
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
public class HematogenItem extends TllButInBlocksModElements.ModElement {
	@ObjectHolder("tll_but_in_blocks:hematogen")
	public static final Item block = null;
	public HematogenItem(TllButInBlocksModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(TllItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(7).saturation(3f).setAlwaysEdible().meat().build()));
			setRegistryName("hematogen");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 64;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
