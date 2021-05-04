package me.kokeria.jhud.items;

import me.kokeria.jhud.ItemsInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MathHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class HUDItemGroup {

    Minecraft mc = Minecraft.getMinecraft();

    public enum POS_H {
        LEFT, CENTER, RIGHT
    }

    public enum POS_V {
        BOTTOM, CENTER, TOP
    }

    // functions to provide x and y based on display width and height
    private final Function<Integer, Integer> xSupplier, ySupplier;
    public POS_H alignH;
    public POS_V alignV;
    public final List<HUDItem> items = new ArrayList<>();

    public HUDItemGroup(Function<Integer, Integer> xSupplier, Function<Integer, Integer> ySupplier, POS_H alignH, POS_V alignV) {
        this.xSupplier = xSupplier;
        this.ySupplier = ySupplier;
        this.alignH = alignH;
        this.alignV = alignV;

        ItemsInit.ITEM_GROUPS.add(this);
    }

    public abstract void alignHorizontal();
    public abstract void alignVertical();

    public void alignItems() {
        alignHorizontal();
        alignVertical();
    }

    public int getX() {
        int wid = new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth();
        return xSupplier.apply(wid);
    }

    public int getY() {
        int height = new ScaledResolution(Minecraft.getMinecraft()).getScaledHeight();
        return ySupplier.apply(height);
    }

    public int getWidth() {
        return items.stream().mapToInt(HUDItem::getWidth).sum();
    }

    public int getHeight() {
        return items.stream().mapToInt(HUDItem::getHeight).sum();
    }


    public double getDistance(int targX, int targY) {
        return Math.hypot(targX - getX(), targY - getY());
    }

    public void alignAndRender() {
        alignHorizontal();
        alignVertical();
        for (HUDItem item : items) item.render();
    }

}
