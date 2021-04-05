package net.mcreator.tllbutinblocks.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.IProperty;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.tllbutinblocks.particle.BloodparticlesParticle;
import net.mcreator.tllbutinblocks.block.FleshBlockBlock;
import net.mcreator.tllbutinblocks.block.FleshBlock2Block;
import net.mcreator.tllbutinblocks.block.BloodyfleshblockBlock;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Map;

@TllButInBlocksModElements.ModElement.Tag
public class BleedingpotionOnPotionActiveTickProcedure extends TllButInBlocksModElements.ModElement {
	public BleedingpotionOnPotionActiveTickProcedure(TllButInBlocksModElements instance) {
		super(instance, 58);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BleedingpotionOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BleedingpotionOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BleedingpotionOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BleedingpotionOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BleedingpotionOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double k = 0;
		if (((entity.getPersistentData().getDouble("timer")) < 40)) {
			entity.getPersistentData().putDouble("timer", ((entity.getPersistentData().getDouble("timer")) + 1));
		} else {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 1));
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(BloodparticlesParticle.particle, x, y, z, (int) 10, 0, 0, 0, 0.3);
				}
			}
			entity.getPersistentData().putDouble("timer", 0);
		}
		if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == FleshBlockBlock.block.getDefaultState()
				.getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == FleshBlock2Block.block.getDefaultState()
						.getBlock()))) {
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) z);
				BlockState _bs = BloodyfleshblockBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
