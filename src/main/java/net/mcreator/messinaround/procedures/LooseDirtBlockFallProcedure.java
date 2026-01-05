package net.mcreator.messinaround.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.init.MessinaroundModBlocks;

public class LooseDirtBlockFallProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FallingBlockEntity && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.LOOSE_DIRT_SLAB.get()) {
			if (!entity.level().isClientSide())
				entity.discard();
			world.setBlock(BlockPos.containing(x, y, z), MessinaroundModBlocks.LOOSE_DIRT_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}