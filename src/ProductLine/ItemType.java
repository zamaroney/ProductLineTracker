package ProductLine;

/**
 * creates a set of static variables types with string associated with them that indicated the code
 * version of them and the text version of them.
 *
 * @author Zachary Maroney
 */
public enum ItemType {
  AUDIO("Audio", "AU"),
  VISUAL("Visual", "VI"),
  AUDIO_MOBILE("Audio Mobile", "AM"),
  VISUAL_MOBILE("Visual Mobile", "VM");

  /**
   * Good looking typed out ItemType.
   */
  private final String type;
  /**
   * Two length String code for the ItemType.
   */
  private final String code;

  /**
   * @param type Good looking typed out ItemType.
   * @param code Two length String code for the ItemType.
   */
  ItemType(String type, String code) {
    this.type = type;
    this.code = code;
  }

  /**
   * @return Good looking typed out ItemType.
   */
  public String type() {
    return this.type;
  }

  /**
   * @return Two length String code for the ItemType.
   */
  public String code() {
    return this.code;
  }
}


