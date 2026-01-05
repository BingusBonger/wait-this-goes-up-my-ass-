package net.mcreator.messinaround.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.procedures.LooseDirtSlabMergeProcedure;

import com.mojang.serialization.MapCodec;

public class LooseDirtBlockBlock extends FallingBlock {
	public static final MapCodec<LooseDirtBlockBlock> CODEC = simpleCodec(LooseDirtBlockBlock::new);

	@Override
	public MapCodec<LooseDirtBlockBlock> codec() {
		return CODEC;
	}

	@Override
	public int getDustColor(BlockState blockstate, BlockGetter world, BlockPos pos) {
		return blockstate.getMapColor(world, pos).col;
	}

	public LooseDirtBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GRAVEL).strength(0.3f, 2f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		LooseDirtSlabMergeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}