package ProductLine;

/**
 * Declares Product fields.
 * Declares nonabstract methods for Products.
 *
 * @author Zachary Maroney
 */
public abstract class Product implements Item {

  /**
   * Product ID.
   */
  private int id;

  /**
   * Product Type.
   */
  private ItemType type;

  /**
   * Product manufacturer.
   */
  private String manufacturer;

  /**
   * Product name.
   */
  private String name;

  /**
   * Creates a product Object.
   *
   * @param name String product name.
   * @param manufacturer String product manufacturer.
   * @param type ItemType product type.
   */
  public Product (String name, String manufacturer, ItemType type) {
    this.manufacturer = manufacturer;
    this.name = name;
    this.type = type;
  }

  /**
   * @return Product ID number.
   */
  @Override
  public int getId() {
    return id;
  }

  /**
   * @param name String sets the private String name.
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return The private String name of the product.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * @param manufacturer String sets the manufacturer of the product.
   */
  @Override
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * @return The private String manufacturer of the product.
   */
  @Override
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * @return The private ItemType type of the product.
   */
  public ItemType getType() {
    return type;
  }

  /**
   * @return Information about the product.
   */
  @Override
  public String toString() {
    return "Name: "+name+"\nManufacturer: "+manufacturer+"\nType: "+type.type();
  }

}

/**
 * Used to test the ProductLike application.
 *
 * @author Zachary Maroney
 */
class Widget extends Product {

  /**
   * Test Product to make an actual Object.
   *
   * @param name Test product name.
   * @param manufacturer Test product manufacturer.
   * @param type Test product type.
   */
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

}

