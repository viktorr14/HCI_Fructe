package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Dana on 29-Nov-17.
 */
public class AppViewController extends BaseController {

    @FXML
    Button btn_ex1;
    @FXML
    Button btn_ex2;
    @FXML
    Button btn_ex3;
    @FXML
    Button btn_ex4;
    @FXML
    Button btn_ex5;
    @FXML
    Button btn_ex6;
    @FXML
    Button btn_left;
    @FXML
    Button close_btn;

    public AppViewController() {
        super();
    }

    @FXML
    public void initialize() {
        play_sound("/resources/sounds/app.mp3");

        btn_ex1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> play_sound("/resources/sounds/1.mp3"));
        btn_ex2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> play_sound("/resources/sounds/2.mp3"));
        btn_ex3.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> play_sound("/resources/sounds/3.mp3"));
        btn_ex4.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> play_sound("/resources/sounds/1.mp3"));
        btn_ex5.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> play_sound("/resources/sounds/2.mp3"));
        btn_ex6.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> play_sound("/resources/sounds/3.mp3"));
    }

    // app screen
    @FXML
    void handle_btn_ex1() {
        try {
            change_scene("resources/view/1_mar_mare.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handle_btn_ex2() {
        try {
            change_scene("resources/view/2_mar_verde.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handle_btn_ex3() {
        try {
            change_scene("resources/view/3_mar_multime.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handle_btn_ex4() {
        try {
            change_scene("resources/view/4_struguri_multime.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handle_btn_ex5() {
        try {
            change_scene("resources/view/5_cos_struguri.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handle_btn_ex6() {
        try {
            change_scene("resources/view/6_pozitii.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void change_scene(String file) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClassLoader.getSystemResource(file));

        Stage stage = (Stage) btn_ex1.getScene().getWindow();
        Parent root = loader.load();
        BaseController controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        controller.setBaseStage(stage);
        controller.setBaseScene(scene);

        stage.show();
    }

    @FXML
    public void handle_btn_left(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClassLoader.getSystemResource("resources/view/welcome.fxml"));
            Stage stage = (Stage) btn_left.getScene().getWindow();
            Parent root = loader.load();

            WelcomeViewController controller = loader.getController();
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

    @FXML
    public void handle_btn_close(){
        Stage stage = (Stage) close_btn.getScene().getWindow();
        stage.close();
    }

}
