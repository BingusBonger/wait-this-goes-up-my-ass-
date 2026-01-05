package net.mcreator.messinaround.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class MineSlowerProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity) {
			AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("messinaround:mine_slower"), 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
			if (!_entity.getAttribute(Attributes.BLOCK_BREAK_SPEED).hasModifier(modifier.id())) {
				_entity.getAttribute(Attributes.BLOCK_BREAK_SPEED).addPermanentModifier(modifier);
			}
		}
	}
}