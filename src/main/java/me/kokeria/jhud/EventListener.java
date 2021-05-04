package me.kokeria.jhud;

import me.kokeria.jhud.items.ItemCount;
import net.minecraft.init.Items;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventListener {

    public static final EventListener INSTANCE = new EventListener();

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {

        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;

        // TODO render
        new ItemCount(25, 25, Items.arrow);

    }

}
