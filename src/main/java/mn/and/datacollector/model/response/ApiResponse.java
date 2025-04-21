package mn.and.datacollector.model.response;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@RegisterForReflection
public class ApiResponse<T> {
  private String key;
  private Integer code;
  private String message;
  private T response;
}
