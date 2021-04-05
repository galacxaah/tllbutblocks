package net.mcreator.tllbutinblocks.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Map;
import java.util.Collections;

@TllButInBlocksModElements.ModElement.Tag
public class EyeofwhimstlopBulletHitsLivingEntityProcedure extends TllButInBlocksModElements.ModElement {
	public EyeofwhimstlopBulletHitsLivingEntityProcedure(TllButInBlocksModElements instance) {
		super(instance, 86);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EyeofwhimstlopBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure EyeofwhimstlopBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate((sourceentity.getPosX()), (sourceentity.getPosY()), (sourceentity.getPosZ()));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation((sourceentity.getPosX()), (sourceentity.getPosY()), (sourceentity.getPosZ()),
						_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
			}
		}
	}
}
