package com.yusuf.entity;
import java.util.List;

public class GeoLocation { 
    List<Location> results;
    
    public List<Location> getResults() {
        return results;
    }

    public void setResults(List<Location> results) {
        this.results = results;
    }

    public static class Location {
        int id;
        String name;
        double latitude;
        double longitude;
 
        public String getName() {
			return name;
		}

		public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
        
    }
    
    
}

