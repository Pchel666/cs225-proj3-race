import java.util.ArrayList;
import java.util.Random;

public class Map {
    private int[][] locations;
    private Random rand;
    private static final int numOfTerrain = 3;

    public Map(int size) {
        rand = new Random();
        this.locations = new int[size][size];
        for(int i = 0; i < locations.length; i++) {
            for(int j = 0; j < locations[i].length; j++) {
                locations[i][j] = rand.nextInt(numOfTerrain);
            }
        }
    }

    public int[][] getLocations() {
        return locations;
    }
}
