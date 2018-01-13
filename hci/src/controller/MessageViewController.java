package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Dana on 07-Jan-18.
 */
public class MessageViewController {
    @FXML
    Button okButton;

    @FXML
    public void handle_btn_ok(ActionEvent e) {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
