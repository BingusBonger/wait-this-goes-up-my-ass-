package net.mcreator.messinaround.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.core.component.DataComponents;

import net.mcreator.messinaround.init.MessinaroundModItems;

@EventBusSubscriber
public class RockItem extends Item {
	public RockItem(Item.Properties properties) {
		super(properties.stacksTo(16).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).build(), Consumables.defaultFood().consumeSeconds(3.2F).build()));
	}

	@SubscribeEvent
	public static void modifyItemComponents(ModifyDefaultComponentsEvent event) {
		event.modify(MessinaroundModItems.ROCK.get(), builder -> builder.set(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStack(MessinaroundModItems.SHARP_ROCK.get()))));
	}
}