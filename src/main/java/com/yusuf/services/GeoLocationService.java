package com.yusuf.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.yusuf.entity.GeoLocation;
import com.yusuf.entity.WeatherResult;
import com.yusuf.entity.WeatherResults;

public class GeoLocationService {

	private Gson gson = new Gson();
	
	public Response searchLocationByCityName(String name, int count) throws IOException, InterruptedException {
		String apiUrl = buildUrl(name, count);
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).header("Accept", "application/json")
					.GET().build();

			HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			if (httpResponse.statusCode() == 200) {
				String weatherResponse = httpResponse.body().toString();
				GeoLocation geoLocation = gson.fromJson(httpResponse.body(), GeoLocation.class);
	                // Process all locations to build a response or further API calls
	                //StringBuilder coordinatesResponse = new StringBuilder();
	               // List<GeoLocation.Location> listOfLocation = new ArrayList<>();
	                /*for (GeoLocation.Location location : geoLocation.getResults()) {
	                	System.out.println(" 36 -->>  "+String.format("Location: %s, Latitude: %f, Longitude: %f\n", location.getName(), location.getLatitude(), location.getLongitude()));
	                    //coordinatesResponse.append(String.format("Location: %s, Latitude: %f, Longitude: %f\n", location.getName(), location.getLatitude(), location.getLongitude()));
	                    // Optionally, call another API for each location here or collect data to do so later
	                	
	                	listOfLocation.add(location);
	                }*/
				System.out.println("  coordinatesResponse.toString()  1 "+geoLocation.getResults().size());
	                return Response.ok(gson.toJson(geoLocation.getResults())).build();
			} else {
				return Response.status(Response.Status.fromStatusCode(httpResponse.statusCode()))
						.entity("Failed to fetch data: " + httpResponse.body()).build();
			}
		} catch (IOException | InterruptedException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Error accessing external service: " + e.getMessage()).build();
		}
	}

	private String buildUrl(String name, int count) {
		return String.format("https://geocoding-api.open-meteo.com/v1/search?name=%s&count=%d&language=en&format=json",
				name, count);
	}
}
