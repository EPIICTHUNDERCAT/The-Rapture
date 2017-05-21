package com.github.epiicthundercat.client.render;

import com.github.epiicthundercat.Reference;
import com.github.epiicthundercat.client.model.ModelFallenAngel;
import com.github.epiicthundercat.entity.monster.EntityFallenAngel;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFallenAngel extends RenderLiving<EntityFallenAngel>
{
    private static final ResourceLocation ANGEL_TEXTURES = new ResourceLocation(Reference.ID, "textures/entity/fallen_angel.png");

    public RenderFallenAngel(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelFallenAngel(), 0.5F);
        
    }

  
	@Override
	protected ResourceLocation getEntityTexture(EntityFallenAngel entity) {
		// TODO Auto-generated method stub
		 return ANGEL_TEXTURES;
	}

}