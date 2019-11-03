package zamaroney.github.io;

/**
 * Define Screen fields that give information about the screen. Creates methods that allow other
 * classes to grab the information about a field.
 *
 * @author Zachary Maroney
 */
public class Screen implements ScreenSpec {

  /**
   * Resolution of the screen.
   */
  private String resolution;

  /**
   * Refresh rate of the screen.
   */
  private int refresherRate;

  /**
   * Response time of the screen.
   */
  private int responseTime;

  /**
   * Creates a Screen Object.
   *
   * @param resolution    String Resolution of the screen.
   * @param refresherRate int Refresh rate of the screen.
   * @param responseTime  int Response time of the screen.
   */
  public Screen(String resolution, int refresherRate, int responseTime) {
    this.resolution = resolution;
    this.responseTime = responseTime;
    this.refresherRate = refresherRate;
  }

  /**
   * Gets the resolution.
   *
   * @return Resolution of the screen.
   */
  @Override
  public String getResolution() {
    return resolution;
  }

  /**
   * Gets the refresh rate.
   *
   * @return Refresh rate of the screen.
   */
  @Override
  public int getRefreshRate() {
    return refresherRate;
  }

  /**
   * Gets the response time.
   *
   * @return Response time of the screen.
   */
  @Override
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * Gets the information about the screen in a String.
   *
   * @return Information about the screen specifics.
   */
  @Override
  public String toString() {
    return "Screen:\nResolution: " + resolution + "\nRefresh rate: " + refresherRate
        + "\nResponse time: "
        + responseTime;
  }
}
