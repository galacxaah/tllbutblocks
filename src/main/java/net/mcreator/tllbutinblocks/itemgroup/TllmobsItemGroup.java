
package net.mcreator.tllbutinblocks.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.tllbutinblocks.item.CreativetabeggsItem;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

@TllButInBlocksModElements.ModElement.Tag
public class TllmobsItemGroup extends TllButInBlocksModElements.ModElement {
	public TllmobsItemGroup(TllButInBlocksModElements instance) {
		super(instance, 38);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtllmobs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CreativetabeggsItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
