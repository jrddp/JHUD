package me.kokeria.jhud.gui;

public abstract class GuiMenu {

    int x;
    int y;

    public GuiMenu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract int getWidth();
    public abstract int getHeight();

    public abstract void draw(int mouseX, int mouseY);

    public abstract void handleClick(int mouseX, int mouseY);

    public boolean checkBoundingBox(int targX, int targY) {
        return targX >= x && targX <= x + getWidth() && targY >= y && targY <= y + getHeight();
    }

}
