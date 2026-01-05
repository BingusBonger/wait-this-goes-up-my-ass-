package net.mcreator.messinaround.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerDebuffsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		boolean hungerDebuffed = false;
		boolean superHungerDebuffed = false;
		if (entity instanceof LivingEntity _entity) {
			AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("messinaround:mine_slower"), (-0.7), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
			if (!_entity.getAttribute(Attributes.BLOCK_BREAK_SPEED).hasModifier(modifier.id())) {
				_entity.getAttribute(Attributes.BLOCK_BREAK_SPEED).addPermanentModifier(modifier);
			}
		}
		if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 10) {
			hungerDebuffed = true;
		}
		if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 5) {
			superHungerDebuffed = true;
		}
		if (hungerDebuffed) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("messinaround:hunger_debuff_speed"), (-0.2), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
				if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("messinaround:hunger_debuff_swim"), (-0.3), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
				if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
					_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("messinaround:hunger_debuff_speed"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(NeoForgeMod.SWIM_SPEED).removeModifier(ResourceLocation.parse("messinaround:hunger_debuff_swim"));
			}
		}
		if (superHungerDebuffed) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("messinaround:superhunger_debuff_speed"), (-0.3), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
				if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("messinaround:superhunger_debuff_swim"), (-0.45), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
				if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
					_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("messinaround:superhunger_debuff_mine"), (-0.1), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
				if (!_entity.getAttribute(Attributes.BLOCK_BREAK_SPEED).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.BLOCK_BREAK_SPEED).addPermanentModifier(modifier);
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("messinaround:superhunger_debuff_speed"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(NeoForgeMod.SWIM_SPEED).removeModifier(ResourceLocation.parse("messinaround:superhunger_debuff_swim"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.BLOCK_BREAK_SPEED).removeModifier(ResourceLocation.parse("messinaround:superhunger_debuff_mine"));
			}
		}
		if (hungerDebuffed) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("messinaround:hunger_debuff_reach_block"), (-0.2), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
				if (!_entity.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).addPermanentModifier(modifier);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("messinaround:hunger_debuff_reach_entity"), (-0.2), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
				if (!_entity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).addPermanentModifier(modifier);
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).removeModifier(ResourceLocation.parse("messinaround:hunger_debuff_reach_block"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).removeModifier(ResourceLocation.parse("messinaround:hunger_debuff_reach_entity"));
			}
		}
	}
}