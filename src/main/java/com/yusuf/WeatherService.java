package com.yusuf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/weather")
public class WeatherService {
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getTemperature() {
    return "{\"temperature\":\"20 degrees\"}";
  }
}