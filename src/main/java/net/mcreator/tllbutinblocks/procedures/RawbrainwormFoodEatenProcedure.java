package net.mcreator.tllbutinblocks.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Map;

@TllButInBlocksModElements.ModElement.Tag
public class RawbrainwormFoodEatenProcedure extends TllButInBlocksModElements.ModElement {
	public RawbrainwormFoodEatenProcedure(TllButInBlocksModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RawbrainwormFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 240, (int) 1));
	}
}
