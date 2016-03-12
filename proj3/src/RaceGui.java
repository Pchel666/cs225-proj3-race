import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
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

    /**
     * default constructor
     */
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

        addCities();
        grid.setAlignment(Pos.CENTER);
        addCars();
        setCenter(grid);
    }

    /**
     * adds cities in the form of a green circle
     */
    public void addCities(){

        for( int i = 0; i < 4; i++ ) {

            grid.add(new Circle(8, Color.GREEN),
                    race.getCities().get(i).getYCoord(),
                    race.getCities().get(i).getXCoord());
        }
    }
    /**
     * sets the bottom section of the race scene
     */
    public void setupBottom(){

        HBox box = new HBox();
        box.setSpacing(25);
        box.setAlignment(Pos.CENTER);
        box.setMaxHeight(100);
        box.setMinHeight(30);
        box.setStyle("-fx-background-color: gold;" +
                "-fx-border-color: darkgoldenrod;" +
                "-fx-border-width: 12px");

        Button move = new Button("Move");
        move.setOnAction(e->{
            moveAll();
            removeCars();
            addCars();
        });

        box.getChildren().addAll(move, back);

        setBottom(box);
    }

    /**
     * gets a back button
     * @return Button
     */
    public Button getBack(){
        return back;
    }

    /**
     * moves all the cars
     */
    public void moveAll(){

        for( int i = 0; i < 4; i++ ){
            race.moveCar(i, race.getCities().get(
                    race.getCars()[i].destination() ));

            if( race.getCars()[i].getPosX() ==
                    race.getCities().get(race.getCars()[i].destination()).getXCoord() &&
                    race.getCars()[i].getPosY() ==
                            race.getCities().get(race.getCars()[i].destination()).getYCoord() )
                if( race.getCars()[i].setCurr() ) {
                    Alert winnerMessage = new Alert(Alert.AlertType.INFORMATION);
                    winnerMessage.setContentText("Car " + i + " is the winner!!!\n");
                    winnerMessage.showAndWait();
                }
        }
    }

    /**
     * sets the image for all the cars
     */
    public void setCars(){

        red = new ImageView(new Image("RedCar.png"));
        red.setFitHeight(15);
        red.setFitWidth(25);

        blue = new ImageView(new Image("BlueCar.png"));
        blue.setFitHeight(15);
        blue.setFitWidth(25);

        green = new ImageView(new Image("GreenCar.png"));
        green.setFitHeight(15);
        green.setFitWidth(25);

        yellow = new ImageView(new Image( "YellowCar.png"));
        yellow.setFitHeight(15);
        yellow.setFitWidth(25);
    }

    /**
     * adds the cars to the grid
     */
    public void addCars(){
        grid.add(red, race.getCars()[0].getPosY(),
                race.getCars()[0].getPosX());

        grid.add(blue, race.getCars()[1].getPosY(),
                race.getCars()[1].getPosX());

        grid.add(green, race.getCars()[2].getPosY(),
                race.getCars()[2].getPosX());

        grid.add(yellow, race.getCars()[3].getPosY(),
                race.getCars()[3].getPosX());
    }

    /**
     * removes the cars from the grid
     */
    public void removeCars() {
        grid.getChildren().remove(red);
        grid.getChildren().remove(blue);
        grid.getChildren().remove(green);
        grid.getChildren().remove(yellow);
    }
}
