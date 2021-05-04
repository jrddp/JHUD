package me.kokeria.jhud.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemRenderer {

    public enum EnumCorner {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    public static void drawItem(Item item, int x, int y) {
        drawItem(new ItemStack(item), x, y);
    }

    public static void drawItem(ItemStack itemStack, int x, int y) {
        Minecraft mc = Minecraft.getMinecraft();
        GlStateManager.pushMatrix();
        GlStateManager.translate(0, 0, -300);
        mc.getRenderItem().renderItemIntoGUI(itemStack, x, y);
        GlStateManager.popMatrix();
    }

    public static void drawTextOnItem(String text, int x, int y, float scale, int color, EnumCorner corner) {

        Minecraft mc = Minecraft.getMinecraft();
        FontRenderer fr = mc.fontRendererObj;

        GlStateManager.pushMatrix();
        GlStateManager.scale(scale, scale, scale);
        x /= scale;
        y /= scale;

        switch (corner) {
            case TOP_RIGHT:
                x += 16 / scale - fr.getStringWidth(text);
                break;
            case BOTTOM_LEFT:
                y += 16 / scale - fr.FONT_HEIGHT;
                break;
            case BOTTOM_RIGHT:
                x += 16 / scale - fr.getStringWidth(text);
                y += 16 / scale - fr.FONT_HEIGHT + 2;
        }

        fr.drawStringWithShadow(text, (float) (x), (float) (y), color);
        GlStateManager.popMatrix();

    }

    public static void drawBoxOnItem(int itemX, int itemY, boolean cover) {
        GlStateManager.pushMatrix();
        if (!cover) GlStateManager.translate(0, 0, -300);
        Renderer.drawBox(itemX, itemY, 16, 16);
        GlStateManager.popMatrix();
    }

}
