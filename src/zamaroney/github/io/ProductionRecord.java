package zamaroney.github.io;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Records the time that a product is produced and assigns fields and methods to record the
 * information.
 *
 * @author Zachary Maroney
 */
public class ProductionRecord {

  /**
   * Assigned production number of the object.
   */
  private int productionNumber;

  /**
   * Assigned production name of the product.
   */
  private String productName;

  /**
   * Coded String that represent the production.
   */
  private String serialNumber;

  /**
   * Time that the product was recorded to be produced.
   */
  private Date dateProduced = new Date();


  /**
   * Takes a Product name and assigns a generic product number and serial number.
   *
   * @param productName String product name.
   */
  public ProductionRecord(String productName) {
    this.productName = productName;
    this.productionNumber = 0;
    this.serialNumber = "0";
  }

  /**
   * Hard coded product to be produced.
   *
   * @param productionNumber int Assigned production number of the object.
   * @param productName      String Assigned production name of the product.
   * @param serialNumber     String Coded String that represent the production.
   * @param dateProduced     Date Time that the product was recorded to be produced.
   */
  public ProductionRecord(int productionNumber, String productName, String serialNumber,
      Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productName = productName;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  /**
   * Takes a product and generates record fields.
   *
   * @param product  Product current product being recorded.
   * @param quantity int number of products to be created.
   */
  public ProductionRecord(Product product, int quantity) {
    setProductName(product.getName());
    String company = product.getManufacturer();
    String companyLetters = null;
    if (company.length() > 3) {
      companyLetters = company.substring(0, 3);
    }
    String productType = product.getType().code();
    String uniqueCode = String.format("%05d", quantity);
    serialNumber = companyLetters + productType + uniqueCode;
  }

  /**
   * Gets the production number.
   *
   * @return int private productNumber value
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * Sets the production number.
   *
   * @param productionNumber int changes the private productNumber value
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * Gets the product's name.
   *
   * @return String private productName value
   */
  public String getProductName() {
    return productName;
  }

  /**
   * Sets the product's name.
   *
   * @param productName String changes the private productName value
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * Gets the serial number.
   *
   * @return String private serialNumber value
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * Sets the serial number.
   *
   * @param serialNumber String changes the private productSerial value
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * Gets the production date.
   *
   * @return Date private dateProduced value
   */
  public Date getProdDate() {
    return dateProduced;
  }

  /**
   * Sets the production date.
   *
   * @param dateProduced Date changes the private dateProduced value
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * Displays the information about the production record.
   *
   * @return information about the production record.
   */
  @Override
  public String toString() {
    return "Prod. Num: " + getProductionNum() + " Product Name: " + getProductName()
        + " Serial Num: " + getSerialNum() + " Date: " + new SimpleDateFormat()
        .format(getProdDate()) + "\n";
  }
}