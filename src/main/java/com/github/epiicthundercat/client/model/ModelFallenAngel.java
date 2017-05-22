package com.github.epiicthundercat.client.model;

import com.github.epiicthundercat.entity.monster.EntityFallenAngel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelFallenAngel extends ModelBase {
	public ModelRenderer body;
	public ModelRenderer head;
	public ModelRenderer rightFoot;
	public ModelRenderer rightArm;
	public ModelRenderer leftArm;
	public ModelRenderer leftFoot;
	public ModelRenderer wingBoneBase;
	public ModelRenderer wingBoneBase_1;
	public ModelRenderer wingBoneSecond;
	public ModelRenderer wingFlap;
	public ModelRenderer wingBoneThird;
	public ModelRenderer wingFlap2;
	public ModelRenderer wingFlap3;
	public ModelRenderer wingBoneSecond_1;
	public ModelRenderer wingFlap_1;
	public ModelRenderer wingBoneThird_1;
	public ModelRenderer wingFlap2_1;
	public ModelRenderer wingFlap3_1;

	public ModelFallenAngel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.leftFoot = new ModelRenderer(this, 0, 48);
		this.leftFoot.mirror = true;
		this.leftFoot.setRotationPoint(1.9F, 12.0F, 0.1F);
		this.leftFoot.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.wingFlap = new ModelRenderer(this, 34, 20);
		this.wingFlap.setRotationPoint(7.0F, 0.6F, 1.0F);
		this.wingFlap.addBox(-7.0F, 0.0F, 0.0F, 15, 9, 0, 0.0F);
		this.wingBoneThird = new ModelRenderer(this, 0, 0);
		this.wingBoneThird.setRotationPoint(14.3F, 0.0F, 0.0F);
		this.wingBoneThird.addBox(0.0F, -1.0F, -1.0F, 9, 2, 2, 0.0F);
		this.setRotateAngle(wingBoneThird, 0.0F, 1.0471975511965976F, -0.091106186954104F);
		this.body = new ModelRenderer(this, 3, 31);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		this.wingFlap2_1 = new ModelRenderer(this, 34, 10);
		this.wingFlap2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingFlap2_1.addBox(-15.0F, 0.0F, 0.0F, 15, 10, 0, 0.0F);
		this.setRotateAngle(wingFlap2_1, -0.045553093477052F, 0.0F, 0.0F);
		this.wingBoneBase_1 = new ModelRenderer(this, 30, 32);
		this.wingBoneBase_1.mirror = true;
		this.wingBoneBase_1.setRotationPoint(-2.0F, 0.8F, 2.0F);
		this.wingBoneBase_1.addBox(-15.0F, 0.0F, 0.0F, 15, 2, 2, 0.0F);
		this.setRotateAngle(wingBoneBase_1, 0.136659280431156F, 0.36425021489121656F, 0.5009094953223726F);
		this.wingBoneSecond_1 = new ModelRenderer(this, 31, 38);
		this.wingBoneSecond_1.setRotationPoint(-14.7F, 1.1F, 1.0F);
		this.wingBoneSecond_1.addBox(-15.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
		this.setRotateAngle(wingBoneSecond_1, 0.0F, -1.0927506446736497F, 0.0F);
		this.wingBoneBase = new ModelRenderer(this, 30, 32);
		this.wingBoneBase.setRotationPoint(1.1F, 2.1F, 0.4F);
		this.wingBoneBase.addBox(0.0F, -1.0F, 0.0F, 15, 2, 2, 0.0F);
		this.setRotateAngle(wingBoneBase, 0.27314402793711257F, -0.5009094953223726F, -0.5462880558742251F);
		this.leftArm = new ModelRenderer(this, 16, 48);
		this.leftArm.setRotationPoint(5.0F, 2.5F, -0.0F);
		this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
		this.setRotateAngle(leftArm, 0.0F, 0.0F, -0.10000736613927509F);
		this.wingFlap2 = new ModelRenderer(this, 34, 10);
		this.wingFlap2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingFlap2.addBox(0.0F, 0.0F, 0.0F, 15, 10, 0, 0.0F);
		this.wingFlap3 = new ModelRenderer(this, 46, 0);
		this.wingFlap3.mirror = true;
		this.wingFlap3.setRotationPoint(-0.1F, 0.0F, 0.0F);
		this.wingFlap3.addBox(0.0F, 0.0F, 0.0F, 9, 10, 0, 0.0F);
		this.wingBoneSecond = new ModelRenderer(this, 31, 38);
		this.wingBoneSecond.mirror = true;
		this.wingBoneSecond.setRotationPoint(14.3F, 0.0F, 0.7F);
		this.wingBoneSecond.addBox(0.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
		this.setRotateAngle(wingBoneSecond, 0.0F, 0.9105382707654417F, 0.0F);
		this.wingFlap_1 = new ModelRenderer(this, 34, 20);
		this.wingFlap_1.mirror = true;
		this.wingFlap_1.setRotationPoint(-8.0F, 0.6F, 1.0F);
		this.wingFlap_1.addBox(-7.0F, 0.0F, 0.0F, 15, 9, 0, 0.0F);
		this.rightFoot = new ModelRenderer(this, 0, 48);
		this.rightFoot.setRotationPoint(-1.9F, 12.0F, 0.1F);
		this.rightFoot.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.wingBoneThird_1 = new ModelRenderer(this, 0, 0);
		this.wingBoneThird_1.mirror = true;
		this.wingBoneThird_1.setRotationPoint(-15.7F, 0.0F, 0.0F);
		this.wingBoneThird_1.addBox(-8.0F, -1.0F, -1.0F, 9, 2, 2, 0.0F);
		this.setRotateAngle(wingBoneThird_1, 0.0F, -0.8196066167365371F, 0.0F);
		this.head = new ModelRenderer(this, 0, 14);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.wingFlap3_1 = new ModelRenderer(this, 46, 0);
		this.wingFlap3_1.setRotationPoint(-0.1F, 0.0F, 0.0F);
		this.wingFlap3_1.addBox(-8.0F, 0.0F, 0.0F, 9, 10, 0, 0.0F);
		this.rightArm = new ModelRenderer(this, 16, 48);
		this.rightArm.mirror = true;
		this.rightArm.setRotationPoint(-5.0F, 2.5F, 0.0F);
		this.rightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
		this.setRotateAngle(rightArm, 0.0F, 0.0F, 0.10000736613927509F);
		this.body.addChild(this.leftFoot);
		this.wingBoneBase.addChild(this.wingFlap);
		this.wingBoneSecond.addChild(this.wingBoneThird);
		this.wingBoneSecond_1.addChild(this.wingFlap2_1);
		this.body.addChild(this.wingBoneBase_1);
		this.wingBoneBase_1.addChild(this.wingBoneSecond_1);
		this.body.addChild(this.wingBoneBase);
		this.body.addChild(this.leftArm);
		this.wingBoneSecond.addChild(this.wingFlap2);
		this.wingBoneThird.addChild(this.wingFlap3);
		this.wingBoneBase.addChild(this.wingBoneSecond);
		this.wingBoneBase_1.addChild(this.wingFlap_1);
		this.body.addChild(this.rightFoot);
		this.wingBoneSecond_1.addChild(this.wingBoneThird_1);
		this.body.addChild(this.head);
		this.wingBoneThird_1.addChild(this.wingFlap3_1);
		this.body.addChild(this.rightArm);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.body.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		EntityFallenAngel angel = (EntityFallenAngel) entity;
		// f = entity.ticksExisted;
		// f1 = 0.5f;
		float globalSpeed = 1.0f;
		float globalDegree = 1.0f;
		float globalHeight = 1.0f;

		walk(rightFoot, 0.5f * globalSpeed, 1f * globalDegree, false, -5.5f, 0.5f, f, f1);
		walk(leftFoot, 0.5f * globalSpeed, 1f * globalDegree, false, -2f, 0.0f, f, f1);
		bob(body, 1.0F * globalSpeed, 2F * globalHeight, 1, 1, f, f1);
		walk(rightArm, 0.5f * globalSpeed, 1f * globalDegree, false, -5.5f, 0.5f, f, f1);
		walk(leftArm, 0.5f * globalSpeed, 1f * globalDegree, false, -2f, 0.0f, f, f1);

		swing(wingBoneBase_1, 0.5f * globalSpeed, 1f * globalDegree, -8f, -180f, f, f1);
		swing(wingBoneBase, 0.5f * globalSpeed, 1f * globalDegree, -8f, 0f, f, f1);

		swing(wingBoneSecond_1, 0.5f * globalSpeed, -1f * globalDegree, 0f, -2.8f, f, f1);
		swing(wingBoneSecond, 0.5f * globalSpeed, -1f * globalDegree, 0f, 2f, f, f1);

		swing(wingBoneThird_1, 0.5f * globalSpeed, -1f * globalDegree, 0f, 10f, f, f1);
		swing(wingBoneThird, 0.5f * globalSpeed, -1f * globalDegree, 0f, -10f, f, f1);

		walk(head, 0.5f * globalSpeed, 1f * globalDegree, false, 0f, 0f, f, f1);
		bob(head, 1.0F * globalSpeed, 0.5F * globalHeight, 1, 1, f, f1);

	}

	public void swing(ModelRenderer box, float speed, float degree, float offset, float weight, float f, float f1) {
		box.rotateAngleY = degree * f1 * MathHelper.cos(speed * f + offset) + weight * f1;
	}

	public void flap(ModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f,
			float f1) {

		box.rotateAngleZ = degree * f1 * MathHelper.cos(speed * f + offset) + weight * f1;
	}

	public void bob(ModelRenderer box, float speed, float degree, float offset, float weight, float f, float f1) {
		box.rotationPointY = degree * f1 * MathHelper.cos(speed * f + offset) + weight * f1;
	}

	public void walk(ModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f,
			float f1) {

		box.rotateAngleX = degree * f1 * MathHelper.cos(speed * f + offset) + weight * f1;
	}
}
