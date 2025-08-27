package structural.adapter;

import structural.adapter.adapters.GoogleMapsAdapter;
import structural.adapter.adapters.MapBoxAdapter;
import structural.adapter.client.FoodDeliveryService;
import structural.adapter.target.MapService;

/**
 * Demonstrates the Adapter Design Pattern implementation.
 * Shows how different map service providers can be integrated
 * into a food delivery system through adapters.
 */
public class AdapterDemo {
    
    public static void main(String[] args) {
        System.out.println("Starting Food Delivery Service");
        System.out.println("--------------------------------");

        // Initialize map service adapters with API keys
        String googleMapsApiKey = Config.GOOGLE_MAPS_API_KEY;
        String mapboxAccessToken = Config.MAPBOX_ACCESS_TOKEN;
        
        MapService googleMaps = new GoogleMapsAdapter(googleMapsApiKey);
        MapService mapBox = new MapBoxAdapter(mapboxAccessToken);

        // Create food delivery service with Google Maps as default provider
        FoodDeliveryService zomato = new FoodDeliveryService(googleMaps);

        // Test restaurant search and route planning
        zomato.findRestaurent("Pizza Hut");
        zomato.getDeliveryRoute("Pizza Hut", "Vastrapur, Ahmedabad");

        // Test error handling with empty input
        System.out.println("=== TESTING ERROR HANDLING ===");
        zomato.findRestaurent(""); 

        // Demonstrate dynamic provider switching
        System.out.println("--------------------------------");
        System.out.println("Switching to MapBox as Google Maps is down temporarily");
        System.out.println("--------------------------------");

        zomato.SwitchMapsProvider(mapBox);
        zomato.findRestaurent("McDonald's");
        zomato.getDeliveryRoute("McDonald's", "The first building, Ahmedabad");
    }
}
