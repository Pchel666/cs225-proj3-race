import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;

public class Race {
    private Map map;
    private Random rand;
    private ArrayList<Location> cities;
    private Car[] cars;
    private int mapSize;

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
            cars[i] = new Car(citiesTemp.get(temp).getXCoord(), citiesTemp.get(temp).getYCoord(), createCarColor(), name(i), selectTire());
            citiesTemp.remove(temp);
        }
    }

    public Map getMap() {
        return map;
    }

    public Car[] getCars() {
        return cars;
    }

    //carNumber pick 1-4
    public void setCarsXLocation(int carNumber, int x) {
        cars[carNumber + 1].setPosX(x);
    }
    public void setCarsYLocation(int carNumber, int y) {
        cars[carNumber + 1].setPosY(y);
    }

    public int getMapSize() {
        return mapSize;
    }

    public ArrayList<Location> getCities() {
        return cities;
    }

    //get the cars starting point
    //then where it is suppose to be going
    //map out the route the car is suppose to be taking
    //

    public void moveCar(int carNumber) {
        int x = cars[carNumber + 1].getPosX();
        int y = cars[carNumber + 1].getPosY();

        //work on
        setCarsXLocation(carNumber, x + cars[carNumber + 1].getMaxSpeed());
        setCarsYLocation(carNumber, y + cars[carNumber + 1].getMaxSpeed());
    }

    private Color createCarColor() {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);

        return Color.rgb(r, g, b );
    }

    private String name(int carCount) {
        return "Car_" + carCount;
    }

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
