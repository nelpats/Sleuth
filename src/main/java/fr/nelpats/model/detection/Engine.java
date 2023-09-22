package fr.nelpats.model.detection;

import java.io.*;

import fr.nelpats.Constants;
import com.opencsv.CSVWriter;
public class Engine {



        private int[] data = new int[Constants.MAX_SAMPLE];
        public Engine() {

        }


    public void writeToCSVFile() {
        try (FileWriter fileWriter = new FileWriter(Constants.FILE_PATH);
             CSVWriter csvWriter = new CSVWriter(fileWriter)) {

            // Write the data to the CSV file
            for (int value : this.data) {
                String[] rowData = {String.valueOf(value)};
                csvWriter.writeNext(rowData);
            }

            System.out.println("Array successfully written to CSV file: " + Constants.FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing the array to CSV file: " + e.getMessage());
        }
    }


        public void setData(int value, int index) {

            if (index < Constants.MAX_SAMPLE) {
                this.data[index] = value;
            } else {
                this.writeToCSVFile();
            }


        }

}
