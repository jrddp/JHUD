package me.kokeria.jhud.items;

public abstract class HUDItem {

    int x, y;

    public HUDItem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract int getWidth();

    public abstract int getHeight();

    public boolean shouldRender() {
        return true;
    }

    public abstract void render();

    public boolean checkBoundingBox(int targX, int targY) {
        return targX >= x && targX <= x + getWidth() && targY >= y && targY <= targY + getHeight();
    }

}
