package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class IronAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 512, 8f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:iron_axe_repair_items")));

	public IronAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 6.5f, -3.2f, properties);
	}
}