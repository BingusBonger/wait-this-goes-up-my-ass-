package net.mcreator.messinaround.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class GrimstoneGoldOreBlock extends Block {
	public GrimstoneGoldOreBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.ANCIENT_DEBRIS).strength(9f, 4f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BELL));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}