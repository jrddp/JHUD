package me.kokeria.jhud;

import me.kokeria.jhud.items.HUDItem;
import me.kokeria.jhud.items.HUDItemGroup;
import me.kokeria.jhud.items.HUDItemGroup.POS_V;
import me.kokeria.jhud.items.HorizontalHUDItemGroup;
import me.kokeria.jhud.items.ItemCount;
import net.minecraft.init.Items;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

import static me.kokeria.jhud.items.HUDItemGroup.POS_H.*;
import static me.kokeria.jhud.items.HUDItemGroup.POS_V.BOTTOM;
import static me.kokeria.jhud.items.HUDItemGroup.POS_V.TOP;

public class EventListener {

    public static final EventListener INSTANCE = new EventListener();

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {

        int wid = event.resolution.getScaledWidth();
        int height = event.resolution.getScaledHeight();

        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;


        // TODO render
        HUDItemGroup centerGroup = new HorizontalHUDItemGroup(wid / 2, height / 2, CENTER, POS_V.CENTER);
        HUDItemGroup aboveHotbarGroup1 = new HorizontalHUDItemGroup(wid / 2, height - 76 - 18, CENTER, TOP);
        HUDItemGroup aboveHotbarGroup2 = new HorizontalHUDItemGroup(wid / 2, height - 76, CENTER, TOP);
        HUDItemGroup rightHotbarGroup = new HorizontalHUDItemGroup(wid / 2 + 91 + 25, height - 4, RIGHT, TOP);

        centerGroup.items.add(new ItemCount(25, 25, Items.arrow));
        centerGroup.items.add(new ItemCount(25, 25, Items.rabbit));

        rightHotbarGroup.items.add(new ItemCount(25, 25, Items.hopper_minecart));
        rightHotbarGroup.items.add(new ItemCount(25, 25, Items.baked_potato));

        aboveHotbarGroup1.items.add(new ItemCount(25, 25, Items.hopper_minecart));
        aboveHotbarGroup1.items.add(new ItemCount(25, 25, Items.baked_potato));

        aboveHotbarGroup2.items.add(new ItemCount(25, 25, Items.hopper_minecart));
        aboveHotbarGroup2.items.add(new ItemCount(25, 25, Items.baked_potato));

        centerGroup.alignAndRender();
        rightHotbarGroup.alignAndRender();
        aboveHotbarGroup1.alignAndRender();
        aboveHotbarGroup2.alignAndRender();

    }

    @SubscribeEvent
    public void onInputKeyInput(InputEvent.KeyInputEvent event) {
        int key = Keyboard.getEventKey();

        // on key down
        if (Keyboard.getEventKeyState()) {
            if (key == Settings.KEY_HUD.getKeyCode()) {
                // TODO key pressed event
            }
        }

    }

}
