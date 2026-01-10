package net.mcreator.messinaround.procedures;

import net.neoforged.bus.api.Event;

public class HempCripAdditionalHarvestConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("messinaround:shears")))) {
			return true;
		}
		return false;
	}
}