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

    public Car(){
        posX = 1;
        posY = 1;
        color = Color.BLUE;
        name = "testCar";
        tire = "Regular";
        maxSpeed = 3;
    }

    public Car(int posX, int posY, Color color, String name, String tire){
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.name = name;
        this.tire = tire;

        switch (tire) {
            case "Regular": maxSpeed = 3; break;
            case "Dirt": maxSpeed = 2; break;
            case "Snow": maxSpeed = 2; break;
            default: System.out.println("Error: expecting Regular, Dirt, or Snow."); break;
        }
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public int getPosY(){
        return posY;
    }

    public void setPosY(int posX){
        this.posY = posY;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTire(){
        return tire;
    }

    public void setTire(String tire){
        this.tire = tire;
    }

    public void move(int displacementX, int displacementY) {
        posX = posX + displacementX;
        posY = posY + displacementY;
    }
}
