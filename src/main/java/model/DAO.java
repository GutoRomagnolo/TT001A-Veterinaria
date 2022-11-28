package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO {
  public static final String DBURL = "jdbc:sqlite:TEST.db";
  private static Connection db;
  protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

  public static Connection getConnection() {
    if (db == null) {
      try {
        db = DriverManager.getConnection(DBURL);
        if (db != null) {
          DatabaseMetaData meta = db.getMetaData();
        }
      } catch (SQLException exception) {
        System.err.println("Exception: " + exception.getMessage());
      }
    }
    return db;
  }

  protected ResultSet getResultSet(String query) {
    Statement statement;
    ResultSet resultSet = null;
    try {
      statement = (Statement) db.createStatement();
      resultSet = statement.executeQuery(query);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
    return resultSet;
  }

  protected int executeUpdate(PreparedStatement queryStatement)
    throws SQLException {
    int update;
    update = queryStatement.executeUpdate();
    return update;
  }

  protected int lastId(String tableName, String primaryKey) {
    Statement statement;
    int lastId = -1;
    try {
      statement = (Statement) db.createStatement();
      ResultSet resultSet = statement.executeQuery(
        "SELECT MAX(" + primaryKey + ") AS id FROM " + tableName
      );
      if (resultSet.next()) {
        lastId = resultSet.getInt("id");
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
    return lastId;
  }

  public static void endConnection() {
    try {
      (DAO.getConnection()).close();
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  protected final boolean createTable() {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS customer( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "name VARCHAR, \n" +
            "address VARCHAR, \n" +
            "zip_code VARCHAR, \n" +
            "email VARCHAR, \n" +
            "phone VARCHAR); \n"
          );
      executeUpdate(statement);
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS animal( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "name VARCHAR, \n" +
            "birthday INTEGER, \n" +
            "gender VARCHAR, \n" +
            "specie_id INTEGER, \n" +
            "customer_id INTEGER); \n"
          );
      executeUpdate(statement);
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS specie( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "name VARCHAR); \n"
          );
      executeUpdate(statement);
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS veterinarian( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "name VARCHAR, \n" +
            "email VARCHAR, \n" +
            "phone VARCHAR); \n"
          );
      executeUpdate(statement);
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS treatment( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "animal_id INTEGER, \n" +
            "name VARCHAR, \n" +
            "initial_date TEXT, \n" +
            "final_date TEXT, \n" +
            "has_finished INTEGER); \n"
          );
      executeUpdate(statement);
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS appointment( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "date DATE, \n" +
            "hour VARCHAR, \n" +
            "comments VARCHAR, \n" +
            "animal_id INTEGER, \n" +
            "veterinarian_id INTEGER, \n" +
            "treatment_id INTEGER, \n" +
            "has_finished INTEGER); \n"
          );
      executeUpdate(statement);
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "CREATE TABLE IF NOT EXISTS exam( \n" +
            "id INTEGER PRIMARY KEY, \n" +
            "date DATE, \n" +
            "description VARCHAR, \n" +
            "animal_id INTEGER); \n"
          );
      executeUpdate(statement);
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "INSERT OR IGNORE INTO specie (id, name) VALUES (1, 'Dog')"
          );
      executeUpdate(statement);
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }
}
