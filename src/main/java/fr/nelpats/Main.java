package fr.nelpats;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import fr.nelpats.model.detection.algorithm.Algorithm;
import fr.nelpats.model.detection.algorithm.Gpt;
import fr.nelpats.model.detection.algorithm.Kenyhnrv;
import fr.nelpats.model.detection.methods.Csv;
import fr.nelpats.model.detection.methods.DetectionMethod;
import fr.nelpats.model.detection.methods.IsolationForest;
import fr.nelpats.model.detection.recorder.Engine;
import fr.nelpats.model.detection.recorder.MouseListener;

import java.io.FileWriter;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {


        Algorithm gpt = new Gpt();
        Algorithm keny = new Kenyhnrv();

        Engine engine = new Engine(new Csv());











    }
}