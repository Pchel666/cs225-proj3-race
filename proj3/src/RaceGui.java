import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Created by Corey on 3/6/2016.
 */
public class RaceGui extends BorderPane {

    private Map map;
    private Button back;

    public RaceGui(){

        back = new Button("Back");
        setupCenter();
        setupBottom();
    }

    public void setupCenter(){

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: black;" +
                "-fx-border-width: 8px;" +
                "-fx-border-color: darkgoldenrod");
        

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

        box.getChildren().addAll(start, back);

        setBottom(box);
    }
}
