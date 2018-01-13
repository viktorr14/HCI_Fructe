package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Dana on 07-Jan-18.
 */
public class Ex2ViewController extends BaseController {

    @FXML
    Button btn_left;

    @FXML
    Button close_btn;

    @FXML
    Button btn_right;

    // 2
    @FXML
    public void handle_btn_mar_verde() {
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
        show_next_exercise("resources/view/3_mar_multime.fxml", btn_right);
    }

}
