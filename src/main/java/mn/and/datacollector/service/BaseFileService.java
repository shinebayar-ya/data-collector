package mn.and.datacollector.service;

import java.io.File;

public abstract class BaseFileService implements FileService {

  protected String folderPath;

  protected BaseFileService(String folderPath) {
    this.folderPath = folderPath;
  }

  protected File getFolder() {
    File folder = new File(folderPath);
    if (!folder.exists() || !folder.isDirectory()) {
      throw new IllegalStateException("Folder does not exist or is not a directory: " + folderPath);
    }
    return folder;
  }
}
