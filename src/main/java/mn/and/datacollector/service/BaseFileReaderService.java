package mn.and.datacollector.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public abstract class BaseFileReaderService extends BaseFileService {

  public BaseFileReaderService(@ConfigProperty(name = "input.folder.path") String folderPath) {
    super(folderPath);
  }

  // General method to read files (delegates to specific file types like CSV or Excel)
  public List<String[]> readFile(String filename) {
    if (filename.endsWith(".csv")) {
      return readCsvFile(filename);
    } else if (filename.endsWith(".xlsx")) {
      return readExcelFile(filename);
    } else {
      throw new IllegalArgumentException("Unsupported file type: " + filename);
    }
  }

  // Abstract methods for reading specific file types
  protected abstract List<String[]> readCsvFile(String filename);

  protected abstract List<String[]> readExcelFile(String filename);
}
