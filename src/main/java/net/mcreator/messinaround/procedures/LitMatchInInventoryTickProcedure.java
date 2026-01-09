package net.mcreator.messinaround.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;

public class LitMatchInInventoryTickProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		if (Math.random() < 0.05) {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(20, _level, null, _stkprov -> {
				});
			}
		}
	}
}