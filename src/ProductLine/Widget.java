package ProductLine;

import java.sql.Connection;
import java.sql.Statement;

public class Widget extends Product {

  final String JDBC_DRIVER = "org.h2.Driver";
  final String DB_URL = "jdbc:h2:./res/PR";
  final String USER = "";
  final String PASS = "";

  //  Database credentials
  Connection conn = null;
  // initialize connections
  Statement stmt = null;

  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

}
