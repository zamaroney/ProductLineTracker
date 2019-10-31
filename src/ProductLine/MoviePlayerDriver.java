package ProductLine;

/**
 * A test drive for the MoviePlayer class.
 *
 * @author Zachary Maroney
 */
public class MoviePlayerDriver {

  public static void testMoviePlayer() {
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
        MonitorType.LCD);
    System.out.println(newMovieProduct);
    newMovieProduct.play();
    newMovieProduct.stop();
    newMovieProduct.next();
    newMovieProduct.previous();
  }

}
