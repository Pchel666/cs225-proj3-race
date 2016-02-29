import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by corey on 2/29/16.
 */
public class OptionsMenu extends VBox {

    private Button back;

    public OptionsMenu(){

        setStyle("-fx-background-color: black");
        setTopText();

        back = new Button("<-Back");
        getChildren().add(back);
    }

    private void setTopText(){
        Text top = new Text("Buy some Extreme DLC\n" +
                "for more Extreme racing action!!!");
        top.setTextAlignment(TextAlignment.CENTER);
        setAlignment(Pos.CENTER);
        top.setFill(Color.YELLOW);

        getChildren().add(top);
    }

    public Button getBack() {
        return back;
    }
}
