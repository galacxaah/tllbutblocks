
package net.mcreator.tllbutinblocks.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.tllbutinblocks.block.BrainwormBlock;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

@TllButInBlocksModElements.ModElement.Tag
public class WormpiecefuelFuel extends TllButInBlocksModElements.ModElement {
	public WormpiecefuelFuel(TllButInBlocksModElements instance) {
		super(instance, 31);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(BrainwormBlock.block, (int) (1)).getItem())
			event.setBurnTime(1600);
	}
}
