
package net.mcreator.tllbutinblocks.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.tllbutinblocks.itemgroup.TllItemsItemGroup;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

@TllButInBlocksModElements.ModElement.Tag
public class ToomusicdiskItem extends TllButInBlocksModElements.ModElement {
	@ObjectHolder("tll_but_in_blocks:toomusicdisk")
	public static final Item block = null;
	public ToomusicdiskItem(TllButInBlocksModElements instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, TllButInBlocksModElements.sounds.get(new ResourceLocation("tll_but_in_blocks:too_music")),
					new Item.Properties().group(TllItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("toomusicdisk");
		}
	}
}
