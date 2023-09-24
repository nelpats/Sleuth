package fr.nelpats.model.detection.recorder;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;
import fr.nelpats.Constants;

public class MouseListener implements NativeMouseInputListener {
    private long pressTime = 0;

    private Engine engine;


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

            if (clickDuration >= Constants.MAX_ACCEPTABLE_DELAY || pressTime == 0)
                return;

            try {
                this.engine.setData((int)clickDuration);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }


            System.out.println("Time between Left Mouse Click Press and Release: " + clickDuration + " milliseconds");
        }
    }



}
