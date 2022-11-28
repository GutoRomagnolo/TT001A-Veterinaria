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
    return (instance == null ? (instance = new CustomerDAO()) : instance);
  }

  public Customer create(
    String name,
    String address,
    String zipCode,
    String email,
    String phone
  ) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "INSERT INTO customer (name, address, zip_code, email, phone) VALUES (?, ?, ?, ?, ?)"
      );
      statement.setString(1, name);
      statement.setString(2, address);
      statement.setString(3, zipCode);
      statement.setString(4, email);
      statement.setString(5, phone);
      executeUpdate(statement);
    } catch (SQLException ex) {
      Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return this.retrieveById(lastId("customer", "id"));
  }

  public boolean isLastEmpty() {
    Customer lastCustomer = this.retrieveById(lastId("customer", "id"));
    if (lastCustomer != null) {
      return lastCustomer.getName().isBlank();
    }
    return false;
  }

  private Customer buildObject(ResultSet result) {
    Customer customer = null;
    try {
      customer = new Customer(
        result.getInt("id"),
        result.getString("name"),
        result.getString("address"),
        result.getString("zip_code"),
        result.getString("email"),
        result.getString("phone")
      );
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
    return customer;
  }

  public List retrieve(String query) {
    List<Customer> customers = new ArrayList();
    ResultSet result = getResultSet(query);
    try {
      while (result.next()) {
        customers.add(buildObject(result));
      }
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
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

  public Customer retrieveById(int id) {
    List<Customer> customers =
      this.retrieve("SELECT * FROM customer WHERE id = " + id);
    return (customers.isEmpty() ? null : customers.get(0));
  }

  public List retrieveBySimilarName(String name) {
    return this.retrieve(
      "SELECT * FROM customer WHERE name LIKE '%" + name + "%'"
    );
  }

  public void update(Customer customer) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "UPDATE customer SET name = ?, address = ?, zip_code = ?, email = ?, phone = ? WHERE id = ?"
      );
      statement.setString(1, customer.getName());
      statement.setString(2, customer.getAddress());
      statement.setString(3, customer.getZipCode());
      statement.setString(4, customer.getEmail());
      statement.setString(5, customer.getPhone());
      statement.setInt(6, customer.getId());
      executeUpdate(statement);
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }

  public void delete(Customer customer) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement("DELETE FROM customer WHERE id = ?");
      statement.setInt(1, customer.getId());
      executeUpdate(statement);
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }
}
