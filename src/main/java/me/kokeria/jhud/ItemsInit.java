package me.kokeria.jhud;

import me.kokeria.jhud.items.*;
import net.minecraft.init.Items;

import java.util.HashSet;
import java.util.Set;

import static me.kokeria.jhud.items.HUDItemGroup.POS_H.*;
import static me.kokeria.jhud.items.HUDItemGroup.POS_V.BOTTOM;
import static me.kokeria.jhud.items.HUDItemGroup.POS_V.TOP;

public class ItemsInit {

    // These sets are populated through constructors
    public static final Set<HUDItem> ALL_ITEMS = new HashSet<>();
    public static final Set<HUDItemGroup> ITEM_GROUPS = new HashSet<>();

    static {
        HUDItemGroup centerGroup = new HorizontalHUDItemGroup((wid) -> wid / 2, (height) -> height / 2, CENTER, HUDItemGroup.POS_V.CENTER);
        HUDItemGroup aboveHotbarGroup1 = new HorizontalHUDItemGroup((wid) -> wid / 2, (height) -> height - 76 - 18, CENTER, TOP);
        HUDItemGroup aboveHotbarGroup2 = new HorizontalHUDItemGroup((wid) -> wid / 2, (height) -> height - 76, CENTER, TOP);
        HUDItemGroup leftHotbarGroup = new HorizontalHUDItemGroup((wid) -> wid / 2 - 91 - 25, (height) -> height - 4, LEFT, TOP);
        HUDItemGroup rightHotbarGroup = new HorizontalHUDItemGroup((wid) -> wid / 2 + 91 + 25, (height) -> height - 4, RIGHT, TOP);
        HUDItemGroup topCenterGroup = new HorizontalHUDItemGroup((wid) -> wid / 2, (height) -> 22, CENTER, BOTTOM);

        centerGroup.addItem(new ItemCount(25, 25, Items.arrow));
        centerGroup.addItem(new ItemCount(25, 25, Items.rabbit));

        rightHotbarGroup.addItem(new ItemCount(25, 25, Items.hopper_minecart));
        rightHotbarGroup.addItem(new ItemCount(25, 25, Items.baked_potato));

        aboveHotbarGroup1.addItem(new ItemCount(25, 25, Items.hopper_minecart));
        aboveHotbarGroup1.addItem(new ItemCount(25, 25, Items.baked_potato));

        aboveHotbarGroup2.addItem(new ItemCount(25, 25, Items.hopper_minecart));
        aboveHotbarGroup2.addItem(new ItemCount(25, 25, Items.baked_potato));

        topCenterGroup.addItem(new Compass(0, 0));

    }

}
