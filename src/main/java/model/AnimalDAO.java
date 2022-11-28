package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimalDAO extends DAO {
  private static AnimalDAO instance;

  private AnimalDAO() {
    getConnection();
    createTable();
  }

  public static AnimalDAO getInstance() {
    return (instance == null ? (instance = new AnimalDAO()) : instance);
  }

  public Animal create(
    String name,
    int birthday,
    String gender,
    int specieId,
    Customer Customer
  ) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "INSERT INTO animal (name, birthday, gender, specie_id, customer_id) VALUES (?,?,?,?,?)"
          );
      statement.setString(1, name);
      statement.setInt(2, birthday);
      statement.setString(3, gender);
      statement.setInt(4, specieId);
      statement.setInt(5, Customer.getId());
      executeUpdate(statement);
    } catch (SQLException ex) {
      Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return this.retrieveById(lastId("Animal", "id"));
  }

  private Animal buildObject(ResultSet result) {
    Animal animal = null;
    try {
      animal =
        new Animal(
          result.getInt("id"),
          result.getString("name"),
          result.getInt("birthday"),
          result.getString("gender"),
          result.getInt("specie_id"),
          result.getInt("customer_id")
        );
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
    return animal;
  }

  public List retrieve(String query) {
    List<Animal> animals = new ArrayList();
    ResultSet result = getResultSet(query);
    try {
      while (result.next()) {
        animals.add(buildObject(result));
      }
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
    return animals;
  }

  public List retrieveAll() {
    return this.retrieve("SELECT * FROM animal");
  }

  public List retrieveLast() {
    return this.retrieve(
        "SELECT * FROM animal WHERE id = " + lastId("animal", "id")
      );
  }

  public Animal retrieveById(int id) {
    List<Animal> animals =
      this.retrieve("SELECT * FROM animal WHERE id = " + id);
    return (animals.isEmpty() ? null : animals.get(0));
  }

  public List retrieveByCustomerId(int customer_id) {
    return this.retrieve(
        "SELECT * FROM animal WHERE customer_id = " + customer_id
      );
  }

  public List retrieveBySpecieId(int specie_id) {
    return this.retrieve("SELECT * FROM animal WHERE specie_id = " + specie_id);
  }

  public List retrieveBySimilarName(int id, String name) {
    return this.retrieve(
      "SELECT * FROM animal WHERE customer_id = " +
      id +
      " AND name LIKE '%" +
      name +
      "%'"
    );
  }

  public void update(Animal animal) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "UPDATE animal SET name = ?, birthday = ?, gender = ?, specie_id = ?, customer_id = ? WHERE id = ?"
          );
      statement.setString(1, animal.getName());
      statement.setInt(2, animal.getBirthday());
      statement.setString(3, animal.getGender());
      statement.setInt(4, animal.getSpecieId());
      statement.setInt(5, animal.getCustomerId());
      statement.setInt(6, animal.getId());
      executeUpdate(statement);
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }

  public void delete(Animal animal) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement("DELETE FROM animal WHERE id = ?");
      statement.setInt(1, animal.getId());
      executeUpdate(statement);
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }
}
