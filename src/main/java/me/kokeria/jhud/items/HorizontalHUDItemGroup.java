package me.kokeria.jhud.items;

public class HorizontalHUDItemGroup extends HUDItemGroup {


    public HorizontalHUDItemGroup(int x, int y, POS_H alignH, POS_V alignV) {
        super(x, y, alignH, alignV);
    }

    @Override
    public void alignHorizontal() {
        int curX;

        switch (alignH) {
            case LEFT:
                curX = x - getWidth();
                break;
            case CENTER:
                curX = x - getWidth() / 2;
                break;
            case RIGHT:
                curX = x;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + alignH);
        }

        for (HUDItem item : items) {
            item.x = curX;
            curX += item.getWidth();
        }

    }

    @Override
    public void alignVertical() {

        switch (alignV) {
            case TOP:
                for (HUDItem item : items) {
                    item.y = y - item.getHeight();
                }
                break;

            case CENTER:
                for (HUDItem item : items) {
                    item.y = y - item.getHeight() / 2;
                }
                break;
            case BOTTOM:
                for (HUDItem item : items) {
                    item.y = y;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + alignV);
        }

    }

}
