package me.kokeria.jhud.items;

import me.kokeria.jhud.ItemsInit;

public abstract class HUDItem {

    public int x, y;
    private HUDItemGroup group = null;

    public HUDItem(int x, int y) {
        this.x = x;
        this.y = y;

        ItemsInit.ALL_ITEMS.add(this);
    }

    public abstract int getWidth();

    public abstract int getHeight();

    public boolean shouldRender() {
        return true;
    }

    public abstract void render();

    public boolean checkBoundingBox(int targX, int targY) {
        return targX >= x && targX <= x + getWidth() && targY >= y && targY <= y + getHeight();
    }

    public void changeGroup(HUDItemGroup newGroup) {
        if (newGroup == group) return;

        if (group != null) group.removeItem(this);
        group = newGroup;
        if (newGroup != null) newGroup.items.add(this);

    }

}
