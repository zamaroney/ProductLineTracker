package ProductLine;

public class AudioPlayer extends Product implements MultimediaControl {

  private String mediaType;

  private ItemType type = ItemType.AUDIO;

  public AudioPlayer(String name, String manufacturer, String audioSpecification,
      String mediaType) {
    super(name, manufacturer, audioSpecification);
    this.mediaType = mediaType;
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopped");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  @Override
  public String toString() {
    return "Name: " + getName() + "\nManufacturer: " + getManufacturer() + "\ntype: " + type
        + "\nSupported Audio Formats: " + getType() + "\nSupported Playlist Formats: "
        + mediaType;
  }
}
