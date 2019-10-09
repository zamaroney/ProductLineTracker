/**
 * Created by: Zachary Maroney
 * <p>
 * This is the implements all the gui components and imports all tje sql/FXML libraries.
 */

package ProductLine;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
/**
 * Sets up the different action that many of the gui components do.
 *
 * @author Zachary Maroney
 */
public class Controller implements Initializable {

  final String JDBC_DRIVER = "org.h2.Driver";
  final String DB_URL = "jdbc:h2:./res/PR";
  final String USER = "";
  final String PASS = "";

  //  Database credentials
  Connection conn = null;
  // initialize connections
  Statement stmt = null;

  /**
   * Button that sends data about a product to the product table.
   */
  @FXML
  private Button productButton;

  @FXML
  private TextField productTextBox;

  @FXML
  private TextField manufacturerTextBox;

  @FXML
  private ChoiceBox<String> chooseType;

  /**
   * Button that sends data about a product to the records.
   */
  @FXML
  private Button recordButton;

  @FXML
  private TableView<?> productTable;

  @FXML
  private ComboBox<String> chooseQuality;

  /**
   * sets the quality values in the combo box.
   */
  private void qualityInitialize() {
    for (int i = 1; i <= 10; i++) {
      chooseQuality.getItems().add(String.valueOf(i));
    }
    chooseQuality.setEditable(true);
    chooseQuality.getSelectionModel().selectFirst();
  }

  /**
   *
   */
  private void typeInitialize() {
    for (ItemType item : ItemType.values()) {
      chooseType.getItems().add(item.type());
    }
  }

  /**
   * action event that sends an example product to the product table.
   */
  @FXML
  void printProduct(ActionEvent event) {

    String value = chooseType.getValue();
    switch (value) {
      case "Audio":
        value = ItemType.AUDIO.code();
        break;
      case "Visual":
        value = ItemType.VISUAL.code();
        break;
      case "Audio Mobile":
        value = ItemType.AUDIO_MOBILE.code();
        break;
      case "Visual Mobile":
        value = ItemType.VISUAL_MOBILE.code();
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + value);
    }

    Widget myProduct = new Widget(productTextBox.getText(), manufacturerTextBox.getText(), value);

    PreparedStatement storeProduct = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      // use driver manager to get a connection, that needs three arguments)

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      storeProduct = conn.prepareStatement(
          "INSERT INTO Product(name, manufacturer, type) VALUES(?, ?, ?)");

      storeProduct.setString(1, myProduct.getName());
      storeProduct.setString(2, myProduct.getManufacturer());
      storeProduct.setString(3, myProduct.getType());

      storeProduct.execute();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      // use driver manager to get a connection, that needs three arguments)

      //STEP 3: Execute a query
      stmt = conn.createStatement();
      //

      String sqlSetAllFromJobs = "SELECT * FROM PRODUCT";

      ResultSet rs = stmt.executeQuery(sqlSetAllFromJobs);
      ResultSetMetaData rsmd = rs.getMetaData();

      int columnNumber = rsmd.getColumnCount();

      while (rs.next()) {
        for (int i = 2; i <= columnNumber; i++) {
          if (i > 2) {
            System.out.print(",  ");
          }
          String columnValue = rs.getString(i);
          System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
        }
        System.out.println();
      }

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

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    qualityInitialize();
    typeInitialize();
  }
}
