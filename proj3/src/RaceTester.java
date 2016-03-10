import java.util.ArrayList;

/**
 * Created by Syed on 3/9/2016.
 */
public class RaceTester {
    public static void main(String[] args){
        Race race = new Race(20);

        ArrayList<Location> cities;
        cities = race.getCities();
        System.out.println("Cities: ");
        for (Location l : cities) {
            System.out.println("x: " + l.getXCoord() + " y: " + l.getYCoord() + " name: " + ";");
        }
        Car[] cars = race.getCars();
        System.out.println("Cars: ");
        for (int i = 0; i< cars.length; i++){
            System.out.println("x: " + cars[i].getPosX() + " y: " + cars[i].getPosY() + " color: " + cars[i].getColor() + " " + cars[i].getName() + " " + cars[i].getTire() + " " + cars[i].getMaxSpeed() + ";" );
        }

        System.out.println("Map size: " + race.getMapSize());

        Map map = race.getMap();
        System.out.println("The Map: ");
        int[][] loc = map.getLocations();
        for(int i = 0; i < loc.length; i++) {
            for(int j = 0; j < loc[i].length; j++) {
                System.out.print(loc[i][j]);
            }
            System.out.print("\n");
        }
    }
}
