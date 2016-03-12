/**
 * This class is used to create a Location of any object on a map.
 * @author Syed Gilani, Cory Skinner, Alex Popov
 * @version 3.11.16
 */
public class Location {
    private int xCoord;
    private int yCoord;
    private String name;

    /**
     * The constructor of the Location class.
     * @param xCoord sets the x coord
     * @param yCoord sets the y coord
     * @param name sets the name on the map
     */
    public Location(int xCoord, int yCoord, String name){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.name = name;
    }

    /**
     * Get the x coord of the object.
     * @return an int, the x coord
     */
    public int getXCoord(){
        return xCoord;
    }

    /**
     * Get the y coord of the object
     * @return an int, the y coord
     */
    public int getYCoord() {
        return yCoord;
    }

    /**
     * Get the name of the location
     * @return a String, the name of the location
     */
    public String getName() { return name; }

    public void setName(String newName) { name = newName; }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}