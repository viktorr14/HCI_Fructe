package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by Dana on 07-Jan-18.
 */
public class Ex1ViewController extends BaseController {

    @FXML
    Button btn_left;

    @FXML
    Button close_btn;

    @FXML
    Button btn_right;

    @FXML
    public void initialize() {
        play_sound("/resources/sounds/ex1.mp3");
    }

    // 1
    @FXML
    void handle_btn_mar_mare() {
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
        show_next_exercise("resources/view/2_mar_verde.fxml", btn_right);
    }
}
