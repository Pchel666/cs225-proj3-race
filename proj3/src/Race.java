import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used by the RaceGUI class
 * @author Syed Gilani, Cory Skinner, Alex Popov
 * @version 3.11.16
 */
public class Race {
    private Map map;
    private Random rand;
    private ArrayList<Location> cities;
    private Car[] cars;
    private int mapSize;
    /**
     * this is the constructor for the race class it takes a map size
     * @param mapSize the size of the map
     */
    public Race(int mapSize) {
        rand = new Random();
        cars = new Car[4];
        this.mapSize = mapSize;

        this.map = new Map(mapSize);
        cities = map.getCities(); //returns 4 cities
        ArrayList<Location> citiesTemp = (ArrayList<Location>) cities.clone();
        int temp;
        for(int i=0; i< cars.length; i++) {
            temp = rand.nextInt(citiesTemp.size());

            cars[i] = new Car(citiesTemp.get(temp).getXCoord(),
                    citiesTemp.get(temp).getYCoord(), createCarColor(),
                    name(i), selectTire(), createPath() );
            cars[i].setPosX(map.getCities().get(cars[i].destination()).getXCoord());
            cars[i].setPosY(map.getCities().get(cars[i].destination()).getYCoord());

            cars[i].setPath(createPath());

            citiesTemp.remove(temp);
        }
    }
    /**
     * Create the a path
     * @return an array of int.
     */
    public int[] createPath(){

        int temp, swap;

        int[] path = new int[4];
        path[0] = 0;
        path[1] = 1;
        path[2] = 2;
        path[3] = 3;

        for( int i = 0; i < 4; i++ ){
            swap = Math.abs(rand.nextInt()%4);
            temp = path[swap];
            path[swap] = path[i];
            path[i] = temp;
        }

        return path;
    }
    /**
     * Get the map size
     * @return the map
     */
    public Map getMap() {
        return map;
    }
    
    /**
     * Get the car Size
     * @return car size
     */
    public Car[] getCars() {
        return cars;
    }
    /**
     * Get the map size
     * @return map size
     */
    public int getMapSize() {
        return mapSize;
    }
    /**
     * Get the cities
     * @return a list of cities
     */
    public ArrayList<Location> getCities() {
        return cities;
    }


    public void moveXY(int carNumber, int x, int y) {
        cars[carNumber].setPosX(x);
        cars[carNumber].setPosY(y);
    }
    /**
     * Move the car
     */
    public void moveCar(int carNumber, Location destinationCity){
        int x0 = cars[carNumber].getPosX();
        int y0 = cars[carNumber].getPosY();
        int x1 = destinationCity.getXCoord();
        int y1 = destinationCity.getYCoord();

        boolean steep = Math.abs(y1 - y0) > Math.abs(x1 - x0);
        if (steep) {
            int t;
            // swap(x0, y0);
            t = x0;
            x0 = y0;
            y0 = t;
            // swap(x1, y1);
            t = x1;
            x1 = y1;
            y1 = t;
        }
        if (x0 > x1) {
            int t;
            // swap(x0, x1);
            t = x0;
            x0 = x1;
            x1 = t;

            // swap(y0, y1);
            t = y0;
            y0 = y1;
            y1 = t;
        }
        int deltax = x1 - x0;
        int deltay = Math.abs(y1 - y0);
        int error = deltax / 2;
        int ystep;
        int y = y0;
        if (y0 < y1)
            ystep = 1;
        else
            ystep = -1;

        for (int x = x0; x < x1; x++) {
            if (steep){
                moveXY(carNumber, y, x);
                System.out.println(x + "steep");
            }
            else {
                moveXY(carNumber, x, y);
                System.out.println("not steep");
            }
            error = error - deltay;
            if (error < 0) {
                y = y + ystep;
                error = error + deltax;
            }
        }
    }
    /**
     * Create a Car color
     */
    private Color createCarColor() {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);

        return Color.rgb(r, g, b );
    }
    /**
     * Create a name for the car
     */
    private String name(int carCount) {
        return "Car_" + carCount;
    }
    /**
     * Select the tires for the car
     */
    private String selectTire() {
        int value = rand.nextInt(3);
        String type = "";
        switch (value) {
            case 0: type = "Regular"; break;
            case 1:type = "Dirt"; break;
            case 2: type = "Snow"; break;
            default: System.out.println("Error: expecting integer 0-2"); break;
        }
        return type;
    }
}
