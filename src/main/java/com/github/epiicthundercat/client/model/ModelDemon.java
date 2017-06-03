package com.github.epiicthundercat.client.model;

import com.github.epiicthundercat.entity.monster.EntityDemon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelDemon - Epiic_Thundercat
 */
public class ModelDemon extends ModelBase {
	public ModelRenderer bodyLeft;
	public ModelRenderer bodyMid;
	public ModelRenderer bodyRight;
	public ModelRenderer legLeft;
	public ModelRenderer armLeft;
	public ModelRenderer neck;
	public ModelRenderer bodyBottom;
	public ModelRenderer head;
	public ModelRenderer bottomHornRight;
	public ModelRenderer bottomHornLeft;
	public ModelRenderer middleHornRight;
	public ModelRenderer topHornRight;
	public ModelRenderer topHornRight1;
	public ModelRenderer topHornRight2;
	public ModelRenderer middleHornLeft;
	public ModelRenderer topHornLeft;
	public ModelRenderer topHornLeft1;
	public ModelRenderer topHornLeft2;
	public ModelRenderer legRight;
	public ModelRenderer armRight;
	public ModelRenderer legRight2;
	public ModelRenderer footRight;
	public ModelRenderer footRight2;
	public ModelRenderer armRight2;
	public ModelRenderer finger1Right;
	public ModelRenderer finger2Right;
	public ModelRenderer finger3Right;
	public ModelRenderer legLeft2;
	public ModelRenderer footLeft;
	public ModelRenderer footLeft2;
	public ModelRenderer armLeft2;
	public ModelRenderer finger1Left;
	public ModelRenderer finger2Left;
	public ModelRenderer finger3Left;

