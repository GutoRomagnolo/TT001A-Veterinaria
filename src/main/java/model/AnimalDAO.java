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
    return ((instance == null) ? (instance = new AnimalDAO()) : instance);
  }

  public Animal create(
    String name,
    String birthday,
    String gender,
    int specie_id,
    int customer_id
  ) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "INSERT INTO animal (name, birthday, gender, specie_id, customer_id) VALUES (?, ?, ?, ?, ?)"
          );
      statement.setString(1, name);
      statement.setString(2, birthday);
      statement.setString(3, gender);
      statement.setInt(4, specie_id);
      statement.setInt(5, customer_id);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger
        .getLogger(AnimalDAO.class.getName())
        .log(Level.SEVERE, null, exception);
    }

    return this.retrieveByID(lastId("animal", "id"));
  }

  public boolean isLastEmpty() {
    Animal lastAnimal = this.retrieveByID(lastId("animal", "id"));
    if (lastAnimal != null) {
      return lastAnimal.getName().trim().isEmpty();
    }

    return false;
  }

  private Animal buildObject(ResultSet result_set) {
    Animal animal = null;

    try {
      animal =
        new Animal(
          result_set.getInt("id"),
          result_set.getString("name"),
          result_set.getString("birthday"),
          result_set.getString("gender"),
          result_set.getInt("specie_id"),
          result_set.getInt("customer_id")
        );
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return animal;
  }

  public List retrieve(String query) {
    List<Animal> animals = new ArrayList();
    ResultSet result_set = getResultSet(query);

    try {
      while (result_set.next()) {
        animals.add(buildObject(result_set));
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
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

  public Animal retrieveByID(int id) {
    List<Animal> animals =
      this.retrieve("SELECT * FROM animal WHERE id = " + id);

    return (animals.isEmpty() ? null : animals.get(0));
  }

  public List retrieveAnimalsByID(int id) {
    return this.retrieve("SELECT * FROM animal WHERE customer_id = " + id);
  }

  public List retrieveBySimilarName(String name) {
    return this.retrieve(
        "SELECT * FROM animal WHERE name LIKE '" + name + "'%"
      );
  }
  
  public List retrieveAnimalByCustomerID (int customerID) {
    return this.retrieve("SELECT * FROM animal WHERE customer_id = " + customerID);
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
      statement.setString(2, animal.getBirthday());
      statement.setString(3, animal.getGender());
      statement.setInt(4, animal.getSpecieId());
      statement.setInt(5, animal.getCustomerId());
      statement.setInt(6, animal.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void delete(Animal animal) {
    try {
      PreparedStatement statement;
      statement =
        DAO.getConnection().prepareStatement("DELETE FROM animal WHERE id = ?");
      statement.setInt(1, animal.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
