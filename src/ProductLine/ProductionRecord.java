package ProductLine;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Zachary Maroney
 */
public class ProductionRecord {

  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;


  public ProductionRecord(int productID) {
    this.productID = productID;
    this.productionNumber = 0;
    this.serialNumber = "0";
    this.dateProduced = new Date();
  }

  public ProductionRecord(int productionNumber, int productID, String serialNumber,
      Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  public ProductionRecord(Product product, int quantity) {
    String company = product.getManufacturer();
    String companyLetters = null;
    if (company.length() > 3) {
      companyLetters = company.substring(0, 3);
    }
    String productType = product.getType().code();
    String uniqueCode = String.format("%05d", quantity);
    serialNumber = companyLetters + productType + uniqueCode;
    setProdDate(new Date());
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
   * @return int private prodcutID value
   */
  public int getProductID() {
    return productID;
  }

  /**
   * @param productID int changes the private productID value
   */
  public void setProductID(int productID) {
    this.productID = productID;
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

  @Override
  public String toString() {
    return "Prod. Num: " + getProductionNum() + " Product ID: " + getProductID()
        + " Serial Num: " + getSerialNum() + " Date: " + new SimpleDateFormat()
        .format(getProdDate()) + "\n";
  }
}
