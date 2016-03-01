public class Car {
    private int maxSpeed;
    private int weight;
    private String color;
    private String name;
    private String engine;
    private String tire;

    public Car(){
        weight = 100;
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

    public Car(int weight, String color, String name, String engine, String tire){
        this.weight = weight;
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
}