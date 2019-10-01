package ProductLine;

public enum ItemType {
  AUDIO("Audio", "AU"),
  VISUAL("Visual", "VI"),
  AUDIO_MOBILE("Audio Mobile", "AM"),
  VISUAL_MOBILE("Visual Mobile", "VM");

  private final String type;
  private final String code;

  ItemType(String type, String code) {
    this.type = type;
    this.code = code;
  }
  public String type() {
    return this.type;
  }

  public String code() {
    return this.code;
  }
}


