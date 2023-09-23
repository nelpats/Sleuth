package fr.nelpats;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.opencsv.CSVWriter;
import fr.nelpats.model.detection.Engine;
import fr.nelpats.model.detection.algorithm.Algorithm;
import fr.nelpats.model.detection.algorithm.Gpt;
import fr.nelpats.model.detection.algorithm.Itori;
import fr.nelpats.utils.MouseListener;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {


    public static void writeToCSVFile(int[] data, String path) {
        try (FileWriter fileWriter = new FileWriter(path);
             CSVWriter csvWriter = new CSVWriter(fileWriter)) {

            for (int value : data) {
                String[] rowData = {String.valueOf(value)};
                csvWriter.writeNext(rowData);
            }

            System.out.println("Array successfully written to CSV file: " + Constants.FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing the array to CSV file: " + e.getMessage());
        }
    }
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


        Algorithm gpt = new Gpt();
        Algorithm itori = new Itori();

        System.out.println(itori.getDelay());
        writeToCSVFile(gpt.getDelaySample(10_000), "gpt.csv");
        System.out.println(gpt.getDelay());






    }
}