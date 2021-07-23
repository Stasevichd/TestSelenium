package UA.QA.FIRST;

public class UserDate {
  private final String firstName;
  private final String lastName;
  private final String nickName;

  public UserDate(String firstName, String lastName, String nickName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }
}
