package ProductLine;

import static ProductLine.ItemType.AUDIO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Sets up the different action that many of the gui components do.
 *
 * @author Zachary Maroney
 */
public class Controller {

  final String JDBC_DRIVER = "org.h2.Driver";
  final String DB_URL = "jdbc:h2:./res/PR";
  final String USER = "";
  final String PASS = "";

  //  Database credentials
  Connection conn = null;
  // initialize connections
  Statement stmt = null;

  // Initialize the product Observable Array
  ObservableList<Product> products = FXCollections.observableArrayList();
  ObservableList<String> Records = FXCollections.observableArrayList();

  /**
   * Button that sends data about a product to the product table.
   */
  @FXML
  private Button productButton;

  /**
   * User input for the name of a new Product.
   */
  @FXML
  private TextField productTextBox;

  /**
   * User input for the Manufacturer of a new Product.
   */
  @FXML
  private TextField manufacturerTextBox;

  /**
   * records of the products recorded.
   */
  @FXML
  private TextArea productionLog;

  /**
   * The different typed that an Item can be.
   */
  @FXML
  private ChoiceBox<String> chooseType;

  /**
   * Button that sends data about a product to the records.
   */
  @FXML
  private Button recordButton;

  /**
   * List of products that can be produced
   */
  @FXML
  private TableView<Product> productTable;

  /**
   * Product column.
   */
  @FXML
  private TableColumn<?, ?> prodNameCol;

  /**
   * Manufacturer column.
   */
  @FXML
  private TableColumn<?, ?> manufacturerCol;

  /**
   * Item column.
   */
  @FXML
  private TableColumn<?, ?> itemTypeCol;

  /**
   * Allows users to select of a product to be produced or create their own number.
   */
  @FXML
  private ComboBox<String> chooseQuantity;

  /**
   * Shows the records of the product produced.
   */
  @FXML
  private ListView<Product> recordProductionListView;

  /**
   * sets the quality values in the combo box.
   */
  private void quantityInitialize() {
    for (int i = 1; i <= 10; i++) {
      chooseQuantity.getItems().add(String.valueOf(i));
    }
    chooseQuantity.setEditable(true);
    chooseQuantity.getSelectionModel().selectFirst();
  }

  /**
   * Adds the items type to the choice box.
   */
  private void typeInitialize() {
    for (ItemType item : ItemType.values()) {
      chooseType.getItems().add(item.type());
    }
  }

  /**
   * Sets up the product table with existing products created by the user.
   */
  private void insertProductTable() {
    prodNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    itemTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    productTable.setItems(products);
  }

  /**
   * Creates a user created product and stores it into a observable list.
   *
   * @param event button is clicked.
   */
  @FXML
  void printProduct(ActionEvent event) {

    String value = chooseType.getValue();
    ItemType type;
    switch (value) {
      case "Audio":
        type = AUDIO;
        break;
      case "Visual":
        type = ItemType.VISUAL;
        break;
      case "Audio Mobile":
        type = ItemType.AUDIO_MOBILE;
        break;
      case "Visual Mobile":
        type = ItemType.VISUAL_MOBILE;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + value);
    }

    Widget myProduct = new Widget(productTextBox.getText(), manufacturerTextBox.getText(), type);

    PreparedStatement storeProduct;

    products.add(myProduct);

    try {
      storeProduct = conn.prepareStatement(
          "INSERT INTO Product(name, manufacturer, type) VALUES(?, ?, ?)");

      storeProduct.setString(1, myProduct.getName());
      storeProduct.setString(2, myProduct.getManufacturer());
      storeProduct.setString(3, myProduct.getType().code());

      storeProduct.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      String sqlSetAllFromJobs = "SELECT * FROM PRODUCT";

      ResultSet rs = stmt.executeQuery(sqlSetAllFromJobs);
      ResultSetMetaData rsmd = rs.getMetaData();

      int columnNumber = rsmd.getColumnCount();
      StringBuilder text;

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
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();

    }
  }

  /**
   * Append the record to display the recording of a products production.
   *
   * @param event button is clicked.
   */
  @FXML
  void printRecord(ActionEvent event) {
    ProductionRecord record = new ProductionRecord(
        recordProductionListView.getSelectionModel().getSelectedItem(),
        Integer.parseInt(chooseQuantity.getSelectionModel().getSelectedItem()));
    productionLog.appendText(record.toString());
  }


  /**
   * Preforms methods that will always be preformed when the application opens.
   */
  public void initialize() {
    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      // use driver manager to get a connection, that needs three arguments)

      //STEP 3: Execute a query
      stmt = conn.createStatement();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    quantityInitialize();
    typeInitialize();
    AudioPlayerDriver.testAudioPlayer();
    MoviePlayerDriver.testMoviePlayer();
    insertProductTable();
    recordProductionListView.setItems(products);
  }

}
