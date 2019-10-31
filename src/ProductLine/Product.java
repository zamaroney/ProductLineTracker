package ProductLine;

/**
 * Declares Product fields.
 * Declares nonabstract methods for Products.
 *
 * @author Zachary Maroney
 */
public abstract class Product implements Item {

  private int id;
  private ItemType type;
  private String manufacturer;
  private String name;

  public Product (String name, String manufacturer, ItemType type) {
    this.manufacturer = manufacturer;
    this.name = name;
    this.type = type;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Override
  public String getManufacturer() {
    return manufacturer;
  }

  public ItemType getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Name: "+name+"\nManufacturer: "+manufacturer+"\nType: "+type.type();
  }

}
class Widget extends Product {

  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

}

