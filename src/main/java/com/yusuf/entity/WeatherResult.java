package com.yusuf.entity;

import java.util.List;

public class WeatherResult {
    private String id;
    private String name;
    private String latitude;
    private String longitude;
    private String elevation;
    private String feature_code;
    private String country_code;
    private String admin1_id;
    private String admin3_id;
    private String admin4_id;
    private String timezone;
    private String population;
    private List<String> postCodes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getFeature_code() {
        return feature_code;
    }

    public void setFeature_code(String feature_code) {
        this.feature_code = feature_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getAdmin1_id() {
        return admin1_id;
    }

    public void setAdmin1_id(String admin1_id) {
        this.admin1_id = admin1_id;
    }

    public String getAdmin3_id() {
        return admin3_id;
    }

    public void setAdmin3_id(String admin3_id) {
        this.admin3_id = admin3_id;
    }

    public String getAdmin4_id() {
        return admin4_id;
    }

    public void setAdmin4_id(String admin4_id) {
        this.admin4_id = admin4_id;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<String> getPostCodes() {
        return postCodes;
    }

    public void setPostCodes(List<String> postCodes) {
        this.postCodes = postCodes;
    }
}