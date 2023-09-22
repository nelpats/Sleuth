package fr.nelpats;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import fr.nelpats.model.detection.Engine;
import fr.nelpats.utils.MouseListener;

public class Main {

    public static void main(String[] args) {
        Engine engine = new Engine();
        MouseListener mouseListener = new MouseListener(engine);

        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeMouseListener(mouseListener);




    }
}