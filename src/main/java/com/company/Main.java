package com.company;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException {
        System.out.println("Hello, I work");
        CSVParser csvP = new CSVParser("src/Data/SEOExample.csv");
        csvP.printCsv();
    }
}
