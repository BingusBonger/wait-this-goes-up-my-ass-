package net.mcreator.messinaround.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class BurntFoodItem extends Item {
	public BurntFoodItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(2f).build(), Consumables.defaultFood().consumeSeconds(2F).build()));
	}
}