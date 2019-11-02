package ProductLine;

/**
 * Simulates the functionality of a movie player and adds screen description to a possible product.
 *
 * @author Zachary Maroney
 */
public class MoviePlayer extends Product implements MultimediaControl {

  /**
   * The Resolution, refreshrate and response time.
   */
  private Screen screen;
  /**
   * The Enum MonitorType
   */
  private MonitorType monitorType;

  /**
   * @param name Product name.
   * @param manufacturer Product manufacturer.
   * @param screen Product screen details.
   * @param monitorType Product Monitor details.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * Simulates a play functionality.
   */
  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  /**
   * Simulates a stop functionality.
   */
  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /**
   * Simulates a play previous functionality.
   */
  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  /**
   * Simulates a play next functionality.
   */
  @Override
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * @return Information about the screen and Monitor type into a String.
   */
  @Override
  public String toString() {
    return super.toString() + "\n" + screen.toString() + "\nMonitor Type: " + monitorType;
  }
}
