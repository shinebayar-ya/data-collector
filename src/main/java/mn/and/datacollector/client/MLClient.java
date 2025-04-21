package mn.and.datacollector.client;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import mn.and.datacollector.client.model.request.BankStatementRequest;

@RegisterRestClient(configKey = "ml-service")
public interface MLClient {

  @ConfigProperty(name = "ml-service.endpoint", defaultValue = "/execute")
  String endpoint = "/execute";

  /**
   * Executes the ML API with the provided request.
   *
   * @param request the request containing the necessary data
   * @return a Response object containing the result of the execution
   */
  @POST
  @Path(endpoint)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  Response execute(@BeanParam BankStatementRequest request);
}
