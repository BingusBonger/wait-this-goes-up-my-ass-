package net.mcreator.messinaround.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class ExperimentalSteakCookerTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3((x + 0.5), (y + 1), (z + 0.5));
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof ItemEntity) {
					entityiterator.getPersistentData().putDouble("Age", 0);
					entityiterator.getPersistentData().putDouble("cookinTime", 0);
				}
			}
		}
	}
}