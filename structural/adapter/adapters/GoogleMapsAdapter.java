package structural.adapter.adapters;

import structural.adapter.adaptees.GoogleMapsSDK;
import structural.adapter.target.MapService;

/**
 * Adapter class that implements MapService interface using GoogleMapsSDK.
 * Wraps the Google Maps SDK to conform to the MapService contract.
 */
public class GoogleMapsAdapter implements MapService {
    private GoogleMapsSDK googleMapsSDK;

    /**
     * Constructor that initializes the Google Maps SDK with API key.
     * @param apiKey Google Maps API key for authentication
     */
    public GoogleMapsAdapter(String apiKey) {
        this.googleMapsSDK = new GoogleMapsSDK(apiKey);
    }

    @Override
    public String findLocation(String searchQuery) {
        try {
            return googleMapsSDK.geocodePlace(searchQuery);
        } catch (Exception e) {
            return "Google MapsError: " + e.getMessage();
        }
    }

    @Override
    public String getRouteInfo(String pickup, String destination) {
        try {
            return googleMapsSDK.calculateDirections(pickup, destination);
        } catch (Exception e) {
            return "Google MapsError: " + e.getMessage();
        }
    }

    @Override
    public String getProviderName() {
        return "Google Maps";
    }
}
