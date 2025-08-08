package net.generalsabre.sabresdimensions.util;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;


public class ModKeyBindings {

    public static KeyBinding JUMP_JET_KEY;

    public static void registerModKeyBindings(){
        JUMP_JET_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.sabresdimensions.jump_jet",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_CAPS_LOCK,
                "category.sabresdimensions.controls"
        ));
    }

}
