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
				tabData.accept(MessinaroundModItems.BONE_AXE.get());
				tabData.accept(MessinaroundModItems.BONE_PICKAXE.get());
				tabData.accept(MessinaroundModItems.BONE_HOE.get());
				tabData.accept(MessinaroundModItems.DEEP_ROCK.get());
				tabData.accept(MessinaroundModItems.BLACK_ROCK.get());
				tabData.accept(MessinaroundModItems.LEATHER_STRIP.get());
				tabData.accept(MessinaroundModItems.BOTTLE_OF_RAINBOW.get());
				tabData.accept(MessinaroundModItems.GRASS_GEAR_HELMET.get());
				tabData.accept(MessinaroundModItems.GRASS_GEAR_CHESTPLATE.get());
				tabData.accept(MessinaroundModItems.GRASS_GEAR_LEGGINGS.get());
				tabData.accept(MessinaroundModItems.GRASS_GEAR_BOOTS.get());
				tabData.accept(MessinaroundModBlocks.COOCIBLE.get().asItem());
				tabData.accept(MessinaroundModItems.HEMP_SEEDS.get());
				tabData.accept(MessinaroundModItems.CHUNK_O_WOOD.get());
				tabData.accept(MessinaroundModBlocks.EXPERIMENTAL_STEAK_COOKER.get().asItem());
				tabData.accept(MessinaroundModBlocks.OPEN_CUCK.get().asItem());
				tabData.accept(MessinaroundModBlocks.PIPE_EMPTY.get().asItem());
				tabData.accept(MessinaroundModBlocks.PIPE_FULL.get().asItem());
				tabData.accept(MessinaroundModItems.COPPER_NUGGET.get());
				tabData.accept(MessinaroundModItems.COPPER_SWORD.get());
				tabData.accept(MessinaroundModItems.COPPER_AXE.get());
				tabData.accept(MessinaroundModItems.COPPER_PICKAXE.get());
				tabData.accept(MessinaroundModItems.COPPER_SHOVEL.get());
				tabData.accept(MessinaroundModItems.COPPER_HOE.get());
				tabData.accept(MessinaroundModBlocks.GRIMSTONE.get().asItem());
				tabData.accept(MessinaroundModBlocks.GRIMSTONE_DIAMOND_ORE.get().asItem());
				tabData.accept(MessinaroundModBlocks.GRIMSTONE_GOLD_ORE.get().asItem());
				tabData.accept(MessinaroundModBlocks.GRIMSTONE_LAPIS_ORE.get().asItem());
				tabData.accept(MessinaroundModBlocks.GRIMSTONE_REDSTONE_ORE.get().asItem());
				tabData.accept(MessinaroundModBlocks.COBBLED_GRIMSTONE.get().asItem());
				tabData.accept(MessinaroundModItems.IRON_SWORD.get());
				tabData.accept(MessinaroundModItems.IRON_AXE.get());
				tabData.accept(MessinaroundModItems.IRON_PICKAXE.get());
				tabData.accept(MessinaroundModItems.IRON_SHOVEL.get());
				tabData.accept(MessinaroundModItems.IRON_HOE.get());
			}).build());
}