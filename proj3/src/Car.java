import javafx.scene.paint.*;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * This class is used to create a Car class, which takes a maxSpeed, x postion, y postion, color, name, and a tire type.
 * @author Syed Gilani, Cory Skinner, Alex Popov
 * @version 3.11.16
 */
public class Car {
    private int maxSpeed;
    private int posX;
    private int posY;
    private Color color;
    private String name;
    private String tire;
    private int[] path;
    private int curr;

    /**
     * Car class constructor, used to create a test car.
     */
    public Car(){
        posX = 1;
        posY = 1;
        color = Color.BLUE;
        name = "testCar";
        tire = "Regular";
        maxSpeed = 3;
    }

    /**
     * Car class constructor
     * @param color color of the car
     * @param name name of the car
     * @param posX x position of the car
     * @param posY y position of the car
     * @param tire tire type of the car
     */
    public Car(int posX, int posY, Color color, String name,
               String tire, int[] path ){
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.name = name;
        this.tire = tire;
        this.path = path;
        curr = 0;

        switch (tire) {
            case "Regular": maxSpeed = 3; break;
            case "Dirt": maxSpeed = 2; break;
            case "Snow": maxSpeed = 2; break;
            default: System.out.println("Error: expecting Regular, Dirt, or Snow."); break;
        }
    }

    /**
     * Get the max speed of the car.
     * @return an int, representing speed of the car
     */
    public int getMaxSpeed(){
        return maxSpeed;
    }

    /**
     * Set the speed of the car.
     * @param maxSpeed the maxSpeed of the car
     */
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    /**
     * Get the x position of the car.
     * @return an int, the x position of the car
     */
    public int getPosX(){
        return posX;
    }

    /**
     * sets the X coordinates
     * @param posX
     */
    public void setPosX(int posX){
        this.posX = posX;
    }

    /**
     * gets the Y coordinates
     * @return int
     */
    public int getPosY(){
        return posY;
    }

    /**
     * sets the Y position
     * @param posY int
     */
    public void setPosY(int posY){
        this.posY = posY;
    }

    /**
     * gets the color of the car
     * @return Color
     */
    public Color getColor(){
        return color;
    }

    /**
     * sets the color of the Car
     * @param color
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * gets the name of the Car
     * @return String
     */
    public String getName(){
        return name;
    }

    /**
     * sets the name
     * @param name String
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getTire(){
        return tire;
    }

    /**
     * sets the tire type
     * @param tire String
     */
    public void setTire(String tire){
        this.tire = tire;
    }

    /**
     * resets the car's position
     * @param displacementX int, change in x position
     * @param displacementY int, change in y position
     */
    public void move(int displacementX, int displacementY) {
        posX = posX + displacementX;
        posY = posY + displacementY;
    }

    /**
     * sets the path the car will take
     * @param path int[]
     */
    public void setPath( int[] path ){

        this.path = path;
    }

    /**
     * gets the place where the car is going next
     * @return int
     */
    public int destination(){
        return path[curr];
    }

    /**
     * sets the current direction that the car will be going
     * @return boolean
     */
    public boolean setCurr(){
        curr++;
        if( curr >= path.length )
            return true;

        return false;
    }
}
