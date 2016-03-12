import javafx.scene.paint.*;
import javafx.scene.paint.Color;

import java.awt.*;

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
     * default constructor for Car
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
     * setup constructor for Car
     * @param posX x coordinates
     * @param posY y coordinates
     * @param color color of Car
     * @param name name of the car
     * @param tire type of tire
     * @param path path for the car
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
     * gets the max speed of the car
     * @return int
     */
    public int getMaxSpeed(){
        return maxSpeed;
    }

    /**
     * sets the maxspeed
     * @param maxSpeed int the new maxspeed
     */
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    /**
     * gets the x coordinates
     * @return
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