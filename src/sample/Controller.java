package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

  @FXML
  private Button productButton;

  @FXML
  private Button recordButton;

  @FXML
  void printProduct(ActionEvent event) {
    System.out.println("Added new product!");
  }

  @FXML
  void printRecord(ActionEvent event) {
    System.out.println("Recorded new product!");
  }
}
