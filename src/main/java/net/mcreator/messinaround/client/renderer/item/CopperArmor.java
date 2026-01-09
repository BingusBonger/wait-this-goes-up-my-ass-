package net.mcreator.messinaround.client.renderer.item;

import net.minecraft.client.model.Model;

@EventBusSubscriber(Dist.CLIENT)
public class CopperArmor {

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("messinaround:textures/models/armor/copper_layer_1.png");
			}
		}, MessinaroundModItems.COPPER_HELMET.get());

		event.registerItem(new IClientItemExtensions() {

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("messinaround:textures/models/armor/copper_layer_1.png");
			}
		}, MessinaroundModItems.COPPER_CHESTPLATE.get());

		event.registerItem(new IClientItemExtensions() {

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("messinaround:textures/models/armor/copper_layer_2.png");
			}
		}, MessinaroundModItems.COPPER_LEGGINGS.get());

		event.registerItem(new IClientItemExtensions() {

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("messinaround:textures/models/armor/copper_layer_1.png");
			}
		}, MessinaroundModItems.COPPER_BOOTS.get());
	}

}