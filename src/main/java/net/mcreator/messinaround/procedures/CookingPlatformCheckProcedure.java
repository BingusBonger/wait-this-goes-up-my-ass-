package net.mcreator.messinaround.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.init.MessinaroundModBlocks;

public class CookingPlatformCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MessinaroundModBlocks.UNLIT_CAMPFIRE.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MessinaroundModBlocks.LIT_CAMPFIRE_0.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MessinaroundModBlocks.LIT_CAMPFIRE_1.get())) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}