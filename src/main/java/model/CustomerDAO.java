package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO extends DAO {
  private static CustomerDAO instance;

  private CustomerDAO() {
    getConnection();
    createTable();
  }

  public static CustomerDAO getInstance() {
    return ((instance == null) ? (instance = new CustomerDAO()) : instance);
  }

  public Customer create(
    String name,
    String document_number,
    String phone,
    String email,
    String postal_code,
    String address,
    int number,
    String complement,
  ) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "INSERT INTO customer (name, document_number, phone, email, postal_code, address, number, complement) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
          );
      statement.setString(1, name);
      statement.setString(2, document_number);
      statement.setString(3, phone);
      statement.setString(4, email);
      statement.setString(5, postal_code);
      statement.setString(6, address);
      statement.setInt(7, number);
      statement.setString(8, complement);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger
        .getLogger(CustomerDAO.class.getName())
        .log(Level.SEVERE, null, exception);
    }

    return this.retrieveByID(lastId("customer", "id"));
  }

  public boolean isLastEmpty() {
    Customer lastCustomer = this.retrieveByID(lastId("customer", "id"));
    if (lastCustomer != null) {
      return lastCustomer.getName().isBlank();
    }

    return false;
  }

  private Customer buildObject(ResultSet result_set) {
    Customer customer = null;

    try {
      customer =
        new Customer(
          result_set.getInt("id"),
          result_set.getString("name"),
          result_set.getString("document_number"),
          result_set.getString("phone"),
          result_set.getString("email"),
          result_set.getString("postal_code"),
          result_set.getString("address"),
          result_set.getInt("number"),
          result_set.getString("complement")
        );
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return customer;
  }

  public List retrieve(String query) {
    List<Customer> customers = new ArrayList();
    ResultSet result_set = getResultSet(query);

    try {
      while (result_set.next()) {
        customers.add(buildObject(result_set));
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return customers;
  }

  public List retrieveAll() {
    return this.retrieve("SELECT * FROM customer");
  }

  public List retrieveLast() {
    return this.retrieve(
        "SELECT * FROM customer WHERE id = " + lastId("customer", "id")
      );
  }

  public Customer retrieveByID(int id) {
    List<Customer> customers =
      this.retrieve("SELECT * FROM customer WHERE id = " + id);

    return (customers.isEmpty() ? null : customers.get(0));
  }

  public List retrieveBySimilarName(String name) {
    return this.retrieve(
        "SELECT * FROM customer WHERE name LIKE '" + name + "'%"
      );
  }

  public void update(Customer customer) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "UPDATE customer SET name = ?, document_number = ?, phone = ?, email = ?, postal_code = ?, address = ?, number = ?, complement = ? WHERE id = ?"
          );
      statement.setString(1, customer.getName());
      statement.setString(2, customer.getDocumentNumber());
      statement.setString(3, customer.getPhone());
      statement.setString(4, customer.getEmail());
      statement.setString(5, customer.getPostalCode());
      statement.setString(6, customer.getAddress());
      statement.setInt(7, customer.getNumber());
      statement.setString(8, customer.getComplement());
      statement.setInt(9, customer.getId());
      executeUpdate(statement);
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }

  public void delete(Customer customer) {
    try {
      PreparedStatement statement;
      statement =
        DAO.getConnection().prepareStatement("DELETE FROM customer WHERE id = ?");
      statement.setInt(1, customer.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
