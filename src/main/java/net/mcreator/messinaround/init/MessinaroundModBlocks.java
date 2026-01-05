/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.messinaround.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.messinaround.block.LooseDirtSlabBlock;
import net.mcreator.messinaround.block.LooseDirtBlockBlock;
import net.mcreator.messinaround.block.AxleBlock;
import net.mcreator.messinaround.MessinaroundMod;

import java.util.function.Function;

public class MessinaroundModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MessinaroundMod.MODID);
	public static final DeferredBlock<Block> LOOSE_DIRT_SLAB;
	public static final DeferredBlock<Block> LOOSE_DIRT_BLOCK;
	public static final DeferredBlock<Block> AXLE;
	static {
		LOOSE_DIRT_SLAB = register("loose_dirt_slab", LooseDirtSlabBlock::new);
		LOOSE_DIRT_BLOCK = register("loose_dirt_block", LooseDirtBlockBlock::new);
		AXLE = register("axle", AxleBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}