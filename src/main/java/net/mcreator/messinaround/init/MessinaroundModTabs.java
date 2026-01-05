/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.messinaround.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.messinaround.MessinaroundMod;

@EventBusSubscriber
public class MessinaroundModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MessinaroundMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> JUS_MESSIN_AROUND_TAB = REGISTRY.register("jus_messin_around_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.messinaround.jus_messin_around_tab")).icon(() -> new ItemStack(MessinaroundModItems.ROCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MessinaroundModItems.WICKERIN_MY_BASKET.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(MessinaroundModItems.SHARP_ROCK.get());
			tabData.accept(MessinaroundModItems.POINTY_STICK.get());
			tabData.accept(MessinaroundModItems.BONE_KNIFE.get());
		}
	}
}