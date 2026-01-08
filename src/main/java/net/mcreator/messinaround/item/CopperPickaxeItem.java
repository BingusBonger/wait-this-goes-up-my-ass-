package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class CopperPickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 149, 4f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:copper_pickaxe_repair_items")));

	public CopperPickaxeItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 2f, -2.9f));
	}
}