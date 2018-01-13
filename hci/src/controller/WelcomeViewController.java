package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Dana on 25-Nov-17.
 */
public class WelcomeViewController extends BaseController {
    @FXML
    Button start_button;

    @FXML
    public void handleStartButton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClassLoader.getSystemResource("resources/view/app.fxml"));

        Stage stage = (Stage) start_button.getScene().getWindow();
        Parent root = loader.load();
        AppViewController controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        controller.setBaseStage(stage);
        controller.setBaseScene(scene);

        stage.show();
    }

    @FXML
    public void handle_btn_close(){
        Stage stage = (Stage) start_button.getScene().getWindow();
        stage.close();
    }
}