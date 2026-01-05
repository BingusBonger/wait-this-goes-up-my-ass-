package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class PointyStickItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 1, 1.5f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:pointy_stick_repair_items")));

	public PointyStickItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 0f, -3f));
	}
}