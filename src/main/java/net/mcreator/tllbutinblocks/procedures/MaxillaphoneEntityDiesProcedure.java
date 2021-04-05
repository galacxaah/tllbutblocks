package net.mcreator.tllbutinblocks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.tllbutinblocks.item.OrganicessenceItem;
import net.mcreator.tllbutinblocks.block.ScrewBlock;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Map;

@TllButInBlocksModElements.ModElement.Tag
public class MaxillaphoneEntityDiesProcedure extends TllButInBlocksModElements.ModElement {
	public MaxillaphoneEntityDiesProcedure(TllButInBlocksModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure MaxillaphoneEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure MaxillaphoneEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure MaxillaphoneEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure MaxillaphoneEntityDies!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randomvar = 0;
		randomvar = (double) Math.random();
		if (((randomvar) > 0.5)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(OrganicessenceItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 4);
				world.addEntity(entityToSpawn);
			}
		}
		if (((randomvar) > 0.2)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ScrewBlock.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 4);
				world.addEntity(entityToSpawn);
			}
		}
		if (((randomvar) > 0.2)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ScrewBlock.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 4);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
