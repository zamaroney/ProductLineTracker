package zamaroney.github.io;

public class Employee {

  private String name;

  private String username;

  private String password;

  private String email;

  public Employee(String name, String password) {
    this.name = name;
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    }
    else {
      username = "default";
      email = "user@oracleacademy.Test";
    }
    if(!isValidPassword(password)){
      this.password = "pw";
    }
    else {
      this.password = password;
    }
  }

  @Override
  public String toString() {
    return "Employee Details"
        + "\nName : " + name
        + "\nUsername : " + username
        + "\nEmail : " + email
        + "\nInitial Password : " + password;
  }

  private void setUsername(String name) {
    String[] splitName = name.split("\\s");
    if (splitName.length > 1) {
      username = splitName[0].toLowerCase().charAt(0) + splitName[1].toLowerCase();
    }

  }

  private boolean checkName(String name) {
    String[] splitName = name.split("\\s");
    if (splitName.length == 2) {
      return true;
    }
    else {
      return false;
    }
  }

  private void setEmail(String name) {
    String[] splitName = name.split("\\s");
    if (splitName.length > 1) {
      email = splitName[0].toLowerCase() + "." + splitName[1].toLowerCase() + "@oracleacademy.Test";
    }
  }

  private boolean isValidPassword(String password) {
    return password.matches("((?=.*[a-z])(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*[A-Z]).*)");
  }
}
