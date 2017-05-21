package com.github.epiicthundercat.init;

import com.github.epiicthundercat.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TheRaptureSoundHandler {
	public static final SoundEvent FALLEN_ANGEL_HURT = create("fallen_angel_hurt");
	public static final SoundEvent FALLEN_ANGEL_AMBIENT = create("fallen_angel_ambient");
	public static final SoundEvent FALLEN_ANGEL_DEATH = create("fallen_angel_death");
	
	
	
	public static SoundEvent create(String name) {
        ResourceLocation resource = new ResourceLocation(Reference.ID, name);
        SoundEvent event = new SoundEvent(resource);
        GameRegistry.register(event, resource);
        return event;
    }
}
