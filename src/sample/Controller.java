package sample;

import static javafx.collections.FXCollections.observableArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * Sets up the different action that many of the gui components do.
 * @author Zachary Maroney
 */
public class Controller {

  /**
   * Button that sends data about a product to the product table.
   */
  @FXML
  private Button productButton;

  /**
   * Button that sends data about a product to the records.
   */
  @FXML
  private Button recordButton;

  @FXML
  private ComboBox<String> chooseQuality;

  /**
   * action event that sends an example product to the product table.
   */
  @FXML
  void printProduct(ActionEvent event) {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/PR";

    //  Database credentials
    final String USER = "";    //
    final String PASS = "";
    Connection conn = null;
    // initialize connections
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      // use driver manager to get a connection, that needs three arguments)

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      stmt.executeUpdate(
          "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' )");

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }


  }

  /**
   * action event that sends a message to the console.
   */
  @FXML
  void printRecord(ActionEvent event) {
    System.out.println("Recorded new product!");
  }

  /**
   * creates the drop down options for the combobox in the produce .
   */
  @FXML
  public void initialize() {
    chooseQuality.setItems(observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    chooseQuality.getSelectionModel().selectFirst();
    chooseQuality.setEditable(true);
  }
}
