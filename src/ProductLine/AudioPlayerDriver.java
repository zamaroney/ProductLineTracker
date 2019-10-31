package ProductLine;

/**
 * Drive class to test the AudioPlayer class.
 *
 * @author Zachary Maroney
 */
public class AudioPlayerDriver {

  public static void testAudioPlayer() {
    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
        "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    System.out.println(newAudioProduct);
    newAudioProduct.play();
    newAudioProduct.stop();
    newAudioProduct.next();
    newAudioProduct.previous();
  }
}
