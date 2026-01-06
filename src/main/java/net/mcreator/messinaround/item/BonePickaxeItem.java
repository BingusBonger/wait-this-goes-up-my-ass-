package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.messinaround.procedures.PrimToolsCraftedProcedure;

public class BonePickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 24, 4f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:bone_pickaxe_repair_items")));

	public BonePickaxeItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 1f, -3f));
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Player entity) {
		super.onCraftedBy(itemstack, entity);
		PrimToolsCraftedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}
}