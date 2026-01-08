package net.mcreator.messinaround.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class GrimstoneBlock extends Block {
	public GrimstoneBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHER_BRICKS).strength(6f, 8f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}