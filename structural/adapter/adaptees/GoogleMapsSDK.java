package structural.adapter.adaptees;

import java.util.Random;

/**
 * Simulates the Google Maps SDK that would be used in production.
 * This is the adaptee class that the GoogleMapsAdapter wraps.
 */
public class GoogleMapsSDK {
    private String apiKey;
    private Random random = new Random();

    /**
     * Constructor that stores the API key for authentication.
     * @param apiKey Google Maps API key
     */
    public GoogleMapsSDK(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Converts a place name to coordinates (geocoding).
     * @param place Name of the place to geocode
     * @return Coordinates as a formatted string
     * @throws IllegalArgumentException if place is null or empty
     */
    public String geocodePlace(String place) {
        if (place == null || place.trim().isEmpty()) {
            throw new IllegalArgumentException("Place cannot be null or empty");
        }
        return "Google Maps SDK:Latitude: " + random.nextDouble() + ", Longitude: " + random.nextDouble();
    }

    /**
     * Calculates directions between two locations.
     * @param from Starting location
     * @param to Destination location
     * @return Route information as a formatted string
     * @throws IllegalArgumentException if locations are null or empty
     */
    public String calculateDirections(String from, String to) {
        if (from == null || to == null || from.trim().isEmpty() || to.trim().isEmpty()) {
            throw new IllegalArgumentException("From and To cannot be null or empty");
        }
        double distance = random.nextDouble() * 100;
    
        return "Google Maps SDK:Directions from " + from + " to " + to + " : " + distance + " km";
    }
}
