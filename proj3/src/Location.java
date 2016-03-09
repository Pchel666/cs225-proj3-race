public class Location {
    private int xCoord;
    private int yCoord;

    public Location(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getXCoord(){
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}