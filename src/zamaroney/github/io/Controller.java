package zamaroney.github.io;

import static zamaroney.github.io.ItemType.AUDIO;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
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

  // Initialize the product Observable Array
  ObservableList<Product> products = FXCollections.observableArrayList();
  String PASS;

  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:./res/PR";
  static final String USER = "";

  //  Database credentials
  Connection conn = null;
  // initialize connections
  Statement stmt = null;

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
   * List of products that can be produced.
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

  @FXML
  private TextField firstLastNameTxtFld;

  @FXML
  private PasswordField passwordTxtFld;

  @FXML
  private TextArea userInformationTextArea;

  /**
   * Preforms methods that will always be preformed when the application opens.
   */
  public void initialize() {

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      Properties prop = new Properties();
      try {
        prop.load(new FileInputStream("res/properties"));
      } catch (IOException e) {
        e.printStackTrace();
      }
      PASS = prop.getProperty("password");

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
    recordProductionListView.setItems(products);
    loadProductionList();
    insertProductTable();
    showProduction(loadProductionLog());
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

    loadProductionList();
  }

  /**
   * Append the record to display the recording of a products production.
   *
   * @param event button is clicked.
   */
  @FXML
  void printRecord(ActionEvent event) {
    ObservableList<ProductionRecord> productRun = FXCollections.observableArrayList();
    int quantity = Integer.parseInt(chooseQuantity.getSelectionModel().getSelectedItem());
    for (int sequence = 0; sequence < quantity; sequence++) {
      ProductionRecord record = new ProductionRecord(
          recordProductionListView.getSelectionModel().getSelectedItem(), sequence);
      productRun.add(record);
    }
    addToProductDB(productRun);
    loadProductionLog();
  }

  @FXML
  void createEmployee(ActionEvent event) {
    Employee employee = new Employee(firstLastNameTxtFld.getText(), passwordTxtFld.getText());
    userInformationTextArea.setText(employee.toString());
  }

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

  private void loadProductionList() {
    String sql = "SELECT * FROM PRODUCT";
    try {
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        // these lines correspond to the database table columns
        String name = rs.getString(2);
        String typeString = rs.getString(3);
        String manufacturer = rs.getString(4);

        ItemType type;
        switch (typeString) {
          case "AU":
            type = AUDIO;
            break;
          case "VI":
            type = ItemType.VISUAL;
            break;
          case "AM":
            type = ItemType.AUDIO_MOBILE;
            break;
          case "VM":
            type = ItemType.VISUAL_MOBILE;
            break;
          default:
            throw new IllegalStateException("Unexpected value: " + typeString);
        }

        // create object
        Widget productFromDB = new Widget(name, manufacturer, type);

        // save to observable list
        products.add(productFromDB);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void addToProductDB(ObservableList<ProductionRecord> productionRecords) {

    PreparedStatement storeProduct;
    for (ProductionRecord productRun : productionRecords) {
      try {
        storeProduct = conn.prepareStatement(
            "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) VALUES(?, ?, ?)");

        storeProduct.setString(1, productRun.getProductName());
        storeProduct.setString(2, productRun.getSerialNum());
        storeProduct.setString(3, Timestamp.from(productRun.getProdDate().toInstant()).toString());

        storeProduct.execute();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  private ObservableList<ProductionRecord> loadProductionLog() {
    ObservableList<ProductionRecord> records = FXCollections.observableArrayList();
    String sql = "SELECT * FROM PRODUCTIONRECORD";
    try {
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        // these lines correspond to the database table columns
        int prodNum = rs.getInt(1);
        String prodID = rs.getString(2);
        String serialNam = rs.getString(3);
        Date prodDate = rs.getDate(4);

        // create object
        ProductionRecord productRunFromDB = new ProductionRecord(prodNum, prodID, serialNam,
            prodDate);

        records.add(productRunFromDB);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    showProduction(records);
    return records;
  }

  private void showProduction(ObservableList<ProductionRecord> records) {
    productionLog.setText(records.toString().replace("[", "").replace("]", "").replace(", ", ""));
  }

}
