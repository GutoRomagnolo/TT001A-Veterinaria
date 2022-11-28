package model;

import static model.DAO.dateFormat;
import static model.DAO.getConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreatmentDAO extends DAO {
  private static TreatmentDAO instance;

  private TreatmentDAO() {
    getConnection();
    createTable();
  }

  public static TreatmentDAO getInstance() {
    return (instance == null ? (instance = new TreatmentDAO()) : instance);
  }

  public Treatment create(
    String name,
    Calendar initial_date,
    Calendar final_date,
    int animal_id,
    int has_finished
  ) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "INSERT INTO treatment (animal_id, name, initial_date, final_date, has_finished) VALUES (?, ?, ?, ?, ?)"
      );
      statement.setInt(1, animal_id);
      statement.setString(2, name);
      statement.setString(3, dateFormat.format(initial_date.getTime()));
      statement.setString(4, dateFormat.format(final_date.getTime()));
      statement.setInt(5, has_finished);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger.getLogger(TreatmentDAO.class.getName()).log(Level.SEVERE, null, exception);
    }
    return this.retrieveById(lastId("treatment", "id"));
  }

  private Treatment buildObject(ResultSet resultSet) {
    Treatment treatment = null;
    try {
      Calendar calendarDateOne = Calendar.getInstance();
      calendarDateOne.setTime(dateFormat.parse(resultSet.getString("initial_date")));
      Calendar calendarDateTwo = Calendar.getInstance();
      calendarDateTwo.setTime(dateFormat.parse(resultSet.getString("final_date")));
      treatment = new Treatment(
        resultSet.getInt("id"),
        resultSet.getString("name"),
        calendarDateOne,
        calendarDateTwo,
        resultSet.getInt("animal_id"),
        resultSet.getInt("has_finished")
      );
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    } catch (ParseException exception) {
      Logger.getLogger(TreatmentDAO.class.getName()).log(Level.SEVERE, null, exception);
    }
    return treatment;
  }

  public List retrieve(String query) {
    List<Treatment> treatments = new ArrayList();
    ResultSet resultSet = getResultSet(query);
    try {
      while (resultSet.next()) {
        treatments.add(buildObject(resultSet));
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
    return treatments;
  }

  public List retrieveAll() {
    return this.retrieve("SELECT * FROM treatment");
  }

  public List retrieveLast() {
    return this.retrieve(
      "SELECT * FROM treatment WHERE id = " + lastId("treatment", "id")
    );
  }

  public Treatment retrieveById(int id) {
    List<Treatment> treatments = this.retrieve("SELECT * FROM treatment WHERE id = " + id);
    return (treatments.isEmpty() ? null : treatments.get(0));
  }

  public List retrieveBySimilarName(String name) {
    return this.retrieve(
      "SELECT * FROM treatment WHERE name LIKE '%" + name + "%'"
    );
  }

  public void update(Treatment treatment) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "UPDATE treatment SET name = ?, initial_date = ?, final_date = ?, animal_id = ?, has_finished = ? WHERE id = ?"
      );
      statement.setString(1, treatment.getName());
      statement.setString(2, dateFormat.format(treatment.getInitialDate().getTime()));
      statement.setString(3, dateFormat.format(treatment.getFinalDate().getTime()));
      statement.setInt(4, treatment.getAnimalId());
      statement.setInt(5, treatment.getHasFinished());
      statement.setInt(6, treatment.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void delete(Treatment treatment) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement("DELETE FROM treatment WHERE id = ?");
      statement.setInt(1, treatment.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void deleteById(int id) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement("DELETE FROM treatment WHERE id =" + id);
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
