package fr.nelpats;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import fr.nelpats.model.detection.algorithm.Algorithm;
import fr.nelpats.model.detection.algorithm.Gpt;
import fr.nelpats.model.detection.algorithm.Kenyhnrv;
import fr.nelpats.model.detection.methods.DetectionMethod;
import fr.nelpats.model.detection.methods.IsolationForest;
import fr.nelpats.model.detection.recorder.Engine;
import fr.nelpats.model.detection.recorder.MouseListener;

import java.io.FileWriter;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws Exception {
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


        Algorithm gpt = new Gpt();
        Algorithm keny = new Kenyhnrv();

        IsolationForest isolationForest = new IsolationForest(keny.getDelaySample(10_000));
        isolationForest.getDetection();
        isolationForest = new IsolationForest(gpt.getDelaySample(10_000));
        isolationForest.getDetection();











    }
}