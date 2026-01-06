package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.messinaround.procedures.PrimToolsCraftedProcedure;

public class BoneHoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 24, 2f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:bone_hoe_repair_items")));

	public BoneHoeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 1f, 2.9f, properties);
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Player entity) {
		super.onCraftedBy(itemstack, entity);
		PrimToolsCraftedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}
}