package me.kokeria.jhud.items;

import me.kokeria.jhud.util.InventoryInspector;
import me.kokeria.jhud.util.ItemRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;

public class ItemCount extends HUDItem {

    private final Item item;
    private final Item[] itemsAdditional;

    public ItemCount(int x, int y, Item itemMain, Item... itemsAdditional) {
        super(x, y);
        this.item = itemMain;
        this.itemsAdditional = itemsAdditional;
    }

    @Override
    public int getWidth() {
        return 16;
    }

    @Override
    public int getHeight() {
        return 16;
    }

    @Override
    public void render() {
        ItemRenderer.drawItem(item, x, y);

        InventoryInspector slotsInspector = new InventoryInspector();
        int count = slotsInspector.getTotalCountOfItem(item);
        for (Item aItem : itemsAdditional) {
            count += slotsInspector.getTotalCountOfItem(aItem);
        }

        String str = (count > 0 ? EnumChatFormatting.WHITE : EnumChatFormatting.GRAY) + "" + count;
        ItemRenderer.drawTextOnItem(str + "", x, y, 1, 0xFFFFFF, ItemRenderer.EnumCorner.BOTTOM_RIGHT);
        ItemRenderer.drawBoxOnItem(x, y, count == 0);
    }

}
