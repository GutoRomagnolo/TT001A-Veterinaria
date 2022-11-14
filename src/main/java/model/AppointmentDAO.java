package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
    return ((instance == null) ? (instance = new AppointmentDAO()) : instance);
  }

  public Appointment create(
    Calendar date,
    String symptoms,
    String diagnosis,
    int treatment_id,
    int veterinary_id,
    int animal_id,
    boolean has_finished
  ) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "INSERT INTO appointment("
            + "date,"
            + "symptoms,"
            + "diagnosis,"
            + "treatment_id,"
            + "veterinary_id,"
            + "animal_id,"
            + "has_finished"
            + ") VALUES (?, ?, ?, ?, ?, ?, ?)"
          );
      statement.setString(1, dateFormat.format(date.getTime()));
      statement.setString(2, symptoms);
      statement.setString(3, diagnosis);
      statement.setInt(4, treatment_id);
      statement.setInt(5, veterinary_id);
      statement.setInt(6, animal_id);
      statement.setBoolean(7, has_finished);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger
        .getLogger(AppointmentDAO.class.getName())
        .log(Level.SEVERE, null, exception);
    }

    return this.retrieveByID(lastId("appointment", "id"));
  }

  public boolean isLastEmpty() {
    Appointment lastAppointment =
      this.retrieveByID(lastId("appointment", "id"));
    if (lastAppointment != null) {
      return lastAppointment.getDate().trim().isEmpty();
    }

    return false;
  }

  private Appointment buildObject(ResultSet result_set) {
    Appointment appointment = null;

    try {
      Calendar date = Calendar.getInstance();
      date.setTime(dateFormat.parse(result_set.getString("date")));
        
      appointment =
        new Appointment(
          result_set.getInt("id"),
          date,
          result_set.getString("symptoms"),
          result_set.getString("diagnosis"),
          result_set.getInt("treatment_id"),
          result_set.getInt("veterinary_id"),
          result_set.getInt("animal_id"),
          result_set.getBoolean("has_finished")
        );
    } catch (SQLException | ParseException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return appointment;
  }

  public List retrieve(String query) {
    List<Appointment> appointments = new ArrayList();
    ResultSet result_set = getResultSet(query);

    try {
      while (result_set.next()) {
        appointments.add(buildObject(result_set));
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return appointments;
  }

  public List retrieveAll() {
    return this.retrieve("SELECT * FROM appointment");
  }

  public List retrieveLast() {
    return this.retrieve(
      "SELECT * FROM appointment WHERE id = " + lastId("appointment", "id")
    );
  }
  
  public Appointment retrieveByID(int id) {
    List<Appointment> appointments =
      this.retrieve("SELECT * FROM appointment WHERE id = " + id);

    return (appointments.isEmpty() ? null : appointments.get(0));
  }

  public List retrieveByTreatmentId(int id) {
    return this.retrieve(
      "SELECT * FROM appointment WHERE treatment_id = " + id
    );
  }

  public List retrieveByVeterinaryId(int id) {
    return this.retrieve(
      "SELECT * FROM appointment WHERE veterinary_id = " + id
    );
  }

  public List retrieveByAnimalId(int id) {
    return this.retrieve(
      "SELECT * FROM appointment WHERE animal_id = " + id
    );
  }

  public void update(Appointment appointment) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "UPDATE appointment SET date = ?,"
            + "symptoms = ?,"
            + "diagnosis = ?,"
            + "treatment_id = ?,"
            + "veterinary_id = ?,"
            + "animal_id = ?,"
            + "has_finished = ?"
            + "WHERE id = ?"
          );
      statement.setString(1, appointment.getDate());
      statement.setString(2, appointment.getSymptoms());
      statement.setString(3, appointment.getDiagnosis());
      statement.setInt(4, appointment.getTreatmentId());
      statement.setInt(5, appointment.getVeterinaryId());
      statement.setInt(6, appointment.getAnimalId());
      statement.setInt(7, appointment.getId());
      statement.setInt(8, appointment.getHasFinished() == true ? 1 : 0);
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public List retrieveByFilter(String day, String symptoms, String customerName, String veterinaryName, String treatmentName, int finishedAppointments){
    return this.retrieve("SELECT appointment.id, appointment.date, appointment.symptoms, appointment.diagnosis, appointment.animal_id, appointment.veterinary_id, appointment.treatment_id, appointment.has_finished FROM appointment appointment INNER JOIN animal animal "
      + "ON appointment.animal_id = animal.id "
      + "INNER JOIN veterinary veterinary "
      + "ON appointment.veterinary_id = veterinary.id "
      + "INNER JOIN customer customer "
      + "ON animal.customer_id = customer.id "
      + "INNER JOIN treatment treatment "
      + "ON appointment.treatment_id = treatment.id "
      + "WHERE veterinary.name LIKE '%" + veterinaryName
      + "%' AND customer.name LIKE '%" + customerName
      + "%' AND treatment.name LIKE '%" + treatmentName
      + "%' AND appointment.has_finished = " + finishedAppointments
      + " AND appointment.date LIKE '%" + day
      + "%' AND symptoms LIKE '%" + symptoms + "%'");
  }

  public void delete(Appointment appointment) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement("DELETE FROM appointment WHERE id = ?");
      statement.setInt(1, appointment.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
