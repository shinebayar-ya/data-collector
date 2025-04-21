package mn.and.datacollector.exception.mapper;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import mn.and.datacollector.model.response.ApiResponse;
import mn.and.datacollector.util.Translator;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

  @Inject
  Translator translator;

  private static final Logger LOG = Logger.getLogger(RuntimeExceptionMapper.class);

  @Override
  public Response toResponse(RuntimeException exception) {

    LOG.error("Internal server error", exception);
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .type(MediaType.APPLICATION_JSON)
        .entity(
            ApiResponse.builder()
                .key("INTERNAL_SERVER_ERROR")
                .code(99)
                .message(
                    exception.getMessage() != null
                        ? translator.translate(exception.getMessage())
                        : translator.translate("runtime.internal_server_error"))
                .build())
        .build();
  }
}
