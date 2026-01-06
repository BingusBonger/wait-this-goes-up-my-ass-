package net.mcreator.messinaround.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

import net.mcreator.messinaround.procedures.PrimToolsCraftedProcedure;

public class BoneKnifeItem extends ShearsItem {
	public BoneKnifeItem(Item.Properties properties) {
		super(properties.component(DataComponents.TOOL, ShearsItem.createToolProperties()).durability(12).enchantable(1).setNoCombineRepair());
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState blockstate) {
		return 0f;
	}

	@Override
	public ItemStack getCraftingRemainder(ItemStack itemstack) {
		ItemStack retval = new ItemStack(this);
		retval.setDamageValue(itemstack.getDamageValue() + 1);
		if (retval.getDamageValue() >= retval.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return retval;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Player entity) {
		super.onCraftedBy(itemstack, entity);
		PrimToolsCraftedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}
}