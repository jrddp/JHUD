package me.kokeria.jhud;

import me.kokeria.jhud.items.HUDItem;
import me.kokeria.jhud.items.HUDItemGroup;
import me.kokeria.jhud.util.Renderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.io.IOException;

public class GuiHUDPosition extends GuiScreen {

    private HUDItem selectedItem = null;
    private final int SNAP_RADIUS = 15;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        for (HUDItemGroup group : ItemsInit.ITEM_GROUPS) {
            Renderer.drawCenteredDot(group.getX(), group.getY(), 3, new Color(255, 0, 0).getRGB());
        }

        if (selectedItem != null) {
            HUDItemGroup snapGroup = ItemsInit.ITEM_GROUPS.stream()
                    .filter(group -> group.getDistance(mouseX, mouseY) < SNAP_RADIUS).findFirst().orElse(null);

            selectedItem.changeGroup(snapGroup);
            selectedItem.x = mouseX;
            selectedItem.y = mouseY;
        }
        super.drawScreen(mouseX, mouseY, partialTicks);

    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        selectedItem = null;
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (mouseButton == 0) {
            selectedItem = ItemsInit.ALL_ITEMS.stream().filter(item -> item.checkBoundingBox(mouseX, mouseY)).findFirst().orElse(null);
            if (selectedItem != null) selectedItem.changeGroup(null);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

}
