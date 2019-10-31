package ProductLine;

/**
 * Initializes methods that allows classes to grab provate properties about a Screen.
 *
 * @author Zachary Maroney
 */
public interface ScreenSpec {
  public String getResolution();
  public int getRefreshRate();
  public int getResponseTime();
}
