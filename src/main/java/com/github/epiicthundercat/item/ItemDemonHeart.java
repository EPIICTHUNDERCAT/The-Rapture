package com.github.epiicthundercat.item;

import com.github.epiicthundercat.utils.Particle;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemDemonHeart  extends TRItem{

	public ItemDemonHeart(String name) {
		super(name);
	}

	
	  public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
		  
		   if (playerIn instanceof EntityPlayer ) {
			  if (playerIn.getHeldItemMainhand() !=null) {
				  for (int x = 10; x <= 10; x++)
					  MathHelper.clamp(1, 10, x);
				  Particle.spawnParticles(worldIn, EnumParticleTypes.REDSTONE, playerIn.posX, playerIn.posY, playerIn.posX, 10, 0, 0, 0, 1, 10);
			  }
		   }
	        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	    }
}
