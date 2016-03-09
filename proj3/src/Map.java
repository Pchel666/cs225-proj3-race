import java.util.ArrayList;
import java.util.Random;

/**
 * locations: int[][], one of four values:
 * 0 = Regular
 * 1 = Dirt
 * 2 = Snow
 * 3 = City
 */
public class Map {
    private int[][] locations;
    private Random rand;
    ArrayList<Location> cities;
    private static final int numOfTerrain = 3;

    public Map(int size) {
        rand = new Random();
        this.locations = new int[size][size];
        for(int i = 0; i < locations.length; i++) {
            for(int j = 0; j < locations[i].length; j++) {
                locations[i][j] = rand.nextInt(numOfTerrain);
            }
        }
        // For four quadrants
        int x;
        int y;
        int halfSize = size/2;
        cities = new ArrayList<Location>();

        // 5, 5
        x = rand.nextInt(halfSize + 1);
        y = rand.nextInt(halfSize + 1);
        locations[x][y] = 3;
        cities.add(new Location(x, y));
        // 10, 5
        x = rand.nextInt(halfSize + 1) + halfSize;
        y = rand.nextInt(halfSize + 1);
        locations[x][y] = 3;
        cities.add(new Location(x, y));
        // 5, 10
        x = rand.nextInt(halfSize + 1);
        y = rand.nextInt(halfSize + 1) + halfSize;
        locations[x][y] = 3;
        cities.add(new Location(x, y));
        // 10, 10
        x = rand.nextInt(halfSize + 1) + halfSize;
        y = rand.nextInt(halfSize + 1) + halfSize;
        locations[x][y] = 3;
        cities.add(new Location(x, y));
    }

    public int[][] getLocations() { return locations; }
    public ArrayList<Location> getCities() {
        return cities;
    }
}
