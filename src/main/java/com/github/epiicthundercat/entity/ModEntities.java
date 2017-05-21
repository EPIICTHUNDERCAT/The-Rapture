package com.github.epiicthundercat.entity;

import com.github.epiicthundercat.TheRapture;
import com.github.epiicthundercat.entity.monster.EntityFallenAngel;

import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

	public static void init() {
		EntityRegistry.registerModEntity(getEntityResource("FallenAngel"), EntityFallenAngel.class, "FallenAngel", 0, TheRapture.instance, 80, 3, false,
				0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityFallenAngel.class, 2, 4, 8, EnumCreatureType.CREATURE, Biomes.SKY);

		EntitySpawnPlacementRegistry.setPlacementType(EntityFallenAngel.class, SpawnPlacementType.ON_GROUND);

	}
	private static ResourceLocation getEntityResource(String entityName)
	  {
	    return new ResourceLocation("therapture", entityName);
	  }
	  
}
