package zamaroney.github.io;

/**
 * Initializes methods that allows classes to grab provate properties about a Screen.
 *
 * @author Zachary Maroney
 */
public interface ScreenSpec {

  /**
   * Get the resolution.
   *
   * @return Resolution of the screen.
   */
  public String getResolution();

  /**
   * Get the refresh rate.
   *
   * @return Refresh rate of the screen.
   */
  public int getRefreshRate();

  /**
   * Get the response time.
   *
   * @return Response time of the screen.
   */
  public int getResponseTime();
}
