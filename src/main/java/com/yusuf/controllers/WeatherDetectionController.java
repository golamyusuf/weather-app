package com.yusuf.controllers;

import com.yusuf.services.GeoLocationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/weather")
public class WeatherDetectionController {

    GeoLocationService apiService = new GeoLocationService();

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
        return "{\"temperature\":\"40 degrees\"}";
    }

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

    @GET
    @Path("/tempareture")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTemparatureByCity() {
        System.out.println("   60 WeatherDetectionController.java ");
        Response temparatureForCity = null;
        try {
             temparatureForCity = apiService.getTemparatureForCity(52.52, 13.419998);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return temparatureForCity;
    }
}