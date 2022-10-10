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
    String email,
    String document_number,
    String address,
    int number,
    String postal_code,
    String complement,
    String phone
  ) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "INSERT INTO customer (name, email, document_number, address, number, postal_code, complement, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
          );
      statement.setString(1, name);
      statement.setString(2, email);
      statement.setString(3, document_number);
      statement.setString(4, address);
      statement.setInt(5, number);
      statement.setString(6, postal_code);  
      statement.setString(7, complement);
      statement.setString(8, phone);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger
        .getLogger(CustomerDAO.class.getName())
        .log(Level.SEVERE, null, exception);
    }

    return this.retrieveCustomerByID(lastId("customer", "id"));
  }

  public boolean isLastEmpty() {
    Customer lastCustomer = this.retrieveCustomerByID(lastId("customer", "id"));
    if (lastCustomer != null) {
      return lastCustomer.getName().trim().isEmpty();
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
          result_set.getString("email"),
          result_set.getString("document_number"),
          result_set.getString("address"),
          result_set.getInt("number"),    
          result_set.getString("postal_code"),
          result_set.getString("complement"),
          result_set.getString("phone")
        );
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return customer;
  }

  public List retrieveCustomer(String query) {
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

  public List retrieveAllCustomers() {
    return this.retrieveCustomer("SELECT * FROM customer");
  }

  public List retrieveLastCustomer() {
    return this.retrieveCustomer(
        "SELECT * FROM customer WHERE id = " + lastId("customer", "id")
      );
  }

  public Customer retrieveCustomerByID(int id) {
    List<Customer> customers =
      this.retrieveCustomer("SELECT * FROM customer WHERE id = " + id);

    return (customers.isEmpty() ? null : customers.get(0));
  }

  public List retrieveCustomerBySimilarName(String name) {
    return this.retrieveCustomer(
        "SELECT * FROM customer WHERE name LIKE '" + name + "'%"
      );
  }

  public void updateCustomer(Customer customer) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "UPDATE customer SET name = ?, document_number = ?, email = ?, postal_code = ?, address = ?, number = ?, complement = ?, phone = ? WHERE id = ?"
          );
      statement.setString(1, customer.getName());
      statement.setString(2, customer.getDocumentNumber());
      statement.setString(4, customer.getEmail());
      statement.setString(5, customer.getPostalCode());
      statement.setString(6, customer.getAddress());
      statement.setInt(7, customer.getNumber());
      statement.setString(8, customer.getComplement());
      statement.setString(3, customer.getPhone());
      statement.setInt(9, customer.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void deleteCustomer(Customer customer) {
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
