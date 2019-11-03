package zamaroney.github.io;

/**
 * creates methods to implement into other classes that would have some type of item.
 *
 * @author Zachary maroney
 */
public interface Item {

  /**
   * Gets the id number.
   *
   * @return int id number.
   */
  public int getId();

  /**
   * Sets the item's name.
   *
   * @param name String sets the private String name.
   */
  public void setName(String name);

  /**
   * Gets the item's name.
   *
   * @return String get the name of the product.
   */
  public String getName();

  /**
   * Sets the item's manufacturer.
   *
   * @param manufacturer String sets the manufacturer of the product.
   */
  public void setManufacturer(String manufacturer);

  /**
   * Gets the item's manufacturer.
   *
   * @return String gets the manufacturer of the product.
   */
  public String getManufacturer();

}
