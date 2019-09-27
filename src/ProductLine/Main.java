/**
 * Created by: Zachary Maroney
 * <p>
 * runs the program and creates the window for the gui components.
 */

package ProductLine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***
 * @author Zachary Maroney
 */

public class Main extends Application {

  /**
   * @author Zachary Maroney
   */

  @Override

  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("productline.fxml"));
    primaryStage.setTitle("Product Line");
    primaryStage.setScene(new Scene(root, 530, 520));
    primaryStage.show();
  }

  /**
   * @author Zachary Maroney
   */

  public static void main(String[] args) { launch(args); }
}
