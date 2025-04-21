package mn.and.datacollector.enumType;

public enum FlagStatus {
  ACTIVE(1),
  INACTIVE(0);

  private final int statusId;

  FlagStatus(int statusId) {
    this.statusId = statusId;
  }

  public int getStatusId() {
    return statusId;
  }
}
