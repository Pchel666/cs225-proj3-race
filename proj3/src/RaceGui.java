import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by Corey on 3/6/2016.
 */
public class RaceGui extends BorderPane {

    private Button back;
    private Race race;
    private GridPane grid;

    public RaceGui(){

        race = new Race( 20 );
        back = new Button("Back");
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
        car.setFitHeight(15);
        car.setFitWidth(20);

        grid.add( car, 0, 0 );

        for( int i = 1; i < 4; i++ ){

            grid.getChildren().remove(car);
            grid.add(car, i*4, i*4);

            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
