package com.yusuf.entity;


import java.util.List;

public class HourlyUnits {
    public String time;
    public String temperature_2m;
    public String rain;
    public String wind_speed_10m;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(String temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getWind_speed_10m() {
        return wind_speed_10m;
    }

    public void setWind_speed_10m(String wind_speed_10m) {
        this.wind_speed_10m = wind_speed_10m;
    }
}
