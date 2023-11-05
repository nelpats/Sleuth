package fr.nelpats.model.detection.methods;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Csv extends DetectionMethod {

    private double[] inputData;
    private static final String CSV_FILE_PATH = "click_data.csv";

    public Csv() {
        super("Csv");
    }

    @Override
    public boolean getDetection() {
        File file = new File("click_data.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);

            writer.writeNext(new String[]{"clicks"});
            for (double dataPoint : inputData) {
                writer.writeNext(new String[]{String.valueOf(dataPoint)});
            }

            System.out.println("CSV file written to disk");
            writer.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }
    @Override
    public void setData(double[] inputData) {
        this.inputData = inputData;
    }
}
