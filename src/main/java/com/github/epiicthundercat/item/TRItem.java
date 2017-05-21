package com.github.epiicthundercat.item;

import com.github.epiicthundercat.creativetabs.TRCreativeTab;
import com.github.epiicthundercat.init.TRItems;

import net.minecraft.item.Item;

public class TRItem extends Item {
	
	
	public TRItem(String name) {
		
		setRegistryName(name.toLowerCase());
		setUnlocalizedName(name.toLowerCase());
		setCreativeTab(TRCreativeTab.RTabs);
		addToItems(this);
	}

	private void addToItems(Item item) {

		TRItems.items.add(item);

	}
}