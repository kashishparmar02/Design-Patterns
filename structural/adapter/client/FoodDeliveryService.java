package structural.adapter.client;

import structural.adapter.target.MapService;

/**
 * Client class that uses the MapService interface through the Adapter pattern.
 * Demonstrates how the client can work with different map service providers
 * without knowing their specific implementations.
 */
public class FoodDeliveryService {
    private MapService mapService;

    /**
     * Constructor that accepts any MapService implementation.
     * @param mapService The map service to use for location and routing
     */
    public FoodDeliveryService(MapService mapService) {
        this.mapService = mapService;
    }

    /**
     * Switches to a different map service provider at runtime.
     * @param newMapService The new map service to use
     */
    public void SwitchMapsProvider(MapService newMapService) {
        System.out.println("Switching to " + mapService.getProviderName() + " for map services");
        this.mapService = newMapService;
    }

    /**
     * Finds a restaurant using the current map service.
     * @param restaurantName Name of the restaurant to search for
     */
    public void findRestaurent(String restaurantName) {
        System.out.println("Finding restaurant: " + restaurantName);
        System.out.println("Using: " + mapService.getProviderName());
        String location = mapService.findLocation(restaurantName);
        System.out.println("Location: " + location);
        System.out.println("--------------------------------");
    }

    /**
     * Gets delivery route information between restaurant and user location.
     * @param restaurantName Name of the restaurant
     * @param userLocation User's delivery address
     */
    public void getDeliveryRoute(String restaurantName, String userLocation) {
        System.out.println("Planning delivery route");
        System.out.println(" Using: " + mapService.getProviderName());
        String route = mapService.getRouteInfo(restaurantName, userLocation);
        System.out.println("Route: " + route);
        System.out.println("--------------------------------");
    }
}
