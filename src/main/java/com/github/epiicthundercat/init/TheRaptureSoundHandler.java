package com.github.epiicthundercat.init;

import com.github.epiicthundercat.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public enum TheRaptureSoundHandler {
	  INSTANCE;
	public static final SoundEvent FALLEN_ANGEL_HURT = create("fallen_angel_hurt");
	public static final SoundEvent FALLEN_ANGEL_AMBIENT = create("fallen_angel_ambient");
	public static final SoundEvent FALLEN_ANGEL_DEATH = create("fallen_angel_death");
	public static final SoundEvent THE_RAPTURE_HAS_BEGUN = create("the_rapture_has_begun");
	
	
	 public void onInit() {}
	
	public static SoundEvent create(String name) {
		ResourceLocation id = new ResourceLocation(Reference.ID, name);
        return GameRegistry.register(new SoundEvent(id).setRegistryName(id));
    }
}
