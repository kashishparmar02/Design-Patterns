package structural.adapter.adapters;

import structural.adapter.adaptees.MapBoxSDK;
import structural.adapter.target.MapService;

/**
 * Adapter class that implements MapService interface using MapBoxSDK.
 * Wraps the MapBox SDK to conform to the MapService contract.
 */
public class MapBoxAdapter implements MapService {
    private MapBoxSDK mapBoxSDK;
    
    /**
     * Constructor that initializes the MapBox SDK with access token.
     * @param accessToken MapBox access token for authentication
     */
    public MapBoxAdapter(String accessToken) {
        this.mapBoxSDK = new MapBoxSDK(accessToken);
    }

    @Override
    public String findLocation(String searchQuery) {
        try {
            return mapBoxSDK.searchLocation(searchQuery);
        } catch (Exception e) {
            return "MapBoxError: " + e.getMessage();
        }
    }

    @Override
    public String getRouteInfo(String pickup, String destination) {
        try {
            return mapBoxSDK.getNavigationRoute(pickup, destination);
        } catch (Exception e) {
            return "MapBoxError: " + e.getMessage();
        }
    }

    @Override
    public String getProviderName() {
        return "MapBox";
    }
}
