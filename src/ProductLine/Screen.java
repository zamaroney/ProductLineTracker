package ProductLine;

/**
 * Define Screen fields that give information about the screen.
 * Creates methods that allow other classes to grab the information about a field.
 *
 * @author Zachary Maroney
 */
public class Screen implements ScreenSpec {

  private String resolution;
  private int refresherRate;
  private int responseTime;

  public Screen(String resolution, int refresherRate, int responseTime) {
    this.resolution = resolution;
    this.responseTime = responseTime;
    this.refresherRate = refresherRate;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refresherRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }

  @Override
  public String toString() {
    return "Screen:\nResolution: " + resolution + "\nRefresh rate: " + refresherRate + "\nResponse time: "
        + responseTime;
  }
}
