package net.mcreator.messinaround.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.messinaround.init.MessinaroundModItems;

public class PointyStickSkewerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack result = ItemStack.EMPTY;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("messinaround:can_be_skewered")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.PORKCHOP) {
				result = new ItemStack(MessinaroundModItems.SKEWERED_PORK.get()).copy();
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.BEEF) {
				result = new ItemStack(MessinaroundModItems.SKEWERED_BEEF.get()).copy();
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.CHICKEN) {
				result = new ItemStack(MessinaroundModItems.SKEWERED_CHICKEN.get()).copy();
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.COD) {
				result = new ItemStack(MessinaroundModItems.SKEWERED_COD.get()).copy();
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.MUTTON) {
				result = new ItemStack(MessinaroundModItems.SKEWERED_MUTTON.get()).copy();
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.POTATO) {
				result = new ItemStack(MessinaroundModItems.SKEWERED_POTATO.get()).copy();
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.RABBIT) {
				result = new ItemStack(MessinaroundModItems.SKEWERED_RABBIT.get()).copy();
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.SALMON) {
				result = new ItemStack(MessinaroundModItems.SKEWERED_SALMON.get()).copy();
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack21 = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
				_setstack21.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() - 1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack21);
				ItemStack _setstack22 = result.copy();
				_setstack22.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack22);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}