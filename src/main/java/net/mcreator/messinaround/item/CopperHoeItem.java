package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class CopperHoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 149, 4f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:copper_hoe_repair_items")));

	public CopperHoeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 1f, 0f, properties);
	}
}