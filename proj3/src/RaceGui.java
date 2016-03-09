import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

/**
 * Created by Corey on 3/6/2016.
 */
public class RaceGui extends BorderPane {

    private Button back;
    private Race race;

    public RaceGui(){

        race = new Race(4);
        back = new Button("Back");
        setupCenter();
        setupBottom();
    }

    public void setupCenter(){

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: black;" +
                "-fx-border-width: 8px;" +
                "-fx-border-color: darkgoldenrod");

        grid.getColumnConstraints().add(new ColumnConstraints(15));
        grid.getRowConstraints().add(new RowConstraints(15));

        grid.add(new Button("heath leger"), 100, 40);

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
        });

        box.getChildren().addAll(start, back);

        setBottom(box);
    }

    public Button getBack(){
        return back;
    }

    public void vroomVroom(){

    }
}
