package com.yusuf.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.yusuf.entity.WeatherResults;
import com.yusuf.services.GeoLocationService;

@Path("/weather")
public class WeatherDetectionController {
  
  @GET
  @Path("/1")
  @Produces(MediaType.APPLICATION_JSON)
  public String getTemperature() {
    return "{\"temperature\":\"20 degrees\"}";
  }
  
  @GET
  @Path("/2")
  @Produces(MediaType.APPLICATION_JSON)
  public String getTemperature2() {
    return "{\"temperature\":\"20 degrees\"}"; 
  }
  
  GeoLocationService apiService = new GeoLocationService();
  
  @GET
  @Path("/geolocation")
  @Produces(MediaType.APPLICATION_JSON)
  public Response searchLocation(@QueryParam("name") String name, @QueryParam("count") int count) throws IOException, InterruptedException {
	  try {
           
          Response result = apiService.searchLocationByCityName(name, count);
          return result;
      } catch (IOException | InterruptedException e) {
          e.printStackTrace();
          return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                         .entity("Error accessing external service: " + e.getMessage())
                         .build();
      }
  } 
}