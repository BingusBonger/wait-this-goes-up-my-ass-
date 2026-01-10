package net.mcreator.messinaround.procedures;

import net.neoforged.bus.api.Event;

public class UnfiredCuckTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MessinaroundModBlocks.LIT_CAMPFIRE_0.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MessinaroundModBlocks.LIT_CAMPFIRE_1.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("drynessLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "drynessLevel") + 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 0.5), (y + 0.5), (z + 0.5), 3, 0.5, 0.5, 0.5, 0.1);
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "drynessLevel") >= 1200) {
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(MessinaroundModBlocks.UNFIRED_CUCK.get().defaultBlockState()));
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = MessinaroundModBlocks.OPEN_CUCK.get().defaultBlockState();
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

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}