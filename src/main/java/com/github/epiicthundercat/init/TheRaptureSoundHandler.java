package com.github.epiicthundercat.init;

import com.github.epiicthundercat.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public enum TheRaptureSoundHandler {
	INSTANCE;
	public static final SoundEvent FALLEN_ANGEL_HURT = registerSound("fallen_angel_hurt", Reference.ID);
	public static final SoundEvent FALLEN_ANGEL_AMBIENT = registerSound("fallen_angel_ambient", Reference.ID);
	public static final SoundEvent FALLEN_ANGEL_DEATH = registerSound("fallen_angel_death", Reference.ID);
	public static final SoundEvent THE_RAPTURE_HAS_BEGUN = registerSound("the_rapture_has_begun", Reference.ID);

	public void onInit() {
	}

	public static SoundEvent registerSound(String name, String modid) {
		ResourceLocation location = new ResourceLocation(modid, name);
		final SoundEvent event = new SoundEvent(location).setRegistryName(location);
		GameRegistry.findRegistry(SoundEvent.class).register(event);
		return event;

	}
}