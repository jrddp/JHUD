package me.kokeria.jhud.gui;

import me.kokeria.jhud.util.Renderer;

public class AddMenu extends GuiMenu {

    private boolean minimized = true;

    private final int minimizedWidth = 20;
    private final int minimizedHeight = 20;

    private final int openedWidth = 60;
    private final int openedHeight = 200;

    public AddMenu(int x, int y) {
        super(x, y);
    }


    @Override
    public int getWidth() {
        return minimized ? minimizedWidth : openedWidth;
    }

    @Override
    public int getHeight() {
        return minimized ? minimizedHeight : openedHeight;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        minimized = !checkBoundingBox(mouseX, mouseY);
        Renderer.drawBackgroundBox(x, y, getWidth(), getHeight());
    }

    @Override
    public void handleClick(int mouseX, int mouseY) {

    }

}
