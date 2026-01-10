package net.mcreator.messinaround.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.init.MessinaroundModItems;

public class SkeweredFoodWhileUsingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack cookedItem = ItemStack.EMPTY;
		if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && (world.getBlockState(BlockPos.containing(
				(Vec3.atLowerCornerOf(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos())).x(),
				(Vec3.atLowerCornerOf(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos())).y(),
				(Vec3.atLowerCornerOf(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos())).z())))
				.is(BlockTags.create(ResourceLocation.parse("messinaround:can_cook_skewered_food")))) {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			if (Math.random() < 0.02) {
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.smoker.smoke")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.2, 1.5));
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.smoker.smoke")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.2, 1.5), false);
						}
					}
				}
			}
			if (Math.random() < 0.04) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE,
							((Vec3.atLowerCornerOf(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos())).x()
									+ 0.5),
							((Vec3.atLowerCornerOf(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos())).y()
									+ 0.5),
							((Vec3.atLowerCornerOf(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos())).z()
									+ 0.5),
							2, 0.1, 0.1, 0.1, 0.01);
			}
			if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
				if (itemstack.getItem() == MessinaroundModItems.SKEWERED_PORK.get()) {
					cookedItem = new ItemStack(Items.COOKED_PORKCHOP).copy();
				} else if (itemstack.getItem() == MessinaroundModItems.SKEWERED_BEEF.get()) {
					cookedItem = new ItemStack(Items.COOKED_BEEF).copy();
				} else if (itemstack.getItem() == MessinaroundModItems.SKEWERED_CHICKEN.get()) {
					cookedItem = new ItemStack(Items.COOKED_CHICKEN).copy();
				} else if (itemstack.getItem() == MessinaroundModItems.SKEWERED_COD.get()) {
					cookedItem = new ItemStack(Items.COOKED_COD).copy();
				} else if (itemstack.getItem() == MessinaroundModItems.SKEWERED_MUTTON.get()) {
					cookedItem = new ItemStack(Items.COOKED_MUTTON).copy();
				} else if (itemstack.getItem() == MessinaroundModItems.SKEWERED_POTATO.get()) {
					cookedItem = new ItemStack(Items.BAKED_POTATO).copy();
				} else if (itemstack.getItem() == MessinaroundModItems.SKEWERED_RABBIT.get()) {
					cookedItem = new ItemStack(Items.COOKED_RABBIT).copy();
				} else if (itemstack.getItem() == MessinaroundModItems.SKEWERED_SALMON.get()) {
					cookedItem = new ItemStack(Items.COOKED_SALMON).copy();
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack43 = cookedItem.copy();
					_setstack43.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack43);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(MessinaroundModItems.POINTY_STICK.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
	}
}