
package net.mcreator.tllbutinblocks.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.tllbutinblocks.block.FleshBlockBlock;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

@TllButInBlocksModElements.ModElement.Tag
public class FleshfuelFuel extends TllButInBlocksModElements.ModElement {
	public FleshfuelFuel(TllButInBlocksModElements instance) {
		super(instance, 29);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(FleshBlockBlock.block, (int) (1)).getItem())
			event.setBurnTime(3200);
	}
}
