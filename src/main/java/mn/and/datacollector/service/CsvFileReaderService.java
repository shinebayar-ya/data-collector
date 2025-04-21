package mn.and.datacollector.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@ApplicationScoped
public class CsvFileReaderService extends BaseFileReaderService {

  public CsvFileReaderService(@ConfigProperty(name = "input.folder.path") String folderPath) {
    super(folderPath);
  }

  @Override
  protected List<String[]> readCsvFile(String filename) {
    File inputFile = new File(getFolder(), filename);
    List<String[]> data = new ArrayList<>();
    try (CSVReader csvReader = new CSVReader(new FileReader(inputFile))) {
      String[] row;
      while ((row = csvReader.readNext()) != null) {
        data.add(row);
      }
    } catch (IOException | CsvException e) {
      throw new RuntimeException("Failed to read CSV file: " + inputFile.getAbsolutePath(), e);
    }
    return data;
  }

  @Override
  protected List<String[]> readExcelFile(String filename) {
    throw new UnsupportedOperationException("Excel reading is not supported in CsvFileReaderService.");
  }
}
