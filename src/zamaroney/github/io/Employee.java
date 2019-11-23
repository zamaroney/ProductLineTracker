package zamaroney.github.io;

/**
 * Declares Employee fields. Declares methods for Employee.
 *
 * @author Zachary Maroney
 */
public class Employee {

  /**
   * Employee's first and name.
   */
  private StringBuilder name;

  /**
   * Employee's username.
   */
  private String username;

  /**
   * Employee's password.
   */
  private String password;

  /**
   * Employee's email.
   */
  private String email;

  /**
   * Sets all the information about the employee.
   *
   * @param name     Employee's first and last name.
   * @param password Employee's password
   */
  public Employee(String name, String password) {
    this.name = new StringBuilder(name);
    if (checkName(name.toString())) {
      setUsername(name.toString());
      setEmail(name.toString());
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
    }
    if (!isValidPassword(password)) {
      this.password = "pw";
    } else {
      this.password = password;
    }
  }

  /**
   * Nice looking String for the user to see about the employee.
   *
   * @return Nice String
   */
  @Override
  public String toString() {
    return "Employee Details"
        + "\nName : " + name
        + "\nUsername : " + username
        + "\nEmail : " + email
        + "\nInitial Password : " + password;
  }

  /**
   * sets the username of the employee.
   *
   * @param name New Employee username to be set.
   */
  private void setUsername(String name) {
    String[] splitName = name.split("\\s");
    if (splitName.length > 1) {
      username = splitName[0].toLowerCase().charAt(0) + splitName[1].toLowerCase();
    }

  }

  /**
   * Checks if the user imputed a first name with a space followed by a last name.
   *
   * @param name Employee's first and last name.
   * @return If the name is a good name
   */
  private boolean checkName(String name) {
    String[] splitName = name.split("\\s");
    if (splitName.length == 2) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Sets the email to be the first and last name of the employee followed by @oracleacademy.Test
   *
   * @param name Employee's first and last name.
   */
  private void setEmail(String name) {
    String[] splitName = name.split("\\s");
    if (splitName.length > 1) {
      email = splitName[0].toLowerCase() + "." + splitName[1].toLowerCase() + "@oracleacademy.Test";
    }
  }

  /**
   * Checks if the password that the user inputed has lowercase letter, capital letter and a special
   * character.
   *
   * @param password Employee's password
   * @return if the password is valid or not.
   */
  private boolean isValidPassword(String password) {
    return password.matches("((?=.*[a-z])(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*[A-Z]).*)");
  }
}
