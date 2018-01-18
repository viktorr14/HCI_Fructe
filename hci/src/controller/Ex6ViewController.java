package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Dana on 07-Jan-18.
 */
public class Ex6ViewController extends BaseController {

    @FXML
    Button btn_left;

    @FXML
    Button close_btn;

    @FXML
    Button btn_right;

    // 6
    @FXML
    public void handle_btn_6_pe() {
        btn_right.setVisible(true);
        play_applause();
        showOkMessage();
    }

    @FXML
    public void handle_wrong() {
        play_wrong();
    }

    @FXML
    public void handle_btn_left(){
        show_app_page(btn_left);
    }

    @FXML
    public void handle_btn_close(){
        close_app(close_btn);
    }

    @FXML
    public void handle_btn_right(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClassLoader.getSystemResource("resources/view/last.fxml"));

            Stage stage = (Stage) btn_left.getScene().getWindow();
            stage.setMinHeight(450);
            stage.setMinWidth(600);

            Parent root = loader.load();
            BaseController controller = loader.getController();
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
