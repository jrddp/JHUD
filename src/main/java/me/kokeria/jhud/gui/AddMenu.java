package me.kokeria.jhud.gui;

import me.kokeria.jhud.items.HUDItem;
import me.kokeria.jhud.util.Renderer;
import net.minecraft.client.gui.FontRenderer;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AddMenu extends GuiMenu {

    private static final ArrayList<ItemSupplier> itemSuppliers = new ArrayList<>();

    private boolean minimized = true;

    private final int MINIMIZED_WIDTH = 20;
    private final int MINIMIZED_HEIGHT = 20;

    private int openedWidth = 60;
    private int openedHeight = 200;

    private final int PADDING = 2;
    private final int ITEM_SPACING = 1;

    public AddMenu(int x, int y) {
        super(x, y);
    }

    public void minimize() {
        minimized = true;
    }

    // unminimize and set width and heights
    public void open() {
        minimized = false;
        Stream<ItemSupplier> supplierStream = itemSuppliers.stream();
        FontRenderer fontRenderer = Renderer.getFontRenderer();

        int maxStrWid = supplierStream.mapToInt(s -> fontRenderer.getStringWidth(s.DISPLAY_NAME)).max().orElse(0);


        openedHeight = MINIMIZED_HEIGHT + fontRenderer.FONT_HEIGHT * itemSuppliers.size() + PADDING * 2 + ITEM_SPACING * (itemSuppliers.size() - 1);
        openedWidth = Math.max(maxStrWid + PADDING * 2, MINIMIZED_WIDTH);
    }

    @Override
    public int getWidth() {
        return minimized ? MINIMIZED_WIDTH : openedWidth;
    }

    @Override
    public int getHeight() {
        return minimized ? MINIMIZED_HEIGHT : openedHeight;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        if (checkBoundingBox(mouseX, mouseY)) open();
        else minimize();

        int width = getWidth();
        int height = getHeight();

        Renderer.drawBackgroundBox(x, y, width,height);

        Renderer.drawHVCenteredString("+", x + MINIMIZED_WIDTH / 2f, y + MINIMIZED_HEIGHT / 2f);


        if (!minimized) {

            FontRenderer fontRenderer = Renderer.getFontRenderer();
            int fontHeight = fontRenderer.FONT_HEIGHT;

            int curX = x + PADDING;
            int curY = y + PADDING + MINIMIZED_HEIGHT;

            for (ItemSupplier itemSupplier : itemSuppliers) {
                fontRenderer.drawStringWithShadow(itemSupplier.DISPLAY_NAME, curX, curY, 0xFFFFFF);
                curY += fontHeight + ITEM_SPACING;
            }

        }

    }

    @Override
    public void handleClick(int mouseX, int mouseY) {

    }

    public static void addItemSupplier(String displayName, Supplier<HUDItem> supplier) {
        itemSuppliers.add(new ItemSupplier(displayName, supplier));
    }

    private static class ItemSupplier {

        final String DISPLAY_NAME;
        final Supplier<HUDItem> SUPPLIER;

        public ItemSupplier(String DISPLAY_NAME, Supplier<HUDItem> SUPPLIER) {
            this.DISPLAY_NAME = DISPLAY_NAME;
            this.SUPPLIER = SUPPLIER;
        }

    }

}
