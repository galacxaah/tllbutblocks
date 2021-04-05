package net.mcreator.tllbutinblocks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.IProperty;
import net.minecraft.block.BlockState;

import net.mcreator.tllbutinblocks.block.FleshBlock2Block;
import net.mcreator.tllbutinblocks.block.BloodyfleshblockBlock;
import net.mcreator.tllbutinblocks.block.BloodBlock;
import net.mcreator.tllbutinblocks.TllButInBlocksModElements;

import java.util.Map;

@TllButInBlocksModElements.ModElement.Tag
public class FleshBlockUpdateTickProcedure extends TllButInBlocksModElements.ModElement {
	public FleshBlockUpdateTickProcedure(TllButInBlocksModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure FleshBlockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure FleshBlockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure FleshBlockUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure FleshBlockUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = (double) (-20);
		found = (boolean) (false);
		for (int index0 = 0; index0 < (int) (40); index0++) {
			sy = (double) (-20);
			for (int index1 = 0; index1 < (int) (40); index1++) {
				sz = (double) (-20);
				for (int index2 = 0; index2 < (int) (40); index2++) {
					if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))))).getBlock() == BloodBlock.block
							.getDefaultState().getBlock())) {
						found = (boolean) (true);
						if ((((world.getBlockState(new BlockPos((int) ((x + (sx)) + 1), (int) y, (int) z))).getBlock() == FleshBlock2Block.block
								.getDefaultState().getBlock())
								|| (((world.getBlockState(new BlockPos((int) ((x + (sx)) - 1), (int) y, (int) z)))
										.getBlock() == FleshBlock2Block.block.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) x, (int) ((y + (sy)) + 1), (int) z)))
												.getBlock() == FleshBlock2Block.block.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) ((y + (sy)) + 1), (int) z)))
														.getBlock() == FleshBlock2Block.block.getDefaultState().getBlock())
														|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) ((z + (sz)) + 1))))
																.getBlock() == FleshBlock2Block.block.getDefaultState().getBlock()) || (true))))))) {
							{
								BlockPos _bp = new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)));
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
					sz = (double) ((sz) + 1);
				}
				sy = (double) ((sy) + 1);
			}
			sx = (double) ((sx) + 1);
		}
	}
}
