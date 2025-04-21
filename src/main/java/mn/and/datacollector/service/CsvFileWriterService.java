package mn.and.datacollector.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.opencsv.CSVWriter;

@ApplicationScoped
public class CsvFileWriterService extends BaseFileWriterService {

  public CsvFileWriterService(@ConfigProperty(name = "output.folder.path") String folderPath) {
    super(folderPath);
  }

  @Override
  protected void writeCsvFile(String filename, String content) {
    File outputFile = new File(getFolder(), filename);
    try (CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile))) {
      // Assuming content is a single CSV row, split by commas
      String[] row = content.split(",");
      csvWriter.writeNext(row);
    } catch (IOException e) {
      throw new RuntimeException("Failed to write CSV file: " + outputFile.getAbsolutePath(), e);
    }
  }

  @Override
  protected void writeExcelFile(String filename, String content) {
    throw new UnsupportedOperationException("Excel writing is not supported in CsvFileWriterService.");
  }
}
