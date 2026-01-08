package net.mcreator.messinaround.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CobbledGrimstoneBlock extends Block {
	public CobbledGrimstoneBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.BASALT).strength(7f, 9f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}