package me.kokeria.jhud;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Settings {

    public static KeyBinding KEY_HUD;

    public static boolean hudEnabled = true;

    public static void registerKeybinds() {
        KEY_HUD = new KeyBinding("key.edit_hud", Keyboard.KEY_F, "key.categories.jhud");
        ClientRegistry.registerKeyBinding(KEY_HUD);
    }

}
