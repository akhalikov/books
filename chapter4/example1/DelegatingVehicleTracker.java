package chapter4.example1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * VehicleTracker using delegation to a thread safe class.
 * Monitor synchronization is replaced with ConcurrentMap.
 * Class MutablePoint replaced with immutable class Point.
 * Locations map is published safely as static unmodifiable copy.
 * 
 * Created by Artur on 28-Dec-14.
 */
public class DelegatingVehicleTracker {

    private final ConcurrentMap<String, Point> locations;

    public DelegatingVehicleTracker(ConcurrentMap<String, Point> locations) {
        this.locations = locations;
    }

    /**
     * Return static copy of the locations map with immutable content.
     *  
     * @return Locations map
     */
    public Map<String, Point> getLocations() {
        return Collections.unmodifiableMap(
                new HashMap<String, Point>(locations));
    }
    
    public Point getLocation(String id) {
        return locations.get(id);        
    }
    
    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("Invalid vehicle name: " + id);
        }
    }
}
