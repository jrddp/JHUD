package me.kokeria.jhud;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Settings {

    public static KeyBinding KEY_HUD;

    public static boolean hudEnabled = true;

    public static void registerKeybinds() {
        KEY_HUD = new KeyBinding("key.utility", Keyboard.KEY_F, "key.categories.uxbb");
        ClientRegistry.registerKeyBinding(KEY_HUD);
    }

}
