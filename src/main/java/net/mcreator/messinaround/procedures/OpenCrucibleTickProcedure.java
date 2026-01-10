package net.mcreator.messinaround.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.messinaround.init.MessinaroundModItems;

import java.util.Comparator;

public class OpenCrucibleTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean isSurrounded = false;
		ItemStack smeltingResult = ItemStack.EMPTY;
		isSurrounded = true;
		for (Direction directioniterator : Direction.Plane.HORIZONTAL) {
			if (!(world.getBlockState(BlockPos.containing(x + directioniterator.getStepX(), y + directioniterator.getStepY(), z + directioniterator.getStepZ())))
					.is(BlockTags.create(ResourceLocation.parse("messinaround:valid_crucible_heat_blocks")))) {
				isSurrounded = false;
			}
		}
		if (isSurrounded) {
			{
				final Vec3 _center = new Vec3((x + 0.5), y, (z + 0.5));
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof LivingEntity) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.IN_FIRE)), 2);
						entityiterator.igniteForSeconds(2);
					}
					if (entityiterator instanceof ItemEntity && ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Items.RAW_COPPER
							|| (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD)) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {Age:-60}");
							}
						}
						if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Items.RAW_COPPER) {
							smeltingResult = new ItemStack(MessinaroundModItems.COPPER_NUGGET.get()).copy();
						} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD) {
							smeltingResult = new ItemStack(Items.GOLD_NUGGET).copy();
						}
						entityiterator.getPersistentData().putDouble("cookinTime", (entityiterator.getPersistentData().getDoubleOr("cookinTime", 0) + 1));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0.025, 0, 0.025, 0.01);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.blastfurnace.fire_crackle")), SoundSource.BLOCKS, 1,
										(float) Mth.nextDouble(RandomSource.create(), 1.3, 1.6));
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.blastfurnace.fire_crackle")), SoundSource.BLOCKS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.3, 1.6), false);
							}
						}
						if (entityiterator.getPersistentData().getDoubleOr("cookinTime", 0) >= 60 * (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount()) {
							for (int index0 = 0; index0 < (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount(); index0++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), smeltingResult);
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator.getPersistentData().getDoubleOr("cookinTime", 0) == 0) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {Age:-600}");
							}
						}
					}
				}
			}
		}
	}
}