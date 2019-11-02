package ProductLine;

/**
 * Initializes methods that allows classes to grab provate properties about a Screen.
 *
 * @author Zachary Maroney
 */
public interface ScreenSpec {

  /**
   * @return Resolution of the screen.
   */
  public String getResolution();

  /**
   * @return Refresh rate of the screen.
   */
  public int getRefreshRate();

  /**
   * @return Response time of the screen.
   */
  public int getResponseTime();
}
