package mn.and.datacollector.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jakarta.enterprise.context.ApplicationScoped;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ExcelFileWriterService extends BaseFileWriterService {

  public ExcelFileWriterService(@ConfigProperty(name = "output.folder.path") String folderPath) {
    super(folderPath);
  }

  @Override
  protected void writeCsvFile(String filename, String content) {
    throw new UnsupportedOperationException("CSV writing is not supported in ExcelFileWriterService.");
  }

  @Override
  protected void writeExcelFile(String filename, String content) {
    File outputFile = new File(getFolder(), filename);

    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
      Sheet sheet = workbook.createSheet("Sheet1");
      Row row = sheet.createRow(0);
      // Assuming content is comma-separated
      String[] rowData = content.split(",");
      for (int i = 0; i < rowData.length; i++) {
        row.createCell(i).setCellValue(rowData[i]);
      }

      try (FileOutputStream fileOut = new FileOutputStream(outputFile)) {
        workbook.write(fileOut);
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to write Excel file: " + outputFile.getAbsolutePath(), e);
    }
  }
}
