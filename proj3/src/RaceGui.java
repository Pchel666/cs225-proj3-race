import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by Corey on 3/6/2016.
 */
public class RaceGui extends BorderPane {

    private Button back;
    private Race race;
    private GridPane grid;
    private ImageView red, blue, green, yellow;
    public RaceGui(){

        race = new Race( 20 );
        back = new Button("Back");
        setCars();
        setupCenter();
        setupBottom();
    }

    public void setupCenter(){

        grid = new GridPane();
        grid.setStyle("-fx-background-color: black;" +
                "-fx-border-width: 8px;" +
                "-fx-border-color: darkgoldenrod");


        ColumnConstraints col = new ColumnConstraints(25);
        for( int i = 0; i < race.getMapSize(); i++ )
            grid.getColumnConstraints().add(col);

        RowConstraints row = new RowConstraints(25);
        for( int i = 0; i < race.getMapSize(); i++ )
            grid.getRowConstraints().add(row);

        Circle city = new Circle(8, Color.GREEN);

        grid.add( city, race.getCities().get(0).getXCoord(), race.getCities().get(0).getYCoord() );
        grid.setAlignment(Pos.CENTER);
        setCenter(grid);
    }

    public void setupBottom(){

        HBox box = new HBox();
        box.setSpacing(25);
        box.setAlignment(Pos.CENTER);
        box.setMaxHeight(100);
        box.setMinHeight(30);
        box.setStyle("-fx-background-color: gold;" +
                "-fx-border-color: darkgoldenrod;" +
                "-fx-border-width: 12px");

        Button start = new Button("start");
        start.setOnAction(e->{
            vroomVroom();
        });

        box.getChildren().addAll(start, back);

        setBottom(box);
    }

    public Button getBack(){
        return back;
    }

    public void vroomVroom(){

        Image carUno = new Image("CarPic.png");
        ImageView car = new ImageView(carUno);
        car.setFitHeight(20);
        car.setFitWidth(25);

        grid.add( car, 0, 0 );

        for( int i = 1; i < 4; i++ ){

            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            grid.getChildren().remove(car);
            grid.add(car, i*4, i*4);
        }
    }

    public void setCars(){

        red = new ImageView(new Image("RedCar.png"));
        red.setFitHeight(20);
        red.setFitWidth(25);

        blue = new ImageView(new Image("BlueCar.png"));
        blue.setFitHeight(20);
        blue.setFitWidth(25);

        green = new ImageView(new Image("GreenCar.png"));
        green.setFitHeight(20);
        green.setFitWidth(25);

        yellow = new ImageView(new Image( "YellowCar.png"));
        yellow.setFitHeight(20);
        yellow.setFitWidth(25);
    }

    public void addCars(){
        grid.add(red, race.getCars()[0].getPosX(),
                race.getCars()[0].getPosY());

        grid.add(blue, race.getCars()[1].getPosX(),
                race.getCars()[1].getPosY());

        grid.add(green, race.getCars()[2].getPosX(),
                race.getCars()[2].getPosY());

        grid.add(yellow, race.getCars()[3].getPosX(),
                race.getCars()[3].getPosY());
    }

    public void removeCars(){
        grid.getChildren().remove(red);
        grid.getChildren().remove(blue);
        grid.getChildren().remove(green);
        grid.getChildren().remove(yellow);
    }
}
