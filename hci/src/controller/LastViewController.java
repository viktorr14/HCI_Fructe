package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Dana on 13-Jan-18.
 */
public class LastViewController extends BaseController {
    @FXML
    Button close_btn;

    public LastViewController(){}

    @FXML
    public void initialize() {
        play_sound("/resources/sounds/applause.mp3");
    }

    @FXML
    public void handle_btn_close(){
        close_app(close_btn);
    }

    @FXML
    public void handleRestartButton(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClassLoader.getSystemResource("resources/view/app.fxml"));

            Stage stage = (Stage) close_btn.getScene().getWindow();
            Parent root = loader.load();
            AppViewController controller = loader.getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            controller.setBaseStage(stage);
            controller.setBaseScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
