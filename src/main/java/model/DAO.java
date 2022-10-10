package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO {
  public static final String DBURL = "jdbc:sqlite:basdasdsa.db";
  private static Connection con;
  protected static SimpleDateFormat dateFormat = new SimpleDateFormat(
    "dd/MM/yyyy"
  );

  public static Connection getConnection() {
    if (con == null) {
      try {
        con = DriverManager.getConnection(DBURL);
        if (con != null) {
          DatabaseMetaData meta = con.getMetaData();
        }
      } catch (SQLException e) {
        System.err.println("Exception: " + e.getMessage());
      }
    }
    return con;
  }

  protected ResultSet getResultSet(String query) {
    Statement s;
    ResultSet rs = null;
    try {
      s = (Statement) con.createStatement();
      rs = s.executeQuery(query);
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
    return rs;
  }

  protected int executeUpdate(PreparedStatement queryStatement)
    throws SQLException {
    int update;
    update = queryStatement.executeUpdate();
    return update;
  }

  protected int lastId(String tableName, String primaryKey) {
    Statement s;
    int lastId = -1;
    try {
      s = (Statement) con.createStatement();
      ResultSet rs = s.executeQuery(
        "SELECT MAX(" + primaryKey + ") AS id FROM " + tableName
      );
      if (rs.next()) {
        lastId = rs.getInt("id");
      }
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
    return lastId;
  }

  public static void terminar() {
    try {
      (DAO.getConnection()).close();
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }

  // Create table SQLite
  protected final boolean createTable() {
    try {
      PreparedStatement stmt;
      stmt =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS customer( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "number INTEGER, \n" +
            "name VARCHAR, \n" +
            "email VARCHAR, \n" +
            "document_number VARCHAR, \n" +
            "address VARCHAR, \n" +
            "postal_code VARCHAR, \n" +
            "complement VARCHAR, \n" +
            "phone VARCHAR); \n"
          );

      executeUpdate(stmt);
      stmt =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS animal( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "birthday VARCHAR, \n" +
            "name VARCHAR, \n" +
            "gender INTEGER, \n" +
            "specie_id INTEGER, \n" +
            "customer_id INTEGER, \n" +
            "FOREIGN KEY (specie_id) REFERENCES specie(id), \n" +
            "FOREIGN KEY (customer_id) REFERENCES customer(id)); \n"
          );

      executeUpdate(stmt);
      stmt =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS specie( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "name VARCHAR); \n"
          );

      executeUpdate(stmt);
      stmt =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS veterinary( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "name VARCHAR, \n" +
            "document_number VARCHAR, \n" +
            "email VARCHAR, \n" +   
            "address VARCHAR, \n" +
            "number INTEGER, \n" +
            "postal_code VARCHAR, \n" +
            "complement VARCHAR, \n" +
            "phone VARCHAR); \n"
          );

      executeUpdate(stmt);
      stmt =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS treatment( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "name VARCHAR, \n" +
            "history TEXT, \n" +
            "initial_date DATE, \n" +
            "final_date DATE, \n" +
            "animal_id INTEGER); \n"
          );

      executeUpdate(stmt);
      stmt =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS appointment( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "date DATE, \n" +
            "symptoms VARCHAR, \n" +
            "diagnosis VARCHAR, \n" +
            "veterinary_id INTEGER, \n" +
            "treatment_id INTEGER, \n" +
            "animal_id INTEGER); \n"
          );

      executeUpdate(stmt);
      stmt =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS exam( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "name VARCHAR, \n" +
            "description VARCHAR, \n" +
            "result VARCHAR, \n" +
            "appointment_id INTEGER); \n"
          );

      executeUpdate(stmt);
      return true;
    } catch (SQLException exception) {
      Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, exception);
    }
    return false;
  }
}
