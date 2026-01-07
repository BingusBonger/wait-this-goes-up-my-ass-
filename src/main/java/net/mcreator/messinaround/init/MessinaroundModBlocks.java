/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.messinaround.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.messinaround.block.*;
import net.mcreator.messinaround.MessinaroundMod;

import java.util.function.Function;

public class MessinaroundModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MessinaroundMod.MODID);
	public static final DeferredBlock<Block> LOOSE_DIRT_SLAB;
	public static final DeferredBlock<Block> LOOSE_DIRT_BLOCK;
	public static final DeferredBlock<Block> AXLE;
	public static final DeferredBlock<Block> AXLE_POWERED;
	public static final DeferredBlock<Block> GENERATOR;
	public static final DeferredBlock<Block> BREAKING_STAGE_1;
	public static final DeferredBlock<Block> BREAKING_STAGE_2;
	public static final DeferredBlock<Block> BREAKING_STAGE_3;
	public static final DeferredBlock<Block> BREAKING_STAGE_4;
	public static final DeferredBlock<Block> BREAKING_STAGE_5;
	public static final DeferredBlock<Block> BREAKING_STAGE_6;
	public static final DeferredBlock<Block> BREAKING_STAGE_7;
	public static final DeferredBlock<Block> STRIPPED_OAK_LOG_BREAKING_STAGE_1;
	public static final DeferredBlock<Block> STRIPPED_OAK_LOG_BREAKING_STAGE_2;
	public static final DeferredBlock<Block> STRIPPED_OAK_LOG_BREAKING_STAGE_3;
	public static final DeferredBlock<Block> STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_1;
	public static final DeferredBlock<Block> STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_2;
	public static final DeferredBlock<Block> STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_3;
	public static final DeferredBlock<Block> STRIPPED_BIRCH_LOG_BREAKING_STAGE_1;
	public static final DeferredBlock<Block> STRIPPED_BIRCH_LOG_BREAKING_STAGE_2;
	public static final DeferredBlock<Block> STRIPPED_BIRCH_LOG_BREAKING_STAGE_3;
	public static final DeferredBlock<Block> STRIPPED_ACACIA_LOG_BREAKING_STAGE_1;
	public static final DeferredBlock<Block> STRIPPED_ACACIA_LOG_BREAKING_STAGE_2;
	public static final DeferredBlock<Block> STRIPPED_ACACIA_LOG_BREAKING_STAGE_3;
	public static final DeferredBlock<Block> STRIPPED_CHERRY_LOG_BREAKING_STAGE_1;
	public static final DeferredBlock<Block> STRIPPED_CHERRY_LOG_BREAKING_STAGE_2;
	public static final DeferredBlock<Block> STRIPPED_CHERRY_LOG_BREAKING_STAGE_3;
	public static final DeferredBlock<Block> STRIPPED_JUNGLE_LOG_BREAKING_STAGE_1;
	public static final DeferredBlock<Block> STRIPPED_JUNGLE_LOG_BREAKING_STAGE_2;
	public static final DeferredBlock<Block> STRIPPED_JUNGLE_LOG_BREAKING_STAGE_3;
	public static final DeferredBlock<Block> STRIPPED_SPRUCE_LOG_BREAKING_STAGE_1;
	public static final DeferredBlock<Block> STRIPPED_SPRUCE_LOG_BREAKING_STAGE_2;
	public static final DeferredBlock<Block> STRIPPED_SPRUCE_LOG_BREAKING_STAGE_3;
	public static final DeferredBlock<Block> STRIPPED_MANGROVE_LOG_BREAKING_STAGE_1;
	public static final DeferredBlock<Block> STRIPPED_MANGROVE_LOG_BREAKING_STAGE_2;
	public static final DeferredBlock<Block> STRIPPED_MANGROVE_LOG_BREAKING_STAGE_3;
	public static final DeferredBlock<Block> COOCIBLE;
	public static final DeferredBlock<Block> EXPERIMENTAL_STEAK_COOKER;
	public static final DeferredBlock<Block> OPEN_CUCK;
	public static final DeferredBlock<Block> BREAKING_STAGE_8;
	static {
		LOOSE_DIRT_SLAB = register("loose_dirt_slab", LooseDirtSlabBlock::new);
		LOOSE_DIRT_BLOCK = register("loose_dirt_block", LooseDirtBlockBlock::new);
		AXLE = register("axle", AxleBlock::new);
		AXLE_POWERED = register("axle_powered", AxlePoweredBlock::new);
		GENERATOR = register("generator", GeneratorBlock::new);
		BREAKING_STAGE_1 = register("breaking_stage_1", BreakingStage1Block::new);
		BREAKING_STAGE_2 = register("breaking_stage_2", BreakingStage2Block::new);
		BREAKING_STAGE_3 = register("breaking_stage_3", BreakingStage3Block::new);
		BREAKING_STAGE_4 = register("breaking_stage_4", BreakingStage4Block::new);
		BREAKING_STAGE_5 = register("breaking_stage_5", BreakingStage5Block::new);
		BREAKING_STAGE_6 = register("breaking_stage_6", BreakingStage6Block::new);
		BREAKING_STAGE_7 = register("breaking_stage_7", BreakingStage7Block::new);
		STRIPPED_OAK_LOG_BREAKING_STAGE_1 = register("stripped_oak_log_breaking_stage_1", StrippedOakLogBreakingStage1Block::new);
		STRIPPED_OAK_LOG_BREAKING_STAGE_2 = register("stripped_oak_log_breaking_stage_2", StrippedOakLogBreakingStage2Block::new);
		STRIPPED_OAK_LOG_BREAKING_STAGE_3 = register("stripped_oak_log_breaking_stage_3", StrippedOakLogBreakingStage3Block::new);
		STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_1 = register("stripped_dark_oak_log_breaking_stage_1", StrippedDarkOakLogBreakingStage1Block::new);
		STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_2 = register("stripped_dark_oak_log_breaking_stage_2", StrippedDarkOakLogBreakingStage2Block::new);
		STRIPPED_DARK_OAK_LOG_BREAKING_STAGE_3 = register("stripped_dark_oak_log_breaking_stage_3", StrippedDarkOakLogBreakingStage3Block::new);
		STRIPPED_BIRCH_LOG_BREAKING_STAGE_1 = register("stripped_birch_log_breaking_stage_1", StrippedBirchLogBreakingStage1Block::new);
		STRIPPED_BIRCH_LOG_BREAKING_STAGE_2 = register("stripped_birch_log_breaking_stage_2", StrippedBirchLogBreakingStage2Block::new);
		STRIPPED_BIRCH_LOG_BREAKING_STAGE_3 = register("stripped_birch_log_breaking_stage_3", StrippedBirchLogBreakingStage3Block::new);
		STRIPPED_ACACIA_LOG_BREAKING_STAGE_1 = register("stripped_acacia_log_breaking_stage_1", StrippedAcaciaLogBreakingStage1Block::new);
		STRIPPED_ACACIA_LOG_BREAKING_STAGE_2 = register("stripped_acacia_log_breaking_stage_2", StrippedAcaciaLogBreakingStage2Block::new);
		STRIPPED_ACACIA_LOG_BREAKING_STAGE_3 = register("stripped_acacia_log_breaking_stage_3", StrippedAcaciaLogBreakingStage3Block::new);
		STRIPPED_CHERRY_LOG_BREAKING_STAGE_1 = register("stripped_cherry_log_breaking_stage_1", StrippedCherryLogBreakingStage1Block::new);
		STRIPPED_CHERRY_LOG_BREAKING_STAGE_2 = register("stripped_cherry_log_breaking_stage_2", StrippedCherryLogBreakingStage2Block::new);
		STRIPPED_CHERRY_LOG_BREAKING_STAGE_3 = register("stripped_cherry_log_breaking_stage_3", StrippedCherryLogBreakingStage3Block::new);
		STRIPPED_JUNGLE_LOG_BREAKING_STAGE_1 = register("stripped_jungle_log_breaking_stage_1", StrippedJungleLogBreakingStage1Block::new);
		STRIPPED_JUNGLE_LOG_BREAKING_STAGE_2 = register("stripped_jungle_log_breaking_stage_2", StrippedJungleLogBreakingStage2Block::new);
		STRIPPED_JUNGLE_LOG_BREAKING_STAGE_3 = register("stripped_jungle_log_breaking_stage_3", StrippedJungleLogBreakingStage3Block::new);
		STRIPPED_SPRUCE_LOG_BREAKING_STAGE_1 = register("stripped_spruce_log_breaking_stage_1", StrippedSpruceLogBreakingStage1Block::new);
		STRIPPED_SPRUCE_LOG_BREAKING_STAGE_2 = register("stripped_spruce_log_breaking_stage_2", StrippedSpruceLogBreakingStage2Block::new);
		STRIPPED_SPRUCE_LOG_BREAKING_STAGE_3 = register("stripped_spruce_log_breaking_stage_3", StrippedSpruceLogBreakingStage3Block::new);
		STRIPPED_MANGROVE_LOG_BREAKING_STAGE_1 = register("stripped_mangrove_log_breaking_stage_1", StrippedMangroveLogBreakingStage1Block::new);
		STRIPPED_MANGROVE_LOG_BREAKING_STAGE_2 = register("stripped_mangrove_log_breaking_stage_2", StrippedMangroveLogBreakingStage2Block::new);
		STRIPPED_MANGROVE_LOG_BREAKING_STAGE_3 = register("stripped_mangrove_log_breaking_stage_3", StrippedMangroveLogBreakingStage3Block::new);
		COOCIBLE = register("coocible", CoocibleBlock::new);
		EXPERIMENTAL_STEAK_COOKER = register("experimental_steak_cooker", ExperimentalSteakCookerBlock::new);
		OPEN_CUCK = register("open_cuck", OpenCuckBlock::new);
		BREAKING_STAGE_8 = register("breaking_stage_8", BreakingStage8Block::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}