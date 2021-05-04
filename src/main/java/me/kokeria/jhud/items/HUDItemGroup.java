package me.kokeria.jhud.items;

import java.util.ArrayList;
import java.util.List;

public abstract class HUDItemGroup {

    public enum POS_H {
        LEFT, CENTER, RIGHT
    }

    public enum POS_V {
        BOTTOM, CENTER, TOP
    }

    protected int x, y;
    public POS_H alignH;
    public POS_V alignV;
    public final List<HUDItem> items = new ArrayList<>();

    public HUDItemGroup(int x, int y, POS_H alignH, POS_V alignV) {
        this.x = x;
        this.y = y;
        this.alignH = alignH;
        this.alignV = alignV;
    }

    public abstract void alignHorizontal();
    public abstract void alignVertical();

    public int getWidth() {
        return items.stream().mapToInt(HUDItem::getWidth).sum();
    }

    public int getHeight() {
        return items.stream().mapToInt(HUDItem::getHeight).sum();
    }


    public double getDistance(int targX, int targY) {
        return Math.sqrt((targX - x) ^ 2 + (targY - y) ^ 2);
    }

    public void alignAndRender() {
        alignHorizontal();
        alignVertical();
        for (HUDItem item : items) item.render();
    }
}
