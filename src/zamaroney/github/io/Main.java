package zamaroney.github.io;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Driver class for the ProductLineTracker program.
 *
 * @author Zachary Maroney
 */

public class Main extends Application {

  /**
   * Opens the scene in a new window.
   *
   * @param primaryStage Sets up the initial Stage.
   * @throws Exception In case the program fails because of JavaFXML.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("productline.fxml"));
    primaryStage.setTitle("Product Line");
    primaryStage.setScene(new Scene(root//,530, 520)
    ));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

