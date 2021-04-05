
package net.mcreator.tllbutinblocks.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.tllbutinblocks.block.FleshBlockBlock;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

@TllButInBlocksModElements.ModElement.Tag
public class TLLItemGroup extends TllButInBlocksModElements.ModElement {
	public TLLItemGroup(TllButInBlocksModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtll") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(FleshBlockBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
