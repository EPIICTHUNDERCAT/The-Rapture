package com.github.epiicthundercat.init;

import java.util.ArrayList;
import java.util.List;

import com.github.epiicthundercat.item.ImageTest;
import com.github.epiicthundercat.item.ItemDemonHeart;
import com.github.epiicthundercat.item.TRItemSword;
import com.github.epiicthundercat.item.zelda.ZeldaHeartCapsule;
import com.github.epiicthundercat.item.zelda.ZeldaStaminaCapsule;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class TRItems {

	public static List<Item> items = new ArrayList();

	public static Item unholy_sword = new TRItemSword("unholy_sword", ToolMaterial.DIAMOND);
	public static Item demon_staff = new TRItemSword("demon_staff", ToolMaterial.DIAMOND);

	public static Item demon_heart = new ItemDemonHeart("demon_heart");
	public static Item stamina_vessel = new ZeldaStaminaCapsule("stamina_vessel");
	public static Item heart_vessel = new ZeldaHeartCapsule("heart_vessel");
	public static Item bad = new ImageTest("bad");

	
	
	private static List<Item> getItems() {
		return items;

	}

	public static void register(FMLPreInitializationEvent preEvent) {
		for (Item item : getItems()) {
			if (item != null) {
				ForgeRegistries.ITEMS.register(item);
			}
		}
	}

	public static void registerRender(FMLInitializationEvent event) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		for (Item item : getItems()) {
			renderItem.getItemModelMesher().register(item, 0,
					new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
		}
	}
}
