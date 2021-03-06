package controller;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Created by Dana on 29-Nov-17.
 */
public class AppViewController extends BaseController {

    @FXML
    Tab tab_1;
    @FXML
    Tab tab_2;
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
    @FXML
    Button btn_play_video;
    @FXML
    Button btn_stop_video;
    @FXML
    Label label_video_progress;
    @FXML
    Slider slider_video_progress;
    @FXML
    ProgressBar slider_progress_bar;
    @FXML
    StackPane video_progress_pane;
    @FXML
    MediaView video_view;
    @FXML
    Pane video_container;
    @FXML
    HBox video_controls_pane;

    private MediaPlayer media_player;
    private Duration video_duration;
    private InvalidationListener progressListener;

    public AppViewController() {
        super();
    }

    @FXML
    public void initialize() {
        initializeVideoPlayer();

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

    private void initializeVideoPlayer() {
        media_player = new MediaPlayer(new Media(String.valueOf(getClass().getResource("/resources/video/povestea.mp4"))));
        video_view.setMediaPlayer(media_player);

        video_container.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue.getWidth() + "x" + newValue.getHeight());
            video_view.setFitWidth(newValue.getWidth());
            video_view.setFitHeight(newValue.getHeight());
        });

        slider_progress_bar.prefWidthProperty().bind(video_progress_pane.widthProperty().subtract(12));

        media_player.setOnReady(() -> {
            video_duration = media_player.getMedia().getDuration();
            updatePlayerControls();
        });

        media_player.setOnEndOfMedia(() -> {
            handle_btn_stop_video();
            media_player.seek(media_player.getStartTime());
            media_player.currentTimeProperty().addListener(progressListener);
        });

        progressListener = observable -> updatePlayerControls();
        media_player.currentTimeProperty().addListener(progressListener);

        slider_video_progress.valueProperty().addListener(observable -> {
            if (slider_video_progress.isPressed()) {
                double progress = slider_video_progress.getValue() / 100.0;
                media_player.seek(video_duration.multiply(progress));
                slider_progress_bar.setProgress(progress);
            }
        });


    }

    private void updatePlayerControls() {
        Platform.runLater(() -> {
            Duration currentTime = media_player.getCurrentTime();
            label_video_progress.setText(computeProgress(currentTime));
            slider_video_progress.setDisable(video_duration.isUnknown());
            if (!slider_video_progress.isValueChanging()) {
                double progess = currentTime.divide(video_duration.toMillis()).toMillis() * 100;
                slider_video_progress.setValue(progess);
                slider_progress_bar.setProgress(progess / 100);
            }
        });
    }

    private String computeProgress(Duration currentTime) {
        int elapsed = (int) Math.floor(currentTime.toSeconds());
        int elapsedMinutes = elapsed / 60;
        int elapsedSeconds = elapsed % 60;
        int total = (int) Math.floor(video_duration.toSeconds());
        int totalMinutes = total / 60;
        int totalSeconds = total % 60;
        return String.format("%02d:%02d/%02d:%02d", elapsedMinutes, elapsedSeconds, totalMinutes, totalSeconds);
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

    @FXML
    void handle_btn_play_video() {
        Status status = media_player.getStatus();
        switch (status) {
            case STALLED:
            case PLAYING:
                pause_video();
                break;
            case STOPPED:
                media_player.seek(media_player.getStartTime());
                media_player.currentTimeProperty().addListener(progressListener);
            case READY:
            case PAUSED:
                play_video();
                break;
            default:
                break;
        }
    }

    private void play_video() {
        media_player.play();
        set_play_button_pause_image(true);
    }

    private void pause_video() {
        media_player.pause();
        set_play_button_pause_image(false);
    }

    @FXML
    void handle_btn_stop_video() {
        media_player.stop();
        set_play_button_pause_image(false);
    }

    private void set_play_button_pause_image(boolean pause) {
        String path = "resources/img/play_video_btn.png";
        if (pause) {
            path = "resources/img/pause_video_btn.png";
        }
        btn_play_video.setStyle(
                "-fx-background-image: url(" + path + ");\n" +
                        "-fx-background-size: contain;\n" +
                        "-fx-background-position: center;"
        );
    }

    private void change_scene(String file) throws IOException {
        stop_sound();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClassLoader.getSystemResource(file));
        Stage stage = (Stage) btn_ex1.getScene().getWindow();
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
    }

    @FXML
    public void handle_btn_left() {
        handle_btn_stop_video();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClassLoader.getSystemResource("resources/view/welcome.fxml"));
            Stage stage = (Stage) btn_left.getScene().getWindow();
            stage.setMinHeight(450);
            stage.setMinWidth(600);
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
    public void handle_tab_selection_changed() {
        if (tab_1.isSelected()) {
            stop_sound();
        } else {
            pause_video();
            play_sound("/resources/sounds/app.mp3");
        }
    }

    @FXML
    public void handle_btn_close() {
        Stage stage = (Stage) close_btn.getScene().getWindow();
        stage.close();
    }

}
