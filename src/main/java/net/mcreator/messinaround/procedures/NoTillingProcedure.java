package net.mcreator.messinaround.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NoTillingProcedure {
	@SubscribeEvent
	public static void onUseHoe(BlockEvent.BlockToolModificationEvent event) {
		if (!event.isSimulated() && event.getItemAbility() == ItemAbilities.HOE_TILL && event.getPlayer() != null) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		if (event instanceof ICancellableEvent _cancellable) {
			_cancellable.setCanceled(true);
		}
	}
}