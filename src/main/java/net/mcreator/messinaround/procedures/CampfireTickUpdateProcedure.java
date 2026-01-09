package net.mcreator.messinaround.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.ProblemReporter;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.init.MessinaroundModItems;
import net.mcreator.messinaround.init.MessinaroundModBlocks;

import java.util.Comparator;

public class CampfireTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double addedFuel = 0;
		if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "initialized")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("initialized", true);
					_blockEntity.getPersistentData().putDouble("fuel", 30);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isLit")) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.UNLIT_CAMPFIRE.get()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = MessinaroundModBlocks.LIT_CAMPFIRE_0.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata(world.registryAccess());
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
							} catch (Exception ignored) {
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.blaze.shoot")), SoundSource.BLOCKS, (float) 0.75,
								(float) (Mth.nextDouble(RandomSource.create(), 1.1, 1.4) - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") * 0.0005));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.blaze.shoot")), SoundSource.BLOCKS, (float) 0.75,
								(float) (Mth.nextDouble(RandomSource.create(), 1.1, 1.4) - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") * 0.0005), false);
					}
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("fuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") - 0.5));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") <= 0) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.75,
								(float) Mth.nextDouble(RandomSource.create(), 0.75, 1.2));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.75, (float) Mth.nextDouble(RandomSource.create(), 0.75, 1.2), false);
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") >= 120 && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.LIT_CAMPFIRE_1.get())) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = MessinaroundModBlocks.LIT_CAMPFIRE_1.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata(world.registryAccess());
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") < 120 && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.LIT_CAMPFIRE_1.get()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = MessinaroundModBlocks.LIT_CAMPFIRE_0.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata(world.registryAccess());
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
							} catch (Exception ignored) {
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.75,
								(float) Mth.nextDouble(RandomSource.create(), 1.4, 1.6));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.75, (float) Mth.nextDouble(RandomSource.create(), 1.4, 1.6), false);
					}
				}
			}
			world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (x + 0.5), (y + 0.25), (z + 0.5), (Mth.nextDouble(RandomSource.create(), -0.01, 0.01)), 0.2, (Mth.nextDouble(RandomSource.create(), -0.01, 0.01)));
			if (Math.random() < 0.2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.campfire.crackle")), SoundSource.BLOCKS, (float) 0.75,
								(float) Mth.nextDouble(RandomSource.create(), 0.75, 1.2));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.campfire.crackle")), SoundSource.BLOCKS, (float) 0.75, (float) Mth.nextDouble(RandomSource.create(), 0.75, 1.2), false);
					}
				}
			}
			{
				final Vec3 _center = new Vec3((x + 0.5), y, (z + 0.5));
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof ItemEntity) {
						if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("messinaround:campfire_valid_fuels")))) {
							addedFuel = 0;
							if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:logs")))) {
								addedFuel = addedFuel + 240 * (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount();
							} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Items.COAL) {
								addedFuel = addedFuel + 720 * (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount();
							} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MessinaroundModItems.COAL_DUST.get()) {
								addedFuel = addedFuel + 360 * (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount();
							} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:planks")))) {
								addedFuel = addedFuel + 60 * (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount();
							} else if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("messinaround:bark")))
									|| (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MessinaroundModItems.CHUNK_O_WOOD.get()
									|| (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Items.STICK) {
								addedFuel = addedFuel + 10 * (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount();
							} else {
								addedFuel = addedFuel + 5 * (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount();
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 0.5), y, (z + 0.5), 2, 0.1, 0.1, 0.1, 0.01);
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null) {
									_blockEntity.getPersistentData().putDouble("fuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") + addedFuel));
								}
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") >= 720) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("fuel", 720);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.75,
												(float) Mth.nextDouble(RandomSource.create(), 0.75, 1.2));
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.75,
												(float) Mth.nextDouble(RandomSource.create(), 0.75, 1.2), false);
									}
								}
							} else {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.blaze.shoot")), SoundSource.BLOCKS, (float) 0.75,
												(float) (Mth.nextDouble(RandomSource.create(), 1.1, 1.4) - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") * 0.0005));
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.blaze.shoot")), SoundSource.BLOCKS, (float) 0.75,
												(float) (Mth.nextDouble(RandomSource.create(), 1.1, 1.4) - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") * 0.0005), false);
									}
								}
							}
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == MessinaroundModBlocks.COPPER_SKILLET.get()) {
				CampfireCookingProcedure.execute(world, x, y, z);
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}