package me.kokeria.jhud;

import me.kokeria.jhud.gui.AddMenu;
import me.kokeria.jhud.items.Compass;
import me.kokeria.jhud.items.HUDItem;
import me.kokeria.jhud.items.ItemCount;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod(modid = JHUD.MODID, version = JHUD.VERSION, clientSideOnly = true)
public class JHUD {
    public static final String MODID = "me/kokeria/jhud";
    public static final String VERSION = "0.1";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Settings.registerKeybinds();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(EventListener.INSTANCE);

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        registerHUDItem("Compass", () -> new Compass(0, 0));
        registerHUDItem("Item Count", () -> new ItemCount(0, 0, Items.iron_ingot));
    }

    public static void registerHUDItem(String displayName, Supplier<HUDItem> defaultSupplier) {
        AddMenu.addItemSupplier(displayName, defaultSupplier);
    }

}
