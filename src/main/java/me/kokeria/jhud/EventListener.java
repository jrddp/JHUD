package me.kokeria.jhud;

import me.kokeria.jhud.gui.GuiHUDPosition;
import me.kokeria.jhud.items.HUDItem;
import me.kokeria.jhud.items.HUDItemGroup;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class EventListener {

    public static final EventListener INSTANCE = new EventListener();

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {

        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;

        for (HUDItemGroup group : ItemsInit.ITEM_GROUPS) group.alignItems();
        for (HUDItem item : ItemsInit.ALL_ITEMS) item.render();

    }

    @SubscribeEvent
    public void onInputKeyInput(InputEvent.KeyInputEvent event) {
        int key = Keyboard.getEventKey();

        // on key down
        if (Keyboard.getEventKeyState()) {
            if (key == Settings.KEY_HUD.getKeyCode()) {
                // TODO key pressed event
                Minecraft.getMinecraft().displayGuiScreen(new GuiHUDPosition());
            }
        }

    }

}
