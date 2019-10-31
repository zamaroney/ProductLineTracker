package ProductLine;

/**
 * creates methods to implement into other classes that would have some type of item.
 *
 * @author Zachary maroney
 */
public interface Item {

  public int getId();

  public void setName(String name);

  public String getName();

  public void setManufacturer(String manufacturer);

  public String getManufacturer();

}
