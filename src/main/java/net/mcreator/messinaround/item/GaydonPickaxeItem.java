package net.mcreator.messinaround.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class GaydonPickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1536, 16f, 0, 20, TagKey.create(Registries.ITEM, ResourceLocation.parse("messinaround:gaydon_pickaxe_repair_items")));

	public GaydonPickaxeItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 4f, -2.8f));
	}
}