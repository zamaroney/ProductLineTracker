package ProductLine;

/**
 * Simulates the functionality of a movie player and adds screen description to a possible product.
 *
 * @author Zachary Maroney
 */
public class MoviePlayer extends Product implements MultimediaControl {

  Screen screen;
  MonitorType monitorType;

  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  @Override
  public void next() {
    System.out.println("Next movie");
  }

  @Override
  public String toString() {
    return super.toString() + "\n" + screen.toString() + "\nMonitor Type: " + monitorType;
  }
}
