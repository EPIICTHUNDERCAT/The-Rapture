package com.github.epiicthundercat.init;
/**
 * ALL CREDIT GOES TO RAIDERS MOD ANNOUNCEMENT!
 * 
 */
import java.awt.Color;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TheRaptureAnnouncement {
	public static void ScheduleNotice(String mainTxt, SoundEvent sound) {
		// Temp fix for only having one notic
		if (notices.size() == 0) {
			notices.add(new RaptureChange(mainTxt, sound));
		}
	}

	static ArrayList<RaptureChange> notices = new ArrayList<RaptureChange>();

	@SubscribeEvent
	public void onDrawScreen(RenderGameOverlayEvent.Post event) {
		if (event.getType() != RenderGameOverlayEvent.ElementType.HELMET || notices.size() <= 0) {
			return;
		}

		Minecraft mc = Minecraft.getMinecraft();
		ScaledResolution resolution = new ScaledResolution(mc);
		int width = resolution.getScaledWidth();
		int height = resolution.getScaledHeight();
		RaptureChange notice = notices.get(0);

		if (!notice.init) {
			if (mc.isGamePaused() || mc.currentScreen != null) {
				return; // Do not start showing a new notice if the player isn't
						// looking
			}

			notice.init = true;
			notice.startTime = Minecraft.getSystemTime();
			mc.getSoundHandler().playSound(
					PositionedSoundRecord.getMasterRecord(TheRaptureSoundHandler.THE_RAPTURE_HAS_BEGUN, 1.0F));
		}

		if (notice.getTime() >= 6F) {
			notices.remove(0);
			return;
		}

		GlStateManager.pushMatrix();

		float scale = width > 600 ? 1.5F : 1F;

		GlStateManager.scale(scale, scale, scale);
		width = MathHelper.ceil(width / scale);
		height = MathHelper.ceil(height / scale);

		float alpha = notice.getTime() <= 4F ? Math.min(1F, notice.getTime()) : Math.max(0F, 5F - notice.getTime());
		alpha = MathHelper.clamp(alpha, 0.02F, 1F);
		int color = new Color(1F, 1F, 1F, alpha).getRGB();

		GlStateManager.color(1F, 1F, 1F, alpha);

		GlStateManager.enableBlend();
		GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);

		String tmp = TextFormatting.RED + "" + TextFormatting.UNDERLINE + "" + TextFormatting.BOLD
				+ I18n.format(notice.mainTxt);
		int txtW = mc.fontRendererObj.getStringWidth(tmp);
		mc.fontRendererObj.drawString(tmp, width / 2 - txtW / 2, height / 4, color, true);

		GlStateManager.popMatrix();
	}

	public static class RaptureChange {
		long startTime = 0;
		public boolean init = false;
		public String mainTxt = "";

		public ItemStack icon = null;
		private SoundEvent sound;

		public RaptureChange(String mainTxt, SoundEvent sound) {
			this.startTime = Minecraft.getSystemTime();
			this.mainTxt = mainTxt;

			this.sound = sound;
		}

		public float getTime() {
			return (Minecraft.getSystemTime() - startTime) / 1000F;
		}
	}
}
