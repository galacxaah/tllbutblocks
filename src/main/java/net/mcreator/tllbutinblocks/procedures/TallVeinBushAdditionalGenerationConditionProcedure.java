package net.mcreator.tllbutinblocks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Map;

@TllButInBlocksModElements.ModElement.Tag
public class TallVeinBushAdditionalGenerationConditionProcedure extends TllButInBlocksModElements.ModElement {
	public TallVeinBushAdditionalGenerationConditionProcedure(TllButInBlocksModElements instance) {
		super(instance, 47);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure TallVeinBushAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure TallVeinBushAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure TallVeinBushAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure TallVeinBushAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			return (false);
		}
		return (true);
	}
}
