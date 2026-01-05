package net.mcreator.messinaround.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BlinginMyBongBlock extends Block {
	public BlinginMyBongBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GRAVEL).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}