package net.mcreator.messinaround.item;

import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.messinaround.procedures.LitMatchInInventoryTickProcedure;
import net.mcreator.messinaround.procedures.LitMatchInHandProcedure;

import javax.annotation.Nullable;

import java.util.function.Consumer;

public class MakeshiftMatchLitItem extends Item {
	public MakeshiftMatchLitItem(Item.Properties properties) {
		super(properties.durability(400));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.messinaround.makeshift_match_lit.description_0"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		if (equipmentSlot == EquipmentSlot.MAINHAND)
			LitMatchInHandProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
		LitMatchInInventoryTickProcedure.execute(world, itemstack);
	}
}