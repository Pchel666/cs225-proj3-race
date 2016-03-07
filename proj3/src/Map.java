import java.util.ArrayList;

public class Map {
    private ArrayList<Location> locations;
    private int size;
    private String terrain;

    public Map(ArrayList<Location> locations, int size, String terrain) {
        this.locations = new ArrayList<Location>();
        this.size = size;
        this.terrain = terrain;
    }

    public Location getLocation(int locationIndex) {
        return locations.get(locationIndex);
    }

//    public void setLocation(Location newLocation, int locationIndex){
//
//    }

    public int getSize() {
        return size;
    }

    public void setSize(int newSize) {
        this.size = newSize;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}
