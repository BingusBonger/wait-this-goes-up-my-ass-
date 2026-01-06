package net.mcreator.messinaround.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class BreakingStage4Block extends Block {
	public BreakingStage4Block(BlockBehaviour.Properties properties) {
		super(properties.strength(3f, 10f).pushReaction(PushReaction.IGNORE));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}