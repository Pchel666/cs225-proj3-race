/**
 * Created by Syed on 3/2/2016.
 */
public class Terrain {
    private String typeOfTerrain;
    private Location location;

    public Terrain(String typeOfTerrain, int xCoord, int yCoord){
        this.typeOfTerrain = typeOfTerrain;
        this.location =  new Location(xCoord, yCoord);
    }
}
//TO BE REMOVED
