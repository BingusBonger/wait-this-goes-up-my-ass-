package net.mcreator.messinaround.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.procedures.PrimToolsCraftedProcedure;
import net.mcreator.messinaround.init.MessinaroundModBlocks;

import java.util.function.Consumer;
import java.util.List;

public class PointyStickItem extends Item {
	public PointyStickItem(Item.Properties properties) {
		super(properties.durability(2).attributes(ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
				.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build()).enchantable(1));
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
		return List.of(Blocks.STONE, MessinaroundModBlocks.BREAKING_STAGE_1.get(), MessinaroundModBlocks.BREAKING_STAGE_2.get(), MessinaroundModBlocks.BREAKING_STAGE_3.get(), MessinaroundModBlocks.BREAKING_STAGE_4.get(),
				MessinaroundModBlocks.BREAKING_STAGE_5.get(), MessinaroundModBlocks.BREAKING_STAGE_6.get(), MessinaroundModBlocks.BREAKING_STAGE_7.get(), MessinaroundModBlocks.BREAKING_STAGE_8.get()).contains(blockstate.getBlock()) ? 1.5f : 1;
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		itemstack.hurtAndBreak(1, entity, LivingEntity.getSlotForHand(entity.getUsedItemHand()));
		return true;
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		itemstack.hurtAndBreak(2, entity, LivingEntity.getSlotForHand(entity.getUsedItemHand()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.messinaround.pointy_stick.description_0"));
		componentConsumer.accept(Component.translatable("item.messinaround.pointy_stick.description_1"));
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Player entity) {
		super.onCraftedBy(itemstack, entity);
		PrimToolsCraftedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}