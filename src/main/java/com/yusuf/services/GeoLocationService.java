package com.yusuf.services;

import com.google.gson.Gson;
import com.yusuf.entity.GeoLocation;
import com.yusuf.entity.WeatherResult;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GeoLocationService {

	private Gson gson = new Gson();
	
	public Response searchLocationByCityName(String name, int count) throws IOException, InterruptedException {
		String apiUrl = buildUrlForCity(name, count);
		try {
			List<GeoLocation.Location> latitudeAndLongitudeFromAPI = getLatitudeAndLongitudeFromAPI(apiUrl);

			if (latitudeAndLongitudeFromAPI.size() > 0) {
				 return Response.ok(gson.toJson(latitudeAndLongitudeFromAPI)).build();
			} else{
				return Response.serverError().build();
			}
		} catch (IOException | InterruptedException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Error accessing external service: " + e.getMessage()).build();
		}
	}

	private List<GeoLocation.Location> getLatitudeAndLongitudeFromAPI(String apiUrl) throws IOException, InterruptedException {
		HttpResponse<String> stringHttpResponse = callAPIForResponse(apiUrl);
		System.out.println("  40 GeoLocationService.java  stringHttpResponse statusCode --> " +stringHttpResponse.statusCode());
		if (stringHttpResponse.statusCode() == 200) {
			String weatherResponse = stringHttpResponse.body().toString();
			GeoLocation geoLocation = gson.fromJson(stringHttpResponse.body(), GeoLocation.class);

			System.out.println("  coordinatesResponse.toString()  1 " + geoLocation.getResults().size());
			return geoLocation.getResults();
		}
		return new ArrayList<>();
	}

	private HttpResponse<String> callAPIForResponse(String apiUrl) throws IOException, InterruptedException{
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).header("Accept", "application/json")
				.GET().build();

		HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(request,
				HttpResponse.BodyHandlers.ofString());
		return httpResponse;
	}
	public Response getTemparatureForCity(double latitude, double longitude)throws IOException, InterruptedException{
		String apiUrl = buildUrlForTemparature(latitude, longitude);
		HttpResponse<String> stringHttpResponse = callAPIForResponse(apiUrl);

		if (stringHttpResponse.statusCode() == 200) {
			System.out.println("  64 stringHttpResponse "+stringHttpResponse.body().toString());
			WeatherResult WeatherResult = gson.fromJson(stringHttpResponse.body(), WeatherResult.class);
			return Response.ok(gson.toJson(WeatherResult)).build();
		}
		return Response.serverError().build();
	}
	private String buildUrlForCity(String name, int count) {
		return String.format("https://geocoding-api.open-meteo.com/v1/search?name=%s&count=%d&language=en&format=json",
				name, count);
	}

	private String buildUrlForTemparature(double latitude, double longitude) {
		return String.format("https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&hourly=temperature_2m,rain,wind_speed_10m",
				latitude, longitude);
	}
}
