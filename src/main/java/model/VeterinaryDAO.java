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
    return ((instance == null) ? (instance = new VeterinaryDAO()) : instance);
  }

  public Veterinary create(
    String name,
    String document_number,
    String email,
    String address,
    int number,
    String postal_code,
    String complement,
    String phone,
  ) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "INSERT INTO veterinary (name, document_number, email, address, number, postal_code, complement, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
          );
      statement.setString(1, name);
      statement.setString(2, document_number);
      statement.setString(3, email);
      statement.setString(4, address);
      statement.setInt(5, number);
      statement.setString(6, postal_code);
      statement.setString(7, complement);
      statement.setString(8, phone);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger
        .getLogger(VeterinaryDAO.class.getName())
        .log(Level.SEVERE, null, exception);
    }

    return this.retrieveByID(lastId("veterinary", "id"));
  }

  public boolean isLastEmpty() {
    Veterinary lastVeterinary = this.retrieveByID(lastId("veterinary", "id"));
    if (lastVeterinary != null) {
      return lastVeterinary.getName().isBlank();
    }

    return false;
  }

  private Veterinary buildObject(ResultSet result_set) {
    Veterinary veterinary = null;

    try {
      veterinary =
        new Veterinary(
          result_set.getInt("id"),
          result_set.getString("name"),
          result_set.getString("document_number"),
          result_set.getString("email"),
          result_set.getString("address"),
          result_set.getInt("number"),
          result_set.getString("postal_code"),
          result_set.getString("complement"),
          result_set.getString("phone")
        );
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return veterinary;
  }

  public List retrieve(String query) {
    List<Veterinary> veterinarians = new ArrayList();
    ResultSet result_set = getResultSet(query);

    try {
      while (result_set.next()) {
        veterinarians.add(buildObject(result_set));
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return veterinarians;
  }

  public List retrieveAll() {
    return this.retrieve("SELECT * FROM veterinary");
  }

  public List retrieveLast() {
    return this.retrieve(
        "SELECT * FROM veterinary WHERE id = " + lastId("veterinary", "id")
      );
  }

  public Veterinary retrieveByID(int id) {
    List<Veterinary> veterinarians =
      this.retrieve("SELECT * FROM veterinary WHERE id = " + id);

    return (veterinarians.isEmpty() ? null : veterinarians.get(0));
  }

  public List retrieveBySimilarName(String name) {
    return this.retrieve(
        "SELECT * FROM veterinary WHERE name LIKE '" + name + "'%"
      );
  }

  public void update(Veterinary veterinary) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "UPDATE veterinary SET name = ?, document_number = ?, email = ?, address = ?, number = ?, postal_code = ?, complement = ?, phone = ? WHERE id = ?"
          );
      statement.setString(1, veterinary.getName());
      statement.setString(2, veterinary.getDocumentNumber());
      statement.setString(3, veterinary.getEmail());
      statement.setString(4, veterinary.getAddress());
      statement.setInt(5, veterinary.getNumber());
      statement.setString(6, veterinary.getPostalCode());
      statement.setString(7, veterinary.getComplement());
      statement.setString(8, veterinary.getPhone());
      statement.setInt(9, veterinary.getId());
      executeUpdate(statement);
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }

  public void delete(Veterinary veterinary) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement("DELETE FROM veterinary WHERE id = ?");
      statement.setInt(1, veterinary.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
