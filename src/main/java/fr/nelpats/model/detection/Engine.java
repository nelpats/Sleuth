package fr.nelpats.model.detection;

import java.io.*;
import java.util.Date;

import fr.nelpats.Constants;
import com.opencsv.CSVWriter;
public class Engine {



        private int[] data = new int[Constants.MAX_SAMPLE];

        private int index = 0;
        public Engine() {

        }


    public void writeToCSVFile() {
        try (FileWriter fileWriter = new FileWriter(Constants.FILE_PATH + new Date().getTime() + ".csv");
             CSVWriter csvWriter = new CSVWriter(fileWriter)) {

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


        public void setData(int value) {
            this.index += 1;
            System.out.println("Index: " + this.index);
            if (this.index < Constants.MAX_SAMPLE) {

                this.data[this.index] = value;
            } else {
                this.writeToCSVFile();
                this.index = 0;
            }


        }

}
