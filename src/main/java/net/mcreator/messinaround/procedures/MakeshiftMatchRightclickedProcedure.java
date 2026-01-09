package net.mcreator.messinaround.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.init.MessinaroundModItems;

public class MakeshiftMatchRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("messinaround:can_strike_match_on")))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack5 = new ItemStack(MessinaroundModItems.MAKESHIFT_MATCH_LIT.get()).copy();
				_setstack5.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack5);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.extinguish")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.9, 2.2));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.extinguish")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.9, 2.2), false);
				}
			}
		}
	}
}