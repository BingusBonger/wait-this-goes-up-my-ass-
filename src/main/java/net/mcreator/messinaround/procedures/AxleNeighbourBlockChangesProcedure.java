package net.mcreator.messinaround.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.init.MessinaroundModBlocks;

public class AxleNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.AXLE.get()
				&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == MessinaroundModBlocks.GENERATOR.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == MessinaroundModBlocks.GENERATOR.get()
						|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == MessinaroundModBlocks.GENERATOR.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MessinaroundModBlocks.GENERATOR.get()
						|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == MessinaroundModBlocks.GENERATOR.get() || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == MessinaroundModBlocks.GENERATOR.get())) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = MessinaroundModBlocks.AXLE_POWERED.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
	}
}