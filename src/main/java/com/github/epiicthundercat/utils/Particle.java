package com.github.epiicthundercat.utils;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class Particle {
	 public static void spawnParticles(World world, EnumParticleTypes particle, double xCoord, double yCoord, double zCoord, int amount, double xOffset, double yOffset, double zOffset, double speed, int... parameters) {
	        if(world instanceof WorldServer) {
	            ((WorldServer) world).spawnParticle(particle, particle.getShouldIgnoreRange(), xCoord, yCoord, zCoord, amount, world.rand.nextDouble() * 0.2D, world.rand.nextDouble() * 0.7D, world.rand.nextDouble() * 0.2D, speed, parameters);
	    	}
	    }
}
