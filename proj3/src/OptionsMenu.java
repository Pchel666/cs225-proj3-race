import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by corey on 2/29/16.
 */
public class OptionsMenu extends VBox {

    private Button back;

    /**
     * default constuctor
     */
    public OptionsMenu(){

        setStyle("-fx-background-color: black;" +
                "-fx-spacing: 10px;" +
                "-fx-border-color: yellow;" +
                "-fx-border-width: 0 10 0 10px;" +
                "-fx-border-insets: 10 40 10 40px");
        setTopText();

        makeRow("Unicorn with \nRainbow trail", "62.95" );
        makeRow("underglow", "49.95");
        back = new Button("<-Back");
        back.setAlignment(Pos.BASELINE_CENTER);
        getChildren().add(back);
    }

    /**
     * sets the text at the top
     */
    private void setTopText(){
        Text top = new Text("Buy some Extreme DLC\n" +
                "for more Extreme racing action!!!");
        top.setTextAlignment(TextAlignment.CENTER);
        setAlignment(Pos.TOP_CENTER);
        top.setStyle("-fx-fill: red;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bolder");

        getChildren().add(top);
    }

    /**
     * makes a row including description, button, price and
     * @param description text describing what the item is
     * @param price price of item
     */
    private void makeRow( String description, String price ){

        HBox box = new HBox();
        Text desc = new Text(description);
        Text cost = new Text("$" + price);
        Button purchase = new Button("Buy Now");

        desc.setStyle("-fx-background-color: transparent;" +
                "-fx-fill: red;");

        cost.setStyle("-fx-background-color: transparent;" +
                "-fx-fill: green");
        box.setStyle("-fx-background-color: darkgray;" +
                "-fx-spacing: 5px");

        box.getChildren().add( desc );
        box.getChildren().add(purchase);
        box.getChildren().add(cost);

        box.setAlignment(Pos.CENTER);
        getChildren().add(box);
    }

    /**
     * gets the back button
     * @return Button
     */
    public Button getBack() {
        return back;
    }
}
