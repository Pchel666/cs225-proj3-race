import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Race {
    private HashMap<Car, Location> carAndLocation;
    private Map map;
    private Random rand;
    private ArrayList<Location> cities;
    private Car[] cars;

    public Race(int numberOfCars) {
        rand = new Random();
        cars = new Car[numberOfCars];

        this.map = new Map(10);
        cities = map.getCities(); //returns 4 cities
        ArrayList<Location> citiesTemp = cities;
        this.carAndLocation = new HashMap<Car, Location>();
        int temp;
        for(int i=0; i< cars.length; i++) {
            temp = rand.nextInt(citiesTemp.size());
            cars[i] = new Car(createCarColor(), name(i), selectTire());
            carAndLocation.put(cars[i], citiesTemp.get(temp));
            citiesTemp.remove(temp);
        }
    }

    //TODO ADD MORE METHODS
    
    public HashMap<Car, Location> getCarAndLocation() { return carAndLocation; }

    //carNumber pick 1-4
    public void setCarsLocation(int carNumber, int x, int y) {
        carAndLocation.get(cars[carNumber + 1]).setXCoord(x);
        carAndLocation.get(cars[carNumber + 1]).setYCoord(y);
    }

    private Color createCarColor() {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);

        return new Color(r, g, b);
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
