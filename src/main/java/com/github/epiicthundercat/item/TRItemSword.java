package com.github.epiicthundercat.item;

import com.github.epiicthundercat.creativetabs.TRCreativeTab;
import com.github.epiicthundercat.init.TRItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;

public class TRItemSword extends ItemSword {
	public TRItemSword(String name, ToolMaterial material) {
		super(material);
		setRegistryName(name.toLowerCase());
		setUnlocalizedName(name.toLowerCase());
		setCreativeTab(TRCreativeTab.RTabs);
		addToItems(this);
	}

	private void addToItems(Item item) {

		TRItems.items.add(item);

	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(1, attacker);
		if (target instanceof EntityLivingBase) {
			if (stack.getItem() == TRItems.unholy_sword) {
				((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.WITHER, 200, 2, false, true));
			}

		}
		return true;
	}

	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		if (toRepair.getItem() == TRItems.unholy_sword) {
			return repair.getItem() == Items.NETHER_STAR;
		}

		return false;
	}
}
