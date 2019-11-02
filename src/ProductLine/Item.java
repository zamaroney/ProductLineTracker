package ProductLine;

/**
 * creates methods to implement into other classes that would have some type of item.
 *
 * @author Zachary maroney
 */
public interface Item {

  /**
   * @return int id number.
   */
  public int getId();

  /**
   * @param name String sets the private String name.
   */
  public void setName(String name);

  /**
   * @return String get the name of the product.
   */
  public String getName();

  /**
   * @param manufacturer String sets the manufacturer of the product.
   */
  public void setManufacturer(String manufacturer);

  /**
   * @return String gets the manufacturer of the product.
   */
  public String getManufacturer();

}
