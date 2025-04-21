package mn.and.datacollector.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ExcelFileReaderService extends BaseFileReaderService {

  public ExcelFileReaderService(@ConfigProperty(name = "input.folder.path") String folderPath) {
    super(folderPath);
  }

  @Override
  protected List<String[]> readCsvFile(String filename) {
    throw new UnsupportedOperationException("CSV reading is not supported in ExcelFileReaderService.");
  }

  @Override
  protected List<String[]> readExcelFile(String filename) {
    File inputFile = new File(getFolder(), filename);
    List<String[]> data = new ArrayList<>();
    try (FileInputStream fileInputStream = new FileInputStream(inputFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {
      Sheet sheet = workbook.getSheetAt(0); // Read the first sheet
      for (Row row : sheet) {
        List<String> rowData = new ArrayList<>();
        for (Cell cell : row) {
          rowData.add(cell.toString()); // Add cell data to row
        }
        data.add(rowData.toArray(new String[0])); // Convert list to array and add to data
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to read Excel file: " + inputFile.getAbsolutePath(), e);
    }
    return data;
  }
}
