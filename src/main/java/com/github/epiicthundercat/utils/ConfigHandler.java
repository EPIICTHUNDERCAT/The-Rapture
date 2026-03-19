package com.github.epiicthundercat.utils;

import com.github.epiicthundercat.Reference;

import net.minecraftforge.common.config.Config;

@Config(modid = Reference.ID, category = "options")
@Config.LangKey(Reference.ID + ".config.title")

public class ConfigHandler {

	@Config.Comment("Amount of MAX possible spawns when the Angel is under 0.5 health! CAUTION, THIS COULD HURT YOU! [Default: 1]")
	public static int maxAngelSpawns = 1;

	@Config.Comment("Amount of MIN possible spawns when the Angel is under 0.5 health! Possible dangers, BE WARNED. [Default: 0]")
	public static int minAngelSpawns = 0;

	@Config.Comment("Radious Angels Can Spawn when under 0.5 health [Default: 3]")
	public static int radiousAngelsCanSpawn = 3;

	@Config.Comment("During the Night, does the Angel Ignore Light to spawn in MORE angels? [Default: false]")
	public static boolean spawnIgnoresLight = false;

	@Config.Comment("The health the angel has to be at in order to summon more of himself (WARNING: MAKING THIS HIGH CAN BREAK YOUR WORLD, THEY MULTIPLY VERY VERY QUICKLY!!) [Default: false]")
	public static float healthAngelSpawning = 0.5f;

}
