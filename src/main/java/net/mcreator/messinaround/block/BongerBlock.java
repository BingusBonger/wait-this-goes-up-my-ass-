package net.mcreator.messinaround.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BongerBlock extends StairBlock {
	public BongerBlock(BlockBehaviour.Properties properties) {
		super(Blocks.AIR.defaultBlockState(), properties.sound(SoundType.GRAVEL).strength(1f, 10f));
	}

	@Override
	public float getExplosionResistance() {
		return 10f;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}