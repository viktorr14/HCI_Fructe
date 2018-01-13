package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class BaseController {
    private Scene baseScene;
    private Stage baseStage;

    public void setBaseScene(Scene baseScene) {
        this.baseScene = baseScene;
    }

    public void setBaseStage(Stage baseStage) {
        this.baseStage = baseStage;
    }

    void showOkMessage() {
        showMessage(Alert.AlertType.INFORMATION);
    }

    private void showMessage(Alert.AlertType type) {
        //Creare si setare textBox pentru alerta
        try {
            Stage stage = new Stage();
            stage.initOwner(baseStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClassLoader.getSystemResource("resources/view/ok_message.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void play_applause() {
        String musicFile = "/resources/sounds/applause.mp3";
        play_sound(musicFile);
    }

    void play_wrong() {
        String musicFile = "/resources/sounds/wrong2.wav";
        play_sound(musicFile);
    }

    void play_sound(String musicFile) {
        String path = String.valueOf(getClass().getResource(musicFile));
        AudioClip sound = new AudioClip(path);
        sound.play();
    }

    void show_app_page(Button btn_left){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClassLoader.getSystemResource("resources/view/app.fxml"));
            Stage stage = (Stage) btn_left.getScene().getWindow();
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

    void close_app(Button close_btn) {
        Stage stage = (Stage) close_btn.getScene().getWindow();
        stage.close();
    }

    void show_next_exercise(String file, Button btn_right) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClassLoader.getSystemResource(file));
            Stage stage = (Stage) btn_right.getScene().getWindow();
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