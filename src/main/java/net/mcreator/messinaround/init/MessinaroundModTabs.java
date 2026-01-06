/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.messinaround.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.messinaround.MessinaroundMod;

public class MessinaroundModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MessinaroundMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> JUS_MESSIN_AROUND_TAB = REGISTRY.register("jus_messin_around_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.messinaround.jus_messin_around_tab")).icon(() -> new ItemStack(MessinaroundModItems.ROCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MessinaroundModBlocks.LOOSE_DIRT_SLAB.get().asItem());
				tabData.accept(MessinaroundModBlocks.LOOSE_DIRT_BLOCK.get().asItem());
				tabData.accept(MessinaroundModItems.DIRT_PILE.get());
				tabData.accept(MessinaroundModBlocks.AXLE.get().asItem());
				tabData.accept(MessinaroundModItems.SHARP_ROCK.get());
				tabData.accept(MessinaroundModItems.ROCK.get());
				tabData.accept(MessinaroundModItems.PILE_OF_ROCKS.get());
				tabData.accept(MessinaroundModItems.WICKERIN_MY_BASKET.get());
				tabData.accept(MessinaroundModItems.POINTY_STICK.get());
				tabData.accept(MessinaroundModItems.BONE_KNIFE.get());
				tabData.accept(MessinaroundModBlocks.AXLE_POWERED.get().asItem());
				tabData.accept(MessinaroundModBlocks.GENERATOR.get().asItem());
				tabData.accept(MessinaroundModItems.GRASS_FABRIC.get());
				tabData.accept(MessinaroundModItems.OAK_BARK.get());
				tabData.accept(MessinaroundModItems.SPRUCE_BARK.get());
				tabData.accept(MessinaroundModItems.DARK_OAK_BARK.get());
				tabData.accept(MessinaroundModItems.MANGROVE_BARK.get());
				tabData.accept(MessinaroundModItems.JUNGLE_BARK.get());
				tabData.accept(MessinaroundModItems.PALE_OAK_BARK.get());
				tabData.accept(MessinaroundModItems.ACACIA_BARK.get());
				tabData.accept(MessinaroundModItems.BIRCH_BARK.get());
				tabData.accept(MessinaroundModItems.CHERRY_BARK.get());
				tabData.accept(MessinaroundModBlocks.STRIPPED_OAK_LOG_BREAKING_STAGE_1.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_OAK_LOG_BREAKING_STAGE_2.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_OAK_LOG_BREAKING_STAGE_3.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_1.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_2.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_3.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_BIRCH_LOG_BREAKING_STAGE_1.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_BIRCH_LOG_BREAKING_STAGE_2.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_BIRCH_LOG_BREAKING_STAGE_3.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_ACACIA_LOG_BREAKING_STAGE_1.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_ACACIA_LOG_BREAKING_STAGE_2.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_ACACIA_LOG_BREAKING_STAGE_3.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_CHERRY_LOG_BREAKING_STAGE_1.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_CHERRY_LOG_BREAKING_STAGE_2.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_CHERRY_LOG_BREAKING_STAGE_3.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_JUNGLE_LOG_BREAKING_STAGE_1.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_JUNGLE_LOG_BREAKING_STAGE_2.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_JUNGLE_LOG_BREAKING_STAGE_3.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_SPRUCE_LOG_BREAKING_STAGE_1.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_SPRUCE_LOG_BREAKING_STAGE_2.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_SPRUCE_LOG_BREAKING_STAGE_3.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_MANGROVE_LOG_BREAKING_STAGE_1.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_MANGROVE_LOG_BREAKING_STAGE_2.get().asItem());
				tabData.accept(MessinaroundModBlocks.STRIPPED_MANGROVE_LOG_BREAKING_STAGE_3.get().asItem());
			}).build());
}