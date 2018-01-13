import controller.WelcomeViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClassLoader.getSystemResource("resources/view/welcome.fxml"));
        Parent root = loader.load();
//        AnchorPane root = new AnchorPane();
//        loader.setLocation(ClassLoader.getSystemResource("resources.view/app.fxml"));
//        TabPane root = new TabPane();
        WelcomeViewController controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        controller.setBaseStage(stage);
        controller.setBaseScene(scene);
        stage.show();
    }
}