package net.mcreator.messinaround.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.messinaround.procedures.LooseDirtSlabMergeProcedure;
import net.mcreator.messinaround.procedures.LooseDirtBlockFallProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class LooseDirtSlabBlock extends FallingBlock {
	public static final MapCodec<LooseDirtSlabBlock> CODEC = simpleCodec(LooseDirtSlabBlock::new);

	@Override
	public MapCodec<LooseDirtSlabBlock> codec() {
		return CODEC;
	}

	@Override
	public int getDustColor(BlockState blockstate, BlockGetter world, BlockPos pos) {
		return blockstate.getMapColor(world, pos).col;
	}

	public LooseDirtSlabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GRAVEL).strength(0.3f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return box(0, 0, 0, 16, 8, 16);
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		LooseDirtSlabMergeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
		LooseDirtSlabMergeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void fallOn(Level world, BlockState blockstate, BlockPos pos, Entity entity, double distance) {
		super.fallOn(world, blockstate, pos, entity, distance);
		LooseDirtBlockFallProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}