package me.kokeria.jhud.items;

public class HUDItemGroup {

    int x, y;

    enum ALIGNMENT {
        TOP_LEFT, TOP, TOP_RIGHT,
        LEFT, CENTER, RIGHT,
        BOTTOM_LEFT, BOTTOM, BOTTOM_RIGHT
    }

    public double getDistance(int targX, int targY) {
        return Math.sqrt((targX - x)^2 + (targY - y)^2);
    }

}
