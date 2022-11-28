package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeterinaryDAO extends DAO {
  private static VeterinaryDAO instance;

  private VeterinaryDAO() {
    getConnection();
    createTable();
  }

  public static VeterinaryDAO getInstance() {
    return (instance == null ? (instance = new VeterinaryDAO()) : instance);
  }

  public Veterinary create(String name, String email, String phone) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "INSERT INTO veterinarian (name, email, phone) VALUES (?, ?, ?)"
      );
      statement.setString(1, name);
      statement.setString(2, email);
      statement.setString(3, phone);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger.getLogger(VeterinaryDAO.class.getName()).log(Level.SEVERE, null, exception);
    }
    return this.retrieveById(lastId("veterinarian", "id"));
  }

  private Veterinary buildObject(ResultSet resultSet) {
    Veterinary veterinarian = null;
    try {
      veterinarian = new Veterinary(
        resultSet.getInt("id"),
        resultSet.getString("name"),
        resultSet.getString("email"),
        resultSet.getString("phone")
      );
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
    return veterinarian;
  }

  public List retrieve(String query) {
    List<Veterinary> veterinarians = new ArrayList();
    ResultSet resultSet = getResultSet(query);
    try {
      while (resultSet.next()) {
        veterinarians.add(buildObject(resultSet));
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
    return veterinarians;
  }

  public List retrieveAll() {
    return this.retrieve("SELECT * FROM veterinarian");
  }

  public List retrieveLast() {
    return this.retrieve(
      "SELECT * FROM veterinarian WHERE id = " + lastId("veterinarian", "id")
    );
  }

  public Veterinary retrieveById(int id) {
    List<Veterinary> veterinarians = this.retrieve("SELECT * FROM veterinarian WHERE id = " + id);
    return (veterinarians.isEmpty() ? null : veterinarians.get(0));
  }

  public List retrieveBySimilarName(String name) {
    return this.retrieve(
      "SELECT * FROM veterinarian WHERE name LIKE '%" + name + "%'"
    );
  }

  public void update(Veterinary veterinarian) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "UPDATE veterinarian SET name = ?, email = ?, phone = ? WHERE id = ?"
      );
      statement.setString(1, veterinarian.getName());
      statement.setString(2, veterinarian.getEmail());
      statement.setString(3, veterinarian.getPhone());
      statement.setInt(4, veterinarian.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void delete(Veterinary veterinarian) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement("DELETE FROM veterinarian WHERE id = ?");
      statement.setInt(1, veterinarian.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
