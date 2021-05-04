package me.kokeria.jhud.util;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;

import java.util.List;

public class InventoryInspector {

    private final List<Slot> slots;

    public InventoryInspector() {
        this.slots = Minecraft.getMinecraft().thePlayer.inventoryContainer.inventorySlots;
    }

    public int getTotalCountOfItem(Item item) {
        return slots.stream().filter(s -> s.getHasStack() && s.getStack().getItem() == item)
                .mapToInt(s -> s.getStack().stackSize).sum();
    }

}
