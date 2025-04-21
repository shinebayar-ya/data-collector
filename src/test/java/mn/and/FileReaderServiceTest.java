package mn.and;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;

// @QuarkusTest
class FileReaderServiceTest {

  @BeforeEach
  void setup() throws Exception {
    // Override input folder for testing
    URL resource = getClass().getClassLoader().getResource("test-input");
    assertNotNull(resource, "Test input folder not found!");
    // fileReaderService.folderPath = new File(resource.toURI()).getAbsolutePath();
  }

  // @Test
  void shouldListFilesInInputFolder() {
  }
}
