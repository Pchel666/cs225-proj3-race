import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    /**
     * initializes and switches through the scenes
     */
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Super Race car game of racing");

        MainMenu menu = new MainMenu();
        Scene menuScene = new Scene(menu, 600, 400);

        OptionsMenu options = new OptionsMenu();
        Scene optionsScene = new Scene(options, 600, 400);

        RaceGui race = new RaceGui();
        Scene raceScene = new Scene(race, 800, 600 );

        menu.getQuit().setOnAction(e-> System.exit(0));

        menu.getStartButton().setOnAction(e->
                primaryStage.setScene(
                        raceScene ));

        menu.getOptions().setOnAction(e->
                primaryStage.setScene(
                        optionsScene));

        options.getBack().setOnAction(e->
                primaryStage.setScene(
                        menuScene));

        race.getBack().setOnAction(e->
                primaryStage.setScene(
                        menuScene));

        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
