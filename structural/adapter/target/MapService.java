package structural.adapter.target;

/**
 * Target interface for map services in the Adapter pattern.
 * Defines the contract that all map service implementations must follow.
 */
public interface MapService {
    /**
     * Finds the location coordinates for a given search query.
     * @param searchQuery The location to search for
     * @return Location information as a string
     */
    String findLocation(String searchQuery);
    
    /**
     * Gets route information between two points.
     * @param pickup Starting location
     * @param destination End location
     * @return Route information as a string
     */
    String getRouteInfo(String pickup, String destination);
    
    /**
     * Returns the name of the map service provider.
     * @return Provider name
     */
    String getProviderName();
}
