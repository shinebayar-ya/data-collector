package mn.and.datacollector.service.client;

import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import mn.and.datacollector.client.MLClient;
import mn.and.datacollector.client.model.request.BankStatementRequest;

public class MLClientService {
  @RestClient
  private MLClient client;

  /**
   * Executes the ML API with the provided request.
   *
   * @param request the request containing the necessary data
   * @return a Response object containing the result of the execution
   */
  public Response execute(BankStatementRequest request) {
    return client.execute(request);
  }
}
