package ProductLine;

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
   * @param productName String Assigned production name of the product.
   * @param serialNumber String Coded String that represent the production.
   * @param dateProduced Date Time that the product was recorded to be produced.
   */
  public ProductionRecord(int productionNumber, String productName, String serialNumber,
      Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productName = productName;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  /**
   * Takes a product and generates record fields
   *
   * @param product Product current product being recorded.
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
   * @return int private productNumber value
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * @param productionNumber int changes the private productNumber value
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * @return String private prodcutName value
   */
  public String getProductName() {
    return productName;
  }

  /**
   * @param productName String changes the private productName value
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * @return String private serialNumber value
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * @param serialNumber String changes the private productSerial value
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * @return Date private dateProduced value
   */
  public Date getProdDate() {
    return dateProduced;
  }

  /**
   * @param dateProduced Date changes the private dateProduced value
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * @return information about the production record.
   */
  @Override
  public String toString() {
    return "Prod. Num: " + getProductionNum() + " Product Name: " + getProductName()
        + " Serial Num: " + getSerialNum() + " Date: " + new SimpleDateFormat()
        .format(getProdDate()) + "\n";
  }
}
