package me.kokeria.jhud;

import me.kokeria.jhud.items.HUDItem;
import me.kokeria.jhud.items.HUDItemGroup;
import me.kokeria.jhud.items.HorizontalHUDItemGroup;
import me.kokeria.jhud.items.ItemCount;
import net.minecraft.init.Items;

import java.util.HashSet;
import java.util.Set;

import static me.kokeria.jhud.items.HUDItemGroup.POS_H.CENTER;
import static me.kokeria.jhud.items.HUDItemGroup.POS_H.RIGHT;
import static me.kokeria.jhud.items.HUDItemGroup.POS_V.TOP;

public class ItemsInit {

    // These sets are populated through constructors
    public static final Set<HUDItem> ALL_ITEMS = new HashSet<>();
    public static final Set<HUDItemGroup> ITEM_GROUPS = new HashSet<>();

    static {
        HUDItemGroup centerGroup = new HorizontalHUDItemGroup((wid) -> wid / 2, (height) -> height / 2, CENTER, HUDItemGroup.POS_V.CENTER);
        HUDItemGroup aboveHotbarGroup1 = new HorizontalHUDItemGroup((wid) -> wid / 2, (height) -> height - 76 - 18, CENTER, TOP);
        HUDItemGroup aboveHotbarGroup2 = new HorizontalHUDItemGroup((wid) -> wid / 2, (height) -> height - 76, CENTER, TOP);
        HUDItemGroup rightHotbarGroup = new HorizontalHUDItemGroup((wid) -> wid / 2 + 91 + 25, (height) -> height - 4, RIGHT, TOP);

        centerGroup.addItem(new ItemCount(25, 25, Items.arrow));
        centerGroup.addItem(new ItemCount(25, 25, Items.rabbit));

        rightHotbarGroup.addItem(new ItemCount(25, 25, Items.hopper_minecart));
        rightHotbarGroup.addItem(new ItemCount(25, 25, Items.baked_potato));

        aboveHotbarGroup1.addItem(new ItemCount(25, 25, Items.hopper_minecart));
        aboveHotbarGroup1.addItem(new ItemCount(25, 25, Items.baked_potato));

        aboveHotbarGroup2.addItem(new ItemCount(25, 25, Items.hopper_minecart));
        aboveHotbarGroup2.addItem(new ItemCount(25, 25, Items.baked_potato));


    }

}
