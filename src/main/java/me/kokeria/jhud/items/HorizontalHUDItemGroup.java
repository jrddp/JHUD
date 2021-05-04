package me.kokeria.jhud.items;

import java.util.function.Function;
import java.util.function.Supplier;

public class HorizontalHUDItemGroup extends HUDItemGroup {


    public HorizontalHUDItemGroup(Function<Integer, Integer> xSupplier, Function<Integer, Integer> ySupplier, POS_H alignH, POS_V alignV) {
        super(xSupplier, ySupplier, alignH, alignV);
    }

    @Override
    public void alignHorizontal() {
        int groupX = getX();
        int curX;

        switch (alignH) {
            case LEFT:
                curX = groupX - getWidth();
                break;
            case CENTER:
                curX = groupX - getWidth() / 2;
                break;
            case RIGHT:
                curX = groupX;
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

        int y = getY();

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
