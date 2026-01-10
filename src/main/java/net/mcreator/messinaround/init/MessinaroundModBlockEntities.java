/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.messinaround.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.messinaround.block.entity.UnlitCampfireBlockEntity;
import net.mcreator.messinaround.block.entity.UnfiredCuckBlockEntity;
import net.mcreator.messinaround.block.entity.LitCampfire1BlockEntity;
import net.mcreator.messinaround.block.entity.LitCampfire0BlockEntity;
import net.mcreator.messinaround.block.entity.ExperimentalSteakCookerBlockEntity;
import net.mcreator.messinaround.MessinaroundMod;

@EventBusSubscriber
public class MessinaroundModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MessinaroundMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ExperimentalSteakCookerBlockEntity>> EXPERIMENTAL_STEAK_COOKER = register("experimental_steak_cooker", MessinaroundModBlocks.EXPERIMENTAL_STEAK_COOKER,
			ExperimentalSteakCookerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UnlitCampfireBlockEntity>> UNLIT_CAMPFIRE = register("unlit_campfire", MessinaroundModBlocks.UNLIT_CAMPFIRE, UnlitCampfireBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LitCampfire0BlockEntity>> LIT_CAMPFIRE_0 = register("lit_campfire_0", MessinaroundModBlocks.LIT_CAMPFIRE_0, LitCampfire0BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LitCampfire1BlockEntity>> LIT_CAMPFIRE_1 = register("lit_campfire_1", MessinaroundModBlocks.LIT_CAMPFIRE_1, LitCampfire1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UnfiredCuckBlockEntity>> UNFIRED_CUCK = register("unfired_cuck", MessinaroundModBlocks.UNFIRED_CUCK, UnfiredCuckBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EXPERIMENTAL_STEAK_COOKER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UNLIT_CAMPFIRE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LIT_CAMPFIRE_0.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LIT_CAMPFIRE_1.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UNFIRED_CUCK.get(), SidedInvWrapper::new);
	}
}