
package net.mcreator.tllbutinblocks.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.tllbutinblocks.itemgroup.TllItemsItemGroup;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

@TllButInBlocksModElements.ModElement.Tag
public class BloodCellItemItem extends TllButInBlocksModElements.ModElement {
	@ObjectHolder("tll_but_in_blocks:blood_cell_item")
	public static final Item block = null;
	public BloodCellItemItem(TllButInBlocksModElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TllItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("blood_cell_item");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
