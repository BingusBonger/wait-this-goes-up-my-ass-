package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class CopperSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 149, 4f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:copper_sword_repair_items")));

	public CopperSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 3f, -2.6f));
	}
}