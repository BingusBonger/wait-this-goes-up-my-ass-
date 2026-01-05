package net.mcreator.messinaround.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class GeneratorBlock extends Block {
	public GeneratorBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.LADDER).strength(1f, 10f).pushReaction(PushReaction.DESTROY).ignitedByLava());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 4;
	}

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return true;
	}
}