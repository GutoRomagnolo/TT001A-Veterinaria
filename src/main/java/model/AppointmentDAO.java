package model;

import static model.DAO.getConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppointmentDAO extends DAO {

  private static AppointmentDAO instance;

  private AppointmentDAO() {
    getConnection();
    createTable();
  }

  public static AppointmentDAO getInstance() {
    return (instance == null ? (instance = new AppointmentDAO()) : instance);
  }

  public Appointment create(
    Calendar date,
    int hour,
    String comments,
    int animal_id,
    int veterinarian_id,
    int treatment_id,
    int has_finished
  ) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "INSERT INTO appointment (date, hour, comments, animal_id, veterinarian_id, treatment_id, has_finished) VALUES (?,?,?,?,?,?,?)"
      );
      statement.setDate(1, new Date(date.getTimeInMillis()));
      statement.setInt(2, hour);
      statement.setString(3, comments);
      statement.setInt(4, animal_id);
      statement.setInt(5, veterinarian_id);
      statement.setInt(6, treatment_id);
      statement.setInt(7, has_finished);
      executeUpdate(statement);
    } catch (SQLException ex) {
      Logger
        .getLogger(AppointmentDAO.class.getName())
        .log(Level.SEVERE, null, ex);
    }
    return this.retrieveById(lastId("appointment", "id"));
  }

  private Appointment buildObject(ResultSet result) {
    Appointment appointment = null;
    try {
      Calendar dt = Calendar.getInstance();
      appointment = new Appointment(
        result.getInt("id"),
        dt,
        result.getInt("hour"),
        result.getString("comments"),
        result.getInt("animal_id"),
        result.getInt("veterinarian_id"),
        result.getInt("treatment_id"),
        result.getInt("has_finished") == 1
      );
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
    return appointment;
  }

  public List retrieve(String query) {
    List<Appointment> appointments = new ArrayList();
    ResultSet result = getResultSet(query);
    try {
      while (result.next()) {
        appointments.add(buildObject(result));
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
    return appointments;
  }

  public List retrieveAll() {
    return this.retrieve("SELECT * FROM appointment ORDER BY date, hour");
  }

  public List retrieveLast() {
    return this.retrieve(
      "SELECT * FROM appointment WHERE id = " + lastId("appointment", "id")
    );
  }

  public Appointment retrieveById(int id) {
    List<Appointment> appointments = this.retrieve("SELECT * FROM appointment WHERE id = " + id);
    return (appointments.isEmpty() ? null : appointments.get(0));
  }

  public List retrieveByAnimalId(int id) {
    List<Appointment> appointments = this.retrieve("SELECT * FROM appointment WHERE animal_id = " + id);
    return appointments;
  }

  public List retrieveByVeterinarianId(int id) {
    List<Appointment> appointments = this.retrieve("SELECT * FROM appointment WHERE veterinarian_id = " + id);
    return appointments;
  }

  public List retrieveByTreatmentId(int id) {
    List<Appointment> appointments = this.retrieve("SELECT * FROM appointment WHERE treatment_id = " + id);
    return appointments;
  }

  public void update(Appointment appointment) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "UPDATE appointment SET date = ?, hour = ?, comments = ?, animal_id = ?, veterinarian_id = ?, treatment_id = ?, has_finished = ? WHERE id = ?"
      );
      statement.setDate(1, new Date(appointment.getDate().getTimeInMillis()));
      statement.setInt(2, appointment.getHour());
      statement.setString(3, appointment.getComments());
      statement.setInt(4, appointment.getAnimalId());
      statement.setInt(5, appointment.getVeterinarianId());
      statement.setInt(6, appointment.getTreatmentId());
      statement.setBoolean(7, appointment.getHasFinished());
      statement.setInt(8, appointment.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void delete(Appointment appointment) {
    PreparedStatement statement;
    try {
      statement =DAO.getConnection().prepareStatement("DELETE FROM appointment WHERE id = ?");
      statement.setInt(1, appointment.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void deleteById(int id) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement("DELETE FROM appointment WHERE id = " + id);
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void deleteByAnimalId(int id) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement("DELETE FROM appointment WHERE animal_id = " + id);
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void deleteByVeterinarianId(int id) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement(
        "DELETE FROM appointment WHERE veterinarian_id =" + id
      );
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void deleteByTreatmentId(int id) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement(
        "DELETE FROM appointment WHERE treatment_id =" + id
      );
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
