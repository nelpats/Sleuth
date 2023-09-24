package fr.nelpats.model.detection.recorder;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import fr.nelpats.Constants;
import fr.nelpats.model.detection.methods.DetectionMethod;

public class Engine {

        private double[] data = new double[Constants.MAX_SAMPLE];
        private final DetectionMethod detectionMethod;
        private int index = 0;
        public Engine(DetectionMethod method) {
            this.initMouseListener();
            this.detectionMethod = method;
        }


        private void initMouseListener() {
            MouseListener mouseListener = new MouseListener(this);

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


        public void resetData() {
            this.data = new double[Constants.MAX_SAMPLE];
        }

        public void addData(int value) throws Exception {
            this.index += 1;
            if (this.index < Constants.MAX_SAMPLE) {
                this.data[this.index] = value;
            } else {
                this.detectionMethod.setData(this.data);
                this.detectionMethod.getDetection();
                this.index = 0;
            }


        }

}
