/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.messinaround.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.messinaround.item.*;
import net.mcreator.messinaround.MessinaroundMod;

import java.util.function.Function;

public class MessinaroundModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MessinaroundMod.MODID);
	public static final DeferredItem<Item> LOOSE_DIRT_SLAB;
	public static final DeferredItem<Item> LOOSE_DIRT_BLOCK;
	public static final DeferredItem<Item> DIRT_PILE;
	public static final DeferredItem<Item> AXLE;
	public static final DeferredItem<Item> SHARP_ROCK;
	public static final DeferredItem<Item> ROCK;
	public static final DeferredItem<Item> PILE_OF_ROCKS;
	public static final DeferredItem<Item> WICKERIN_MY_BASKET;
	public static final DeferredItem<Item> POINTY_STICK;
	public static final DeferredItem<Item> BONE_KNIFE;
	public static final DeferredItem<Item> AXLE_POWERED;
	public static final DeferredItem<Item> GENERATOR;
	public static final DeferredItem<Item> BREAKING_STAGE_1;
	public static final DeferredItem<Item> BREAKING_STAGE_2;
	public static final DeferredItem<Item> BREAKING_STAGE_3;
	public static final DeferredItem<Item> BREAKING_STAGE_4;
	public static final DeferredItem<Item> BREAKING_STAGE_5;
	public static final DeferredItem<Item> BREAKING_STAGE_6;
	public static final DeferredItem<Item> BREAKING_STAGE_7;
	public static final DeferredItem<Item> GRASS_FABRIC;
	public static final DeferredItem<Item> OAK_BARK;
	public static final DeferredItem<Item> SPRUCE_BARK;
	public static final DeferredItem<Item> DARK_OAK_BARK;
	public static final DeferredItem<Item> MANGROVE_BARK;
	public static final DeferredItem<Item> JUNGLE_BARK;
	public static final DeferredItem<Item> PALE_OAK_BARK;
	public static final DeferredItem<Item> ACACIA_BARK;
	public static final DeferredItem<Item> BIRCH_BARK;
	public static final DeferredItem<Item> CHERRY_BARK;
	public static final DeferredItem<Item> STRIPPED_OAK_LOG_BREAKING_STAGE_1;
	public static final DeferredItem<Item> STRIPPED_OAK_LOG_BREAKING_STAGE_2;
	public static final DeferredItem<Item> STRIPPED_OAK_LOG_BREAKING_STAGE_3;
	public static final DeferredItem<Item> STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_1;
	public static final DeferredItem<Item> STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_2;
	public static final DeferredItem<Item> STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_3;
	public static final DeferredItem<Item> STRIPPED_BIRCH_LOG_BREAKING_STAGE_1;
	public static final DeferredItem<Item> STRIPPED_BIRCH_LOG_BREAKING_STAGE_2;
	public static final DeferredItem<Item> STRIPPED_BIRCH_LOG_BREAKING_STAGE_3;
	public static final DeferredItem<Item> STRIPPED_ACACIA_LOG_BREAKING_STAGE_1;
	public static final DeferredItem<Item> STRIPPED_ACACIA_LOG_BREAKING_STAGE_2;
	public static final DeferredItem<Item> STRIPPED_ACACIA_LOG_BREAKING_STAGE_3;
	public static final DeferredItem<Item> STRIPPED_CHERRY_LOG_BREAKING_STAGE_1;
	public static final DeferredItem<Item> STRIPPED_CHERRY_LOG_BREAKING_STAGE_2;
	public static final DeferredItem<Item> STRIPPED_CHERRY_LOG_BREAKING_STAGE_3;
	public static final DeferredItem<Item> STRIPPED_JUNGLE_LOG_BREAKING_STAGE_1;
	public static final DeferredItem<Item> STRIPPED_JUNGLE_LOG_BREAKING_STAGE_2;
	public static final DeferredItem<Item> STRIPPED_JUNGLE_LOG_BREAKING_STAGE_3;
	public static final DeferredItem<Item> STRIPPED_SPRUCE_LOG_BREAKING_STAGE_1;
	public static final DeferredItem<Item> STRIPPED_SPRUCE_LOG_BREAKING_STAGE_2;
	public static final DeferredItem<Item> STRIPPED_SPRUCE_LOG_BREAKING_STAGE_3;
	public static final DeferredItem<Item> STRIPPED_MANGROVE_LOG_BREAKING_STAGE_1;
	public static final DeferredItem<Item> STRIPPED_MANGROVE_LOG_BREAKING_STAGE_2;
	public static final DeferredItem<Item> STRIPPED_MANGROVE_LOG_BREAKING_STAGE_3;
	static {
		LOOSE_DIRT_SLAB = block(MessinaroundModBlocks.LOOSE_DIRT_SLAB);
		LOOSE_DIRT_BLOCK = block(MessinaroundModBlocks.LOOSE_DIRT_BLOCK);
		DIRT_PILE = register("dirt_pile", DirtPileItem::new);
		AXLE = block(MessinaroundModBlocks.AXLE);
		SHARP_ROCK = register("sharp_rock", SharpRockItem::new);
		ROCK = register("rock", RockItem::new);
		PILE_OF_ROCKS = register("pile_of_rocks", PileOfRocksItem::new);
		WICKERIN_MY_BASKET = register("wickerin_my_basket", WickerinMyBasketItem::new);
		POINTY_STICK = register("pointy_stick", PointyStickItem::new);
		BONE_KNIFE = register("bone_knife", BoneKnifeItem::new);
		AXLE_POWERED = block(MessinaroundModBlocks.AXLE_POWERED, new Item.Properties().stacksTo(16));
		GENERATOR = block(MessinaroundModBlocks.GENERATOR);
		BREAKING_STAGE_1 = block(MessinaroundModBlocks.BREAKING_STAGE_1);
		BREAKING_STAGE_2 = block(MessinaroundModBlocks.BREAKING_STAGE_2);
		BREAKING_STAGE_3 = block(MessinaroundModBlocks.BREAKING_STAGE_3);
		BREAKING_STAGE_4 = block(MessinaroundModBlocks.BREAKING_STAGE_4);
		BREAKING_STAGE_5 = block(MessinaroundModBlocks.BREAKING_STAGE_5);
		BREAKING_STAGE_6 = block(MessinaroundModBlocks.BREAKING_STAGE_6);
		BREAKING_STAGE_7 = block(MessinaroundModBlocks.BREAKING_STAGE_7);
		GRASS_FABRIC = register("grass_fabric", GrassFabricItem::new);
		OAK_BARK = register("oak_bark", OakBarkItem::new);
		SPRUCE_BARK = register("spruce_bark", SpruceBarkItem::new);
		DARK_OAK_BARK = register("dark_oak_bark", DarkOakBarkItem::new);
		MANGROVE_BARK = register("mangrove_bark", MangroveBarkItem::new);
		JUNGLE_BARK = register("jungle_bark", JungleBarkItem::new);
		PALE_OAK_BARK = register("pale_oak_bark", PaleOakBarkItem::new);
		ACACIA_BARK = register("acacia_bark", AcaciaBarkItem::new);
		BIRCH_BARK = register("birch_bark", BirchBarkItem::new);
		CHERRY_BARK = register("cherry_bark", CherryBarkItem::new);
		STRIPPED_OAK_LOG_BREAKING_STAGE_1 = block(MessinaroundModBlocks.STRIPPED_OAK_LOG_BREAKING_STAGE_1);
		STRIPPED_OAK_LOG_BREAKING_STAGE_2 = block(MessinaroundModBlocks.STRIPPED_OAK_LOG_BREAKING_STAGE_2);
		STRIPPED_OAK_LOG_BREAKING_STAGE_3 = block(MessinaroundModBlocks.STRIPPED_OAK_LOG_BREAKING_STAGE_3);
		STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_1 = block(MessinaroundModBlocks.STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_1);
		STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_2 = block(MessinaroundModBlocks.STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_2);
		STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_3 = block(MessinaroundModBlocks.STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_3);
		STRIPPED_BIRCH_LOG_BREAKING_STAGE_1 = block(MessinaroundModBlocks.STRIPPED_BIRCH_LOG_BREAKING_STAGE_1);
		STRIPPED_BIRCH_LOG_BREAKING_STAGE_2 = block(MessinaroundModBlocks.STRIPPED_BIRCH_LOG_BREAKING_STAGE_2);
		STRIPPED_BIRCH_LOG_BREAKING_STAGE_3 = block(MessinaroundModBlocks.STRIPPED_BIRCH_LOG_BREAKING_STAGE_3);
		STRIPPED_ACACIA_LOG_BREAKING_STAGE_1 = block(MessinaroundModBlocks.STRIPPED_ACACIA_LOG_BREAKING_STAGE_1);
		STRIPPED_ACACIA_LOG_BREAKING_STAGE_2 = block(MessinaroundModBlocks.STRIPPED_ACACIA_LOG_BREAKING_STAGE_2);
		STRIPPED_ACACIA_LOG_BREAKING_STAGE_3 = block(MessinaroundModBlocks.STRIPPED_ACACIA_LOG_BREAKING_STAGE_3);
		STRIPPED_CHERRY_LOG_BREAKING_STAGE_1 = block(MessinaroundModBlocks.STRIPPED_CHERRY_LOG_BREAKING_STAGE_1);
		STRIPPED_CHERRY_LOG_BREAKING_STAGE_2 = block(MessinaroundModBlocks.STRIPPED_CHERRY_LOG_BREAKING_STAGE_2);
		STRIPPED_CHERRY_LOG_BREAKING_STAGE_3 = block(MessinaroundModBlocks.STRIPPED_CHERRY_LOG_BREAKING_STAGE_3);
		STRIPPED_JUNGLE_LOG_BREAKING_STAGE_1 = block(MessinaroundModBlocks.STRIPPED_JUNGLE_LOG_BREAKING_STAGE_1);
		STRIPPED_JUNGLE_LOG_BREAKING_STAGE_2 = block(MessinaroundModBlocks.STRIPPED_JUNGLE_LOG_BREAKING_STAGE_2);
		STRIPPED_JUNGLE_LOG_BREAKING_STAGE_3 = block(MessinaroundModBlocks.STRIPPED_JUNGLE_LOG_BREAKING_STAGE_3);
		STRIPPED_SPRUCE_LOG_BREAKING_STAGE_1 = block(MessinaroundModBlocks.STRIPPED_SPRUCE_LOG_BREAKING_STAGE_1);
		STRIPPED_SPRUCE_LOG_BREAKING_STAGE_2 = block(MessinaroundModBlocks.STRIPPED_SPRUCE_LOG_BREAKING_STAGE_2);
		STRIPPED_SPRUCE_LOG_BREAKING_STAGE_3 = block(MessinaroundModBlocks.STRIPPED_SPRUCE_LOG_BREAKING_STAGE_3);
		STRIPPED_MANGROVE_LOG_BREAKING_STAGE_1 = block(MessinaroundModBlocks.STRIPPED_MANGROVE_LOG_BREAKING_STAGE_1);
		STRIPPED_MANGROVE_LOG_BREAKING_STAGE_2 = block(MessinaroundModBlocks.STRIPPED_MANGROVE_LOG_BREAKING_STAGE_2);
		STRIPPED_MANGROVE_LOG_BREAKING_STAGE_3 = block(MessinaroundModBlocks.STRIPPED_MANGROVE_LOG_BREAKING_STAGE_3);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}