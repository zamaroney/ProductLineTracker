package zamaroney.github.io;

import java.util.Scanner;

class EmployeeDriver {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter Employee Name (first last)");
    String name = scan.nextLine();
    System.out.println("Enter Employee password");
    String password = scan.nextLine();
    Employee employee = new Employee(name, password);
    System.out.println(employee);
  }
}
