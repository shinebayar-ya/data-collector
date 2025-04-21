package mn.and.datacollector.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import mn.and.datacollector.model.response.ApiResponse;
import mn.and.datacollector.service.DataCollectorService;

@Path("/execute")
public class DataCollectorResource {

  @Inject
  DataCollectorService service;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response execute() {
    service.execute();
    return Response.ok()
        .entity(
            ApiResponse.builder()
                .key("SUCCESS")
                .code(0)
                .message("Data collector executed successfully")
                .response(null)
                .build())
        .build();
  }
}
