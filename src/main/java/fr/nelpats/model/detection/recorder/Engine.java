package fr.nelpats.model.detection.recorder;

import java.io.*;
import java.util.Date;

import fr.nelpats.Constants;
import com.opencsv.CSVWriter;
import fr.nelpats.model.detection.methods.IsolationForest;

public class Engine {



        private double[] data = new double[Constants.MAX_SAMPLE];

        private IsolationForest isolationForest;

        private int index = 0;
        public Engine() {

        }


    public void writeToCSVFile() {
        try (FileWriter fileWriter = new FileWriter(Constants.FILE_PATH + new Date().getTime() + ".csv");
             CSVWriter csvWriter = new CSVWriter(fileWriter)) {

            for (double value : this.data) {
                String[] rowData = {String.valueOf(value)};
                csvWriter.writeNext(rowData);
            }

            System.out.println("Array successfully written to CSV file: " + Constants.FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing the array to CSV file: " + e.getMessage());
        }
    }


        public void setData(int value) throws Exception {
            this.index += 1;
            System.out.println("Index: " + this.index);
            if (this.index < Constants.MAX_SAMPLE) {
                this.data[this.index] = value;
            } else {
                this.isolationForest = new IsolationForest(this.data);
                this.isolationForest.getDetection();
                this.index = 0;
            }


        }

}
