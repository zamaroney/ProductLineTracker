package ProductLine;

/**
 * Simulates the functionality of a audio player and adds audio description to a possible product.
 *
 * @author Zachary Maroney
 */
public class AudioPlayer extends Product implements MultimediaControl {

  /**
   * String that stores the supported audio formats for the audio device.
   */
  private String supportedAudioFormats;
  /**
   * String that stores the supported audio playlist for the audio device.
   */
  private String supportedPlaylistFormats;

  public AudioPlayer(String name, String manufacturer,
      String supportedAudioFormats, String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  /**
   * Simulates a play functionality.
   */
  @Override
  public void play() {
    System.out.println("Playing");
  }

  /**
   * Simulates a stop functionality.
   */
  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * Simulates a play previous functionality.
   */
  @Override
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * Simulates a play next functionality.
   */
  @Override
  public void next() {
    System.out.println("Next");
  }

  /**
   * @return String information about the audio player
   */
  @Override
  public String toString() {
    return super.toString() + "\nSupported Audio Formats: " + supportedAudioFormats
        + "\nSupported Playlist Formats: "
        + supportedPlaylistFormats;
  }
}
