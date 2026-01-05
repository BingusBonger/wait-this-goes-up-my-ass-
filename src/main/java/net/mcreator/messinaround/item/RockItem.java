package net.mcreator.messinaround.item;

import net.minecraft.world.item.Item;

public class RockItem extends Item {
	public RockItem(Item.Properties properties) {
		super(properties.stacksTo(16));
	}
}