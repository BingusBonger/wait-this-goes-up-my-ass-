package net.mcreator.messinaround.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.init.MessinaroundModBlocks;

public class LooseDirtSlabMergeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MessinaroundModBlocks.LOOSE_DIRT_SLAB.get()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z), MessinaroundModBlocks.LOOSE_DIRT_BLOCK.get().defaultBlockState(), 3);
		}
	}
}