import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Super Race car game of racing");

        MainMenu menu = new MainMenu();
        Scene menuScene = new Scene(menu, 600, 400);

        OptionsMenu options = new OptionsMenu();
        Scene optionsScene = new Scene(options, 600, 400);

        menu.getQuit().setOnAction(e-> System.exit(0));

        menu.getOptions().setOnAction(e->
                primaryStage.setScene(
                        optionsScene));

        options.getBack().setOnAction(e->
                primaryStage.setScene(
                        menuScene));

        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
