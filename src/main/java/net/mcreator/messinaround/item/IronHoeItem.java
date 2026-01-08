package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class IronHoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 512, 8f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:iron_hoe_repair_items")));

	public IronHoeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 1.5f, 0f, properties);
	}
}