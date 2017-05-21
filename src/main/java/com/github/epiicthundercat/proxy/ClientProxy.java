package com.github.epiicthundercat.proxy;

import com.github.epiicthundercat.client.render.RenderFallenAngel;
import com.github.epiicthundercat.entity.ModEntities;
import com.github.epiicthundercat.entity.monster.EntityFallenAngel;
import com.github.epiicthundercat.init.TRItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	private static final Minecraft MC = Minecraft.getMinecraft();
	public void preInit(FMLPreInitializationEvent preEvent) {
		super.preInit(preEvent);
		ModEntities.init();
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);

		RenderManager rm = Minecraft.getMinecraft().getRenderManager();
		rm.entityRenderMap.put(EntityFallenAngel.class, new RenderFallenAngel(rm));
		
	}
	@Override
	public void registerRenders(FMLInitializationEvent event) {
		TRItems.registerRender(event);
		// SBlocks.registerRender(event);
	}
	
	@Override
	public void registerEntities(FMLPreInitializationEvent preEvent) {
		super.registerEntities(preEvent);
	}
	
	
	
	public static void playSound(ISound sound) {
		MC.getSoundHandler().playSound(sound);
	}

	
	
	public static void stopSound(ISound sound) {
		MC.getSoundHandler().stopSound(sound);
	}

}
