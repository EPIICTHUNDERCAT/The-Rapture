package com.github.epiicthundercat.client.render;

import com.github.epiicthundercat.Reference;
import com.github.epiicthundercat.client.model.ModelDemon;
import com.github.epiicthundercat.entity.monster.EntityDemon;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderDemon extends RenderLiving<EntityDemon>
{
    private static final ResourceLocation DEMON_TEXTURES = new ResourceLocation(Reference.ID, "textures/entity/demon.png");

    public RenderDemon(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelDemon(), 0.5F);
       // this.addLayer(new LayerHeldItem(this));
        
    }

  
	@Override
	protected ResourceLocation getEntityTexture(EntityDemon entity) {
		// TODO Auto-generated method stub
		 return DEMON_TEXTURES;
	}

}