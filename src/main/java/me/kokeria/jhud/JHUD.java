package me.kokeria.jhud;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

//        ClientCommandHandler.instance.registerCommand(new Command());

    }

}
