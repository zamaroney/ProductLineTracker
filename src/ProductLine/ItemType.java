package ProductLine;

public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  private final String value;

  ItemType(String value) {
    this.value = value;
  }
  public String code() {
    return this.value;
  }
}


