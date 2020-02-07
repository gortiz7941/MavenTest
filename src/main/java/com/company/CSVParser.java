package com.company;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

  private List fileRows = new ArrayList();

  public CSVParser(String infile) throws IOException, CsvValidationException {
    if (checkFile(infile)){
      readCSV(infile);
    }
  }

  protected void readCSV(String csvinfile) throws IOException, CsvValidationException {
    FileInputStream csvStream = new FileInputStream(csvinfile);
    InputStreamReader inputStream = new InputStreamReader(csvStream,
        StandardCharsets.UTF_8);
    CSVReader reader = new CSVReader(inputStream);

    String[] nextLine;
    while ((nextLine = reader.readNext()) != null) {
      fileRows.add(nextLine);
    }
    reader.close();
  }

  protected void writeCsv(String csvoutfile) {
    //place holder for future use
  }

  protected void printCsv() {
    // printCsv prints out the csv data

    for (Object row : fileRows) {
      for (String fields : (String[]) row) {
        System.out.print(fields + ", ");
      }
      System.out.println("\b\b\n---------------------");
    }
  }

  private boolean checkFile(String csvfile) {
    if (!Files.exists(Paths.get(csvfile))) {
      System.out.println("File does not exist");
      return false;
    }
    return true;
  }
}
