package com.github.epiicthundercat.creativetabs;

import com.github.epiicthundercat.init.TRItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TRCreativeTab extends CreativeTabs{
	public TRCreativeTab(int index, String label) {
		super(index, label);
	}

	public static final TRCreativeTab RTabs = new TRCreativeTab(CreativeTabs.getNextID(), "rtabs") {
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(TRItems.unholy_sword);
		}
	};
	
	@Override
	public ItemStack getTabIconItem() {
		return null;
	}
}