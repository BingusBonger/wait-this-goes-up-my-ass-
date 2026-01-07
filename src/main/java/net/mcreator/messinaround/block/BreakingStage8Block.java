package net.mcreator.messinaround.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BreakingStage8Block extends Block {
	public BreakingStage8Block(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.BASALT).strength(8f, 10f).pushReaction(PushReaction.IGNORE));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}