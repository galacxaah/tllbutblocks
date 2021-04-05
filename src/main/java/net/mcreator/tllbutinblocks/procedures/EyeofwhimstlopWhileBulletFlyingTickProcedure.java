package net.mcreator.tllbutinblocks.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Map;

@TllButInBlocksModElements.ModElement.Tag
public class EyeofwhimstlopWhileBulletFlyingTickProcedure extends TllButInBlocksModElements.ModElement {
	public EyeofwhimstlopWhileBulletFlyingTickProcedure(TllButInBlocksModElements instance) {
		super(instance, 85);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EyeofwhimstlopWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure EyeofwhimstlopWhileBulletFlyingTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if ((y < (-10))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) 0);
		}
	}
}
