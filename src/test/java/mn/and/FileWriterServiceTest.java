package mn.and;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.BeforeEach;

// @QuarkusTest
class FileWriterServiceTest {

  private File outputFolder;

  @BeforeEach
  void setup() throws Exception {
    // Use a temp folder for output
    outputFolder = Files.createTempDirectory("test-output").toFile();
    // fileWriterService.folderPath = outputFolder.getAbsolutePath();
  }

  // @Test
  void shouldWriteFileInOutputFolder() throws Exception {
    String testFilename = "output.json";
    String testContent = "{\"message\": \"hello\"}";

    // fileWriterService.writeFile(testFilename, testContent);

    File writtenFile = new File(outputFolder, testFilename);
    assertTrue(writtenFile.exists(), "File should exist after writing");

    String content = Files.readString(writtenFile.toPath());
    assertEquals(testContent, content);
  }
}
