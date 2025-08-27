package structural.adapter.adaptees;

import java.util.Random;

/**
 * Simulates the MapBox SDK that would be used in production.
 * This is the adaptee class that the MapBoxAdapter wraps.
 */
public class MapBoxSDK {
    private String accessToken;
    private Random random = new Random();
    
    /**
     * Constructor that stores the access token for authentication.
     * @param accessToken MapBox access token
     */
    public MapBoxSDK(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Searches for a location and returns coordinates.
     * @param query Location search query
     * @return Coordinates as a formatted string
     * @throws IllegalArgumentException if query is null or empty
     */
    public String searchLocation(String query) {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query cannot be null or empty");
        }

        return "MapBox SDK:Latitude: " + random.nextDouble() + ", Longitude: " + random.nextDouble();
    }

    /**
     * Gets navigation route between two points.
     * @param startPoint Starting location
     * @param endPoint Destination location
     * @return Route information as a formatted string
     * @throws IllegalArgumentException if points are null or empty
     */
    public String getNavigationRoute(String startPoint, String endPoint) {
        if (startPoint == null || endPoint == null || startPoint.trim().isEmpty() || endPoint.trim().isEmpty()) {
            throw new IllegalArgumentException("Start and End points cannot be null or empty");
        }
        double distance = random.nextDouble() * 100;
        return "MapBox SDK:Navigation route from " + startPoint + " to " + endPoint + " : " + distance + " km";
    }
}
