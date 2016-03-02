public class Car {
    private int maxSpeed;
    private int weight;
    private int posX;
    private int posY;
    private String color;
    private String name;
    private String engine;
    private String tire;

    public Car(){
        weight = 100;
        posX = 1;
        posY = 1;
        color = "blue";
        name = "car1";
        engine = "medium";
        tire = "regular";
        maxSpeed = 50;
        switch (engine.toLowerCase()){
            case "small":
                maxSpeed = maxSpeed + 10;
                break;
            case "medium":
                maxSpeed = maxSpeed + 20;
                break;
            case "large":
                maxSpeed = maxSpeed + 30;
                break;
            default:
                break;
        }
        maxSpeed = maxSpeed / (weight / 50);
    }

    public Car(int weight, int posX, int posY, String color, String name, String engine, String tire){
        this.weight = weight;
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.name = name;
        this.engine = engine;
        this.tire = tire;
        maxSpeed = 50;
        switch (engine.toLowerCase()){
            case "small":
                maxSpeed = maxSpeed + 10;
                break;
            case "medium":
                maxSpeed = maxSpeed + 20;
                break;
            case "large":
                maxSpeed = maxSpeed + 30;
                break;
            default:
                break;
        }
        maxSpeed = maxSpeed / (weight / 50);
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }

    public void setMaxSpeed(int speed, boolean formulaOrNot){
        if (formulaOrNot)
        {
            maxSpeed = 50;
            switch (engine.toLowerCase()){
                case "small":
                    maxSpeed = maxSpeed + 10;
                    break;
                case "medium":
                    maxSpeed = maxSpeed + 20;
                    break;
                case "large":
                    maxSpeed = maxSpeed + 30;
                    break;
                default:
                    break;
            }
            maxSpeed = maxSpeed / weight;
        }
        else
        {
            maxSpeed = speed;
        }
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
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

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEngine(){
        return engine;
    }

    public void setEngine(String engine){
        this.engine = engine;
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