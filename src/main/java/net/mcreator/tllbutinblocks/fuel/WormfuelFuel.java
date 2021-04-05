
package net.mcreator.tllbutinblocks.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.tllbutinblocks.item.RawbrainwormItem;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

@TllButInBlocksModElements.ModElement.Tag
public class WormfuelFuel extends TllButInBlocksModElements.ModElement {
	public WormfuelFuel(TllButInBlocksModElements instance) {
		super(instance, 32);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(RawbrainwormItem.block, (int) (1)).getItem())
			event.setBurnTime(12800);
	}
}
