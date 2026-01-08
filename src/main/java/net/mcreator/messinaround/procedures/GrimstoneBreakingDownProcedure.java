package net.mcreator.messinaround.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.messinaround.init.MessinaroundModItems;
import net.mcreator.messinaround.init.MessinaroundModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GrimstoneBreakingDownProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState storedBlock = Blocks.AIR.defaultBlockState();
		String blockName = "";
		Direction sideBroken = Direction.NORTH;
		if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("messinaround:grimstone_breaking_stages")))
					&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("messinaround:gaydon_tier")))
							&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.PICKAXES))) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("messinaround:iron_tier")))
						&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.PICKAXES)) {
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.GRIMSTONE.get()) {
						storedBlock = MessinaroundModBlocks.COBBLED_GRIMSTONE.get().defaultBlockState();
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.COBBLED_GRIMSTONE.get()) {
						storedBlock = MessinaroundModBlocks.GRIMSTONE_BREAKING_STAGE_1.get().defaultBlockState();
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MessinaroundModBlocks.GRIMSTONE_BREAKING_STAGE_8.get()) {
						world.destroyBlock(BlockPos.containing(x, y, z), false);
					} else {
						blockName = BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString();
						blockName = blockName.replaceAll("7", "8");
						blockName = blockName.replaceAll("6", "7");
						blockName = blockName.replaceAll("5", "6");
						blockName = blockName.replaceAll("4", "5");
						blockName = blockName.replaceAll("3", "4");
						blockName = blockName.replaceAll("2", "3");
						blockName = blockName.replaceAll("1", "2");
						storedBlock = BuiltInRegistries.BLOCK.getValue(ResourceLocation.parse((blockName).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
					}
					sideBroken = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getDirection();
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.nether_bricks.break")), SoundSource.BLOCKS, 1,
									(float) Mth.nextDouble(RandomSource.create(), 0.6, 0.75));
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.nether_bricks.break")), SoundSource.BLOCKS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.6, 0.75), false);
						}
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5 + sideBroken.getStepX() * 0.75), (y + 0.5 + sideBroken.getStepY() * 0.75), (z + 0.5 + sideBroken.getStepZ() * 0.75),
								new ItemStack(MessinaroundModItems.BLACK_ROCK.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = storedBlock;
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
				} else {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}