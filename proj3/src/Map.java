import java.util.ArrayList;

public class Map {
    private ArrayList<Location> locations;
    private int size;

    public Map(ArrayList<Location> locations, int size) {
        this.locations = new ArrayList<Location>();
        this.size = size;
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
}
