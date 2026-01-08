package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class CopperAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 149, 4f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:copper_axe_repair_items")));

	public CopperAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 5f, -3.25f, properties);
	}
}