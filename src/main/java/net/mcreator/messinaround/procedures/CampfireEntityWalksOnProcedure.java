package net.mcreator.messinaround.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.init.MessinaroundModBlocks;

public class CampfireEntityWalksOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.UNLIT_CAMPFIRE.get())) {
			if (entity instanceof LivingEntity) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.CAMPFIRE)), 1);
				entity.igniteForSeconds(2);
			}
		}
	}
}