package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpecieDAO extends DAO {
  private static SpecieDAO instance;

  private SpecieDAO() {
    getConnection();
    createTable();
  }

  public static SpecieDAO getInstance() {
    return ((instance == null) ? (instance = new SpecieDAO()) : instance);
  }

  public Specie create(String name) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement("INSERT INTO specie (name) VALUES (?)");
      statement.setString(1, name);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger
        .getLogger(SpecieDAO.class.getName())
        .log(Level.SEVERE, null, exception);
    }

    return this.retrieveByID(lastId("specie", "id"));
  }

  public boolean isLastEmpty() {
    Specie lastSpecie = this.retrieveByID(lastId("specie", "id"));
    if (lastSpecie != null) {
      return lastSpecie.getName().trim().isEmpty();
    }

    return false;
  }

  private Specie buildObject(ResultSet result_set) {
    Specie specie = null;

    try {
      specie =
        new Specie(result_set.getInt("id"), result_set.getString("name"));
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return specie;
  }

  public List retrieve(String query) {
    List<Specie> species = new ArrayList();
    ResultSet result_set = getResultSet(query);

    try {
      while (result_set.next()) {
        species.add(buildObject(result_set));
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return species;
  }

  public List retrieveAll() {
    return this.retrieve("SELECT * FROM specie");
  }

  public List retrieveLast() {
    return this.retrieve(
        "SELECT * FROM specie WHERE id = " + lastId("specie", "id")
      );
  }

  public Specie retrieveByID(int id) {
    List<Specie> species =
      this.retrieve("SELECT * FROM specie WHERE id = " + id);

    return (species.isEmpty() ? null : species.get(0));
  }
  
  public Specie retrieveByName(String name){
    List<Specie> species = this.retrieve("SELECT * FROM specie WHERE name LIKE " + name );
    return (species.isEmpty() ? null: species.get(0));
  }

  public List retrieveBySimilarName(String name) {
    return this.retrieve(
        "SELECT * FROM specie WHERE name LIKE '" + name + "%'"
      );
  }

  public void update(Specie specie) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement("UPDATE specie SET name = ? WHERE id = ?");
      statement.setString(1, specie.getName());
      statement.setInt(2, specie.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void delete(Specie specie) {
    try {
      PreparedStatement statement;
      statement =
        DAO.getConnection().prepareStatement("DELETE FROM specie WHERE id = ?");
      statement.setInt(1, specie.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
