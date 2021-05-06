package me.kokeria.jhud.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class Renderer {

    public static final int BOX_COLOR = new Color(0, 0, 0, 90).getRGB();

    public static FontRenderer getFontRenderer() {
        return Minecraft.getMinecraft().fontRendererObj;
    }

    public static void drawHCenteredString(String str, float x, float y, int height) {

        FontRenderer fontRenderer = getFontRenderer();
        int fontHeight = fontRenderer.FONT_HEIGHT;
        int textWidth = fontRenderer.getStringWidth(str);
        float scale = (float) height / fontHeight;

        x /= scale;
        y /= scale;

        GlStateManager.pushMatrix();
        GlStateManager.scale(scale, scale, scale);

        fontRenderer.drawStringWithShadow(str, x - textWidth / 2f, y, 0xFFFFFF);
        GlStateManager.popMatrix();
    }

    public static void drawBackgroundBox(int x, int y, int width, int height) {
        Gui.drawRect(x, y, x + width, y + height, BOX_COLOR);
    }

    public static void drawRect(int x, int y, int width, int height, int color) {
        Gui.drawRect(x, y, x + width, y + height, color);
    }

    public static void drawCenteredDot(int x, int y, int size, int color) {
        Gui.drawRect(x - size / 2, y - size / 2, x + size / 2, y + size / 2, color);
    }

}
