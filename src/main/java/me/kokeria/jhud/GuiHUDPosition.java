package me.kokeria.jhud;

import me.kokeria.jhud.items.HUDItem;
import me.kokeria.jhud.items.HUDItemGroup;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class GuiHUDPosition extends GuiScreen {

    private HUDItem selectedItem = null;
    private int snapRadius = 15;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        if (selectedItem != null) {
            HUDItemGroup snapGroup = ItemsInit.ITEM_GROUPS.stream()
                    .filter(group -> group.getDistance(mouseX, mouseY) < snapRadius).findFirst().orElse(null);

            selectedItem.changeGroup(snapGroup);
            System.out.println("Snapping " + partialTicks);
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
