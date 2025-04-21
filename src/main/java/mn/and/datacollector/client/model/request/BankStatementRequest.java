package mn.and.datacollector.client.model.request;

import java.nio.file.Path;

import jakarta.ws.rs.FormParam;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@RegisterForReflection
@Data
public class BankStatementRequest {
  @FormParam("userBankStatementFile")
  private Path userBankStatementFile;

  @FormParam("relatedAccountFile")
  private Path relatedAccountFile;
}
