package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Dana on 07-Jan-18.
 */
public class Ex5ViewController extends BaseController {

    @FXML
    Button btn_left;

    @FXML
    Button close_btn;

    @FXML
    Button btn_right;

    // 5
    @FXML
    public void handle_btn_cos3() {
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
        show_next_exercise("resources/view/6_pozitii.fxml", btn_right);
    }

}
