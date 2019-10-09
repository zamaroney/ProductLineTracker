package ProductLine;

public abstract class Product implements Item {

  private int id;
  private String type;
  private String manufacturer;
  private String name;

  public Product (String name, String manufacturer, String type) {
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

  public String getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Name: "+name+"\nManufacturer: "+manufacturer+"\nType: "+type;
  }

}
class Widget extends Product {

  public Widget(String name, String manufacturer, String type) {
    super(name, manufacturer, type);
  }

}

