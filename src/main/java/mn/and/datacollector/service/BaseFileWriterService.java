package mn.and.datacollector.service;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public abstract class BaseFileWriterService extends BaseFileService {

  public BaseFileWriterService(@ConfigProperty(name = "output.folder.path") String folderPath) {
    super(folderPath);
  }

  // General method to write files (delegates to specific file types like CSV or Excel)
  public void writeFile(String filename, String content) {
    if (filename.endsWith(".csv")) {
      writeCsvFile(filename, content);
    } else if (filename.endsWith(".xlsx")) {
      writeExcelFile(filename, content);
    } else {
      throw new IllegalArgumentException("Unsupported file type: " + filename);
    }
  }

  // Abstract methods for writing specific file types
  protected abstract void writeCsvFile(String filename, String content);

  protected abstract void writeExcelFile(String filename, String content);
}
