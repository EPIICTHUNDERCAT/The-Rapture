/**
 * 
 */
package com.github.epiicthundercat.item.zelda;

import com.github.epiicthundercat.init.TheRaptureSoundHandler;
import com.github.epiicthundercat.item.TRItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * @author rvill
 *
 */
public class ZeldaStaminaCapsule extends TRItem{

	public ZeldaStaminaCapsule(String name) {
		super(name);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
if (playerIn.getActiveHand().MAIN_HAND == null) {
	return null;
}else if (playerIn.getActiveHand().MAIN_HAND !=null) {
	playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1600, 10));
	playerIn.playSound(TheRaptureSoundHandler.THE_RAPTURE_HAS_BEGUN, 10, 10);
	ItemStack stack = new ItemStack(this);
	
	stack.shrink(1);
}
		
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	

}
