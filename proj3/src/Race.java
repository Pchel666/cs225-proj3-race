import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Race {
    private ArrayList<Car> cars;
    private Map map;
    private Random rand;

    public Race(int numberOfCars) {
        rand = new Random();
        this.cars = new ArrayList<Car>();
        for(int i=0; i< numberOfCars; i++) {
            cars.add(new Car(createCarColor(), name(i), selectEngine(), selectTire()));
        }
    }

    public enum Engine {
        SMALL, MEDIUM, LARGE
    }

    public enum Tire {
        DIRT, RAIN, REGULAR
    }

    private Color createCarColor() {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);

        return new Color(r, g, b);
    }

    private String name(int carCount) {
        return "Car_" + i;
    }

    //how many engines there are.
    public static final int engines = Engine.values().length;
    private String selectEngine() {
        int value = rand.nextInt(engines);
        String size = "";
        //there should be three engine types
        switch (value){
            case 1:
                size = "small";
                break;
            case 2:
                size = "medium";
                break;
            case 3:
                size = "large";
                break;
            default:
                // this should show an error message
                System.out.println("error");
                break;
        }
        return size;
    }

    public static final Tire[] tires = Tire.values();
    private String selectTire() {
        int value = rand.nextInt(tires.length);
        String type = "";
        //there should be three engine types
        switch (tires[value]) {
            case DIRT:
                type = "dirt";
                break;
            case RAIN:
                type = "rain";
                break;
            case REGULAR:
                type = "regular";
                break;
            default:
                // this should show an error message
                System.out.println("error");
                break;
        }
        return type;
    }
}
