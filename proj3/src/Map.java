import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used to create a map object with locations and cities randomly placed on it.
 * The locations on the map are assigned 3 types of terrain or a city, the key is below.
 * locations: int[][], one of four values:
 * 0 = Regular
 * 1 = Dirt
 * 2 = Snow
 * 3 = City
 * @author Syed Gilani, Cory Skinner, Alex Popov
 * @version 3.11.16
 */
public class Map {
    private int[][] locations;
    private Random rand;
    private ArrayList<Location> cities;
    private static final int numOfTerrain = 3;

    /**
     * The Map constructor take a map size that is squared to create the map.
     * @param size the size of the map
     */
    public Map(int size) {
        rand = new Random();
        this.locations = new int[size][size];
        for(int i = 0; i < locations.length; i++) {
            for(int j = 0; j < locations[i].length; j++) {
                locations[i][j] = rand.nextInt(numOfTerrain);
            }
        }
        makeFourCities(size);
    }

    /**
     * Get locations on the map
     * @return an int[][], get location of cities
     */
    public int[][] getLocations() { return locations; }
    public ArrayList<Location> getCities() {
        return cities;
    }

    /**
     * Add four cities to the Map
     * @param size the size in the map
     */
    private void makeFourCities(int size) {
        int x;
        int y;
        int halfSize = size/2;
        cities = new ArrayList<Location>();
        //Split into four quadrants
        // 5, 5
        x = rand.nextInt(halfSize);
        y = rand.nextInt(halfSize);
        locations[x][y] = 3;
        cities.add(new Location(x, y, "CityA"));
        // 10, 5
        x = rand.nextInt(halfSize) + halfSize;
        y = rand.nextInt(halfSize);
        locations[x][y] = 3;
        cities.add(new Location(x, y, "CityB"));
        // 5, 10
        x = rand.nextInt(halfSize);
        y = rand.nextInt(halfSize) + halfSize;
        locations[x][y] = 3;
        cities.add(new Location(x, y, "CityC"));
        // 10, 10
        x = rand.nextInt(halfSize) + halfSize;
        y = rand.nextInt(halfSize) + halfSize;
        locations[x][y] = 3;
        cities.add(new Location(x, y, "CityD"));
    }
}
