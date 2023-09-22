package fr.nelpats.utils;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;
import fr.nelpats.Constants;
import fr.nelpats.model.detection.Engine;

import java.lang.reflect.Array;
import java.util.List;

public class MouseListener implements NativeMouseInputListener {
    private long pressTime = 0;

    private Engine engine;

    private int index = 0;

    public MouseListener(Engine engine) {
        this.engine = engine;

    }
    public void nativeMousePressed(NativeMouseEvent e) {
        if (e.getButton() == NativeMouseEvent.BUTTON1) {
            pressTime = System.currentTimeMillis();
        }
    }

    public void nativeMouseReleased(NativeMouseEvent e) {


        if (e.getButton() == NativeMouseEvent.BUTTON1) {
            long releaseTime = System.currentTimeMillis();
            long clickDuration = releaseTime - pressTime;

            if (clickDuration >= 500)
                return;

            index += 1;
            this.engine.setData((int)clickDuration, index);


            System.out.println("Time between Left Mouse Click Press and Release: " + clickDuration + " milliseconds");
        }
    }



}
