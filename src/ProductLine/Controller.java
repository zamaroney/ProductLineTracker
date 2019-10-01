/**
 * Created by: Zachary Maroney
 * <p>
 * This is the implements all the gui components and imports all tje sql/FXML libraries.
 */

package ProductLine;

import static javafx.collections.FXCollections.observableArrayList;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

/**
 * Sets up the different action that many of the gui components do.
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

  private void qualityInitialize() {
    chooseQuality
        .setItems(observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    chooseQuality.setEditable(true);
    chooseQuality.getSelectionModel().selectFirst();
  }


  private void typeInitialize() {
    String value;
    ArrayList<String> type = new ArrayList<String>();
    for (ItemType item : ItemType.values()) {
      value = item.type();
      type.add(value);
    }
    chooseType.setItems(observableArrayList(type));
  }

  /**
   * action event that sends an example product to the product table.
   */
  @FXML
  void printProduct(ActionEvent event) {

    Widget myProduct = new Widget("iPhone", "Apple", ItemType.VISUAL_MOBILE);

    PreparedStatement storeProduct = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      // use driver manager to get a connection, that needs three arguments)

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      String name = myProduct.getName();
      String manufacturer = myProduct.getManufacturer();
      String type = myProduct.getType();

      storeProduct = conn.prepareStatement(
          "INSERT INTO Product(name, manufacturer, type) VALUES(?, ?, ?)");

      storeProduct.setString(1, name);
      storeProduct.setString(2, manufacturer);
      storeProduct.setString(3, type);

      storeProduct.execute();

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
