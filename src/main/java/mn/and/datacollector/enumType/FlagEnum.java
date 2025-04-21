package mn.and.datacollector.enumType;

public enum FlagEnum {
  REGULAR(0),
  WHITE(1),
  GRAY(2),
  BLACK(3);

  private final int flagId;

  FlagEnum(int flagId) {
    this.flagId = flagId;
  }

  public int getFlagId() {
    return flagId;
  }
}
