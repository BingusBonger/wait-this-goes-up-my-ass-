package net.mcreator.messinaround.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.init.MessinaroundModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AxlePowerCheckProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlacedAgainst());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState placedagainst) {
		execute(null, world, x, y, z, placedagainst);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState placedagainst) {
		if (placedagainst.getBlock() == MessinaroundModBlocks.GENERATOR.get() && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.AXLE.get()) {
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