	public ModelDemon() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.armRight = new ModelRenderer(this, 102, 2);
		this.armRight.mirror = true;
		this.armRight.setRotationPoint(2.0F, -3.0F, 1.0F);
		this.armRight.addBox(0.0F, -1.2F, -2.0F, 9, 3, 3, 0.0F);
		this.setRotateAngle(armRight, 0.0F, 0.0F, 0.6373942428283291F);
		this.finger1Right = new ModelRenderer(this, 106, 16);
		this.finger1Right.mirror = true;
		this.finger1Right.setRotationPoint(6.6F, -0.8F, -0.5F);
		this.finger1Right.addBox(0.0F, -0.4F, -0.5F, 3, 1, 1, 0.0F);
		this.legLeft = new ModelRenderer(this, 10, 28);
		this.legLeft.mirror = true;
		this.legLeft.setRotationPoint(-2.2F, 7.0F, 0.0F);
		this.legLeft.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.setRotateAngle(legLeft, 0.0F, 0.0F, 0.5462880558742251F);
		this.topHornRight1 = new ModelRenderer(this, 18, 0);
		this.topHornRight1.setRotationPoint(-1.0F, -7.3F, -0.3F);
		this.topHornRight1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(topHornRight1, -0.7864453609486449F, 0.0F, 0.0F);
		this.middleHornRight = new ModelRenderer(this, 28, 1);
		this.middleHornRight.setRotationPoint(0.4F, -4.6F, 0.4F);
		this.middleHornRight.addBox(-1.0F, -6.6F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(middleHornRight, 0.9105382707654417F, 0.0F, 0.0F);
		this.bodyRight = new ModelRenderer(this, 88, 32);
		this.bodyRight.setRotationPoint(6.8F, 3.4F, 0.0F);
		this.bodyRight.addBox(-4.0F, -6.0F, -3.0F, 7, 12, 7, 0.0F);
		this.setRotateAngle(bodyRight, 0.0F, 0.0F, 0.8141960960553547F);
		this.armLeft2 = new ModelRenderer(this, 104, 9);
		this.armLeft2.setRotationPoint(-9.3F, 0.3F, 0.0F);
		this.armLeft2.addBox(-6.0F, -1.2F, -2.0F, 7, 3, 3, 0.0F);
		this.setRotateAngle(armLeft2, 0.0F, 0.0F, -0.5009094953223726F);
		this.legRight = new ModelRenderer(this, 10, 28);
		this.legRight.setRotationPoint(1.2F, 7.0F, 0.1F);
		this.legRight.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.setRotateAngle(legRight, 0.0F, 0.0F, -0.5527457741066042F);
		this.head = new ModelRenderer(this, 47, 4);
		this.head.setRotationPoint(0.0F, -2.0F, -0.5F);
		this.head.addBox(-4.0F, -9.0F, -3.0F, 8, 10, 6, 0.0F);
		this.setRotateAngle(head, 0.136659280431156F, 0.0F, 0.0F);
		this.topHornRight = new ModelRenderer(this, 18, 0);
		this.topHornRight.setRotationPoint(0.0F, -6.6F, 1.0F);
		this.topHornRight.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(topHornRight, -0.7864453609486449F, 0.0F, 0.0F);
		this.finger2Left = new ModelRenderer(this, 106, 16);
		this.finger2Left.setRotationPoint(-5.4F, 0.2F, -0.5F);
		this.finger2Left.addBox(-3.0F, -0.4F, -0.5F, 3, 1, 1, 0.0F);
		this.bodyMid = new ModelRenderer(this, 32, 31);
		this.bodyMid.setRotationPoint(3.7F, -0.2F, 0.0F);
		this.bodyMid.addBox(-3.0F, -5.0F, -3.0F, 6, 12, 7, 0.0F);
		this.setRotateAngle(bodyMid, 0.0F, 0.0F, 0.40980330836826856F);
		this.bottomHornRight = new ModelRenderer(this, 37, 0);
		this.bottomHornRight.setRotationPoint(1.7F, -9.0F, 0.6F);
		this.bottomHornRight.addBox(-1.0F, -5.0F, -1.0F, 3, 6, 3, 0.0F);
		this.setRotateAngle(bottomHornRight, -0.045553093477052F, -0.40980330836826856F, 0.22759093446006054F);
		this.finger3Right = new ModelRenderer(this, 106, 16);
		this.finger3Right.mirror = true;
		this.finger3Right.setRotationPoint(6.6F, 1.3F, -0.5F);
		this.finger3Right.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
		this.finger2Right = new ModelRenderer(this, 106, 16);
		this.finger2Right.mirror = true;
		this.finger2Right.setRotationPoint(6.6F, 0.2F, -0.5F);
		this.finger2Right.addBox(0.0F, -0.4F, -0.5F, 3, 1, 1, 0.0F);
		this.bodyLeft = new ModelRenderer(this, 59, 30);
		this.bodyLeft.setRotationPoint(-3.0F, -2.2F, 0.0F);
		this.bodyLeft.addBox(-4.0F, -6.0F, -3.0F, 7, 12, 7, 0.0F);
		this.setRotateAngle(bodyLeft, 0.0F, 0.0F, -0.40980330836826856F);
		this.footLeft = new ModelRenderer(this, 0, 55);
		this.footLeft.mirror = true;
		this.footLeft.setRotationPoint(0.5F, 8.1F, -0.3F);
		this.footLeft.addBox(-1.0F, 0.0F, -4.9F, 2, 2, 6, 0.0F);
		this.setRotateAngle(footLeft, 0.27314402793711257F, -0.18203784098300857F, 0.0F);
		this.footLeft2 = new ModelRenderer(this, 0, 55);
		this.footLeft2.mirror = true;
		this.footLeft2.setRotationPoint(-0.5F, 8.1F, -0.3F);
		this.footLeft2.addBox(-1.0F, 0.0F, -4.9F, 2, 2, 6, 0.0F);
		this.setRotateAngle(footLeft2, 0.27314402793711257F, 0.27314402793711257F, 0.0F);
		this.legRight2 = new ModelRenderer(this, 10, 40);
		this.legRight2.setRotationPoint(0.0F, 8.7F, 0.0F);
		this.legRight2.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
		this.setRotateAngle(legRight2, 0.0F, 0.0F, 0.18203784098300857F);
		this.bottomHornLeft = new ModelRenderer(this, 74, 0);
		this.bottomHornLeft.setRotationPoint(-2.7F, -9.0F, 0.0F);
		this.bottomHornLeft.addBox(-1.0F, -5.0F, -1.0F, 3, 6, 3, 0.0F);
		this.setRotateAngle(bottomHornLeft, -0.048869219055841226F, 0.27314402793711257F, -0.22863813201125716F);
		this.armLeft = new ModelRenderer(this, 102, 2);
		this.armLeft.setRotationPoint(-3.2F, -3.0F, 1.0F);
		this.armLeft.addBox(-9.0F, -1.2F, -2.0F, 9, 3, 3, 0.0F);
		this.setRotateAngle(armLeft, 0.0F, 0.0F, -0.5918411493512771F);
		this.topHornLeft2 = new ModelRenderer(this, 18, 0);
		this.topHornLeft2.setRotationPoint(-1.0F, -7.6F, 0.0F);
		this.topHornLeft2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(topHornLeft2, -0.7864453609486449F, 0.0F, 0.0F);
		this.footRight = new ModelRenderer(this, 0, 55);
		this.footRight.setRotationPoint(0.5F, 8.1F, -0.3F);
		this.footRight.addBox(-1.0F, 0.0F, -4.9F, 2, 2, 6, 0.0F);
		this.setRotateAngle(footRight, 0.27314402793711257F, -0.18203784098300857F, 0.0F);
		this.footRight2 = new ModelRenderer(this, 0, 55);
		this.footRight2.setRotationPoint(-0.5F, 8.1F, -0.3F);
		this.footRight2.addBox(-1.0F, 0.0F, -4.9F, 2, 2, 6, 0.0F);
		this.setRotateAngle(footRight2, 0.27314402793711257F, 0.27314402793711257F, 0.0F);
		this.legLeft2 = new ModelRenderer(this, 10, 40);
		this.legLeft2.mirror = true;
		this.legLeft2.setRotationPoint(0.0F, 8.7F, 0.0F);
		this.legLeft2.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
		this.setRotateAngle(legLeft2, 0.0F, 0.0F, -0.18203784098300857F);
		this.neck = new ModelRenderer(this, 54, 21);
		this.neck.setRotationPoint(0.0F, -5.9F, 0.0F);
		this.neck.addBox(-2.0F, -2.5F, -2.0F, 4, 5, 4, 0.0F);
		this.setRotateAngle(neck, -0.136659280431156F, 0.0F, 0.0F);
		this.topHornLeft = new ModelRenderer(this, 18, 0);
		this.topHornLeft.setRotationPoint(0.0F, -6.6F, 1.0F);
		this.topHornLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(topHornLeft, -0.7864453609486449F, 0.0F, 0.0F);
		this.bodyBottom = new ModelRenderer(this, 43, 50);
		this.bodyBottom.setRotationPoint(-5.0F, 7.0F, -3.0F);
		this.bodyBottom.addBox(0.0F, 0.0F, 0.0F, 10, 5, 7, 0.0F);
		this.middleHornLeft = new ModelRenderer(this, 87, 0);
		this.middleHornLeft.setRotationPoint(0.4F, -4.6F, 0.4F);
		this.middleHornLeft.addBox(-1.0F, -6.6F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(middleHornLeft, 0.6373942428283291F, 0.5009094953223726F, -0.22759093446006054F);
		this.topHornLeft1 = new ModelRenderer(this, 18, 0);
		this.topHornLeft1.setRotationPoint(-1.0F, -7.3F, -0.3F);
		this.topHornLeft1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(topHornLeft1, -0.7864453609486449F, 0.0F, 0.0F);
		this.armRight2 = new ModelRenderer(this, 104, 9);
		this.armRight2.mirror = true;
		this.armRight2.setRotationPoint(8.5F, -0.2F, 0.0F);
		this.armRight2.addBox(0.0F, -1.2F, -2.0F, 7, 3, 3, 0.0F);
		this.setRotateAngle(armRight2, 0.0F, 0.0F, 0.5009094953223726F);
		this.finger3Left = new ModelRenderer(this, 106, 16);
		this.finger3Left.setRotationPoint(-5.4F, 1.3F, -0.5F);
		this.finger3Left.addBox(-3.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
		this.finger1Left = new ModelRenderer(this, 106, 16);
		this.finger1Left.setRotationPoint(-5.4F, -0.8F, -0.5F);
		this.finger1Left.addBox(-3.0F, -0.4F, -0.5F, 3, 1, 1, 0.0F);
		this.topHornRight2 = new ModelRenderer(this, 18, 0);
		this.topHornRight2.setRotationPoint(-1.0F, -7.6F, 0.0F);
		this.topHornRight2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(topHornRight2, -0.7864453609486449F, 0.0F, 0.0F);
		this.bodyRight.addChild(this.armRight);
		this.armRight2.addChild(this.finger1Right);
		this.bodyLeft.addChild(this.legLeft);
		this.middleHornRight.addChild(this.topHornRight1);
		this.bottomHornRight.addChild(this.middleHornRight);
		this.bodyLeft.addChild(this.bodyRight);
		this.armLeft.addChild(this.armLeft2);
		this.bodyRight.addChild(this.legRight);
		this.neck.addChild(this.head);
		this.middleHornRight.addChild(this.topHornRight);
		this.armLeft2.addChild(this.finger2Left);
		this.bodyLeft.addChild(this.bodyMid);
		this.head.addChild(this.bottomHornRight);
		this.armRight2.addChild(this.finger3Right);
		this.armRight2.addChild(this.finger2Right);
		this.legLeft2.addChild(this.footLeft);
		this.legLeft2.addChild(this.footLeft2);
		this.legRight.addChild(this.legRight2);
		this.head.addChild(this.bottomHornLeft);
		this.bodyLeft.addChild(this.armLeft);
		this.middleHornLeft.addChild(this.topHornLeft2);
		this.legRight2.addChild(this.footRight);
		this.legRight2.addChild(this.footRight2);
		this.legLeft.addChild(this.legLeft2);
		this.bodyMid.addChild(this.neck);
		this.middleHornLeft.addChild(this.topHornLeft);
		this.bodyMid.addChild(this.bodyBottom);
		this.bottomHornLeft.addChild(this.middleHornLeft);
		this.middleHornLeft.addChild(this.topHornLeft1);
		this.armRight.addChild(this.armRight2);
		this.armLeft2.addChild(this.finger3Left);
		this.armLeft2.addChild(this.finger1Left);
		this.middleHornRight.addChild(this.topHornRight2);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.bodyLeft.render(f5);
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
		EntityDemon demon = (EntityDemon) entity;
		f = entity.ticksExisted;
		f1 = 0.5f;
		float globalSpeed = 1.0f;
		float globalDegree = 1.0f;
		float globalHeight = 1.0f;

		bob(bodyLeft, 1.0F * globalSpeed, 2F * globalHeight, 1, 1, f, f1);

		swing(armLeft, 0.5f * globalSpeed, 1f * globalDegree, -5.5f, 0.5f, f, f1);
		swing(armLeft2, 0.5f * globalSpeed, 1f * globalDegree, -2f, 0.0f, f, f1);
		swing(armRight, 0.5f * globalSpeed, 1f * globalDegree, -5.5f, 0.5f, f, f1);
		swing(armRight2, 0.5f * globalSpeed, 1f * globalDegree, -2f, 0.0f, f, f1);

		walk(legLeft, 0.5f * globalSpeed, 1f * globalDegree, false, 0.0f, 0.0f, f, f1);
		walk(legLeft2, 0.5f * globalSpeed, 1f * globalDegree, false, 0.0f, 0.0f, f, f1);
		walk(legRight, 0.5f * globalSpeed, -1f * globalDegree, true, 0.0f, -1.0f, f, f1);
		walk(legRight2, 0.5f * globalSpeed, -1f * globalDegree, true, 0.0f, 1.0f, f, f1);

		//walk(head, 0.5f * globalSpeed, 1f * globalDegree, false, 0f, 0f, f, f1);
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
