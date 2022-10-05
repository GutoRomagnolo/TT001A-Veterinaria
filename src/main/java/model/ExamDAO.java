package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamDAO extends DAO {
  private static ExamDAO instance;

  private ExamDAO() {
    getConnection();
    createTable();
  }

  public static ExamDAO getInstance() {
    return ((instance == null) ? (instance = new ExamDAO()) : instance);
  }

  public Exam create(
    String name,
    String result,
    String description,
    int appointment_id
  ) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "INSERT INTO exam (name, result, description, appointment_id) VALUES (?, ?, ?, ?)"
          );
      statement.setString(1, name);
      statement.setString(2, result);
      statement.setString(3, description);
      statement.setInt(4, appointment_id);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger
        .getLogger(ExamDAO.class.getName())
        .log(Level.SEVERE, null, exception);
    }

    return this.retrieveByID(lastId("exam", "id"));
  }

  public boolean isLastEmpty() {
    Exam lastExam =
      this.retrieveByID(lastId("exam", "id"));
    if (lastExam != null) {
      return lastExam.getDescription().trim().isEmpty();
    }

    return false;
  }

  private Exam buildObject(ResultSet result_set) {
    Exam exam = null;

    try {
      exam =
        new Exam(
          result_set.getInt("id"),
          result_set.getString("name"),
          result_set.getString("result"),
          result_set.getString("description"),
          result_set.getInt("appointment_id")
        );
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return exam;
  }

  public List retrieve(String query) {
    List<Exam> exams = new ArrayList();
    ResultSet result_set = getResultSet(query);

    try {
      while (result_set.next()) {
        exams.add(buildObject(result_set));
      }
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }

    return exams;
  }

  public List retrieveAll() {
    return this.retrieve("SELECT * FROM exam");
  }

  public List retrieveLast() {
    return this.retrieve(
        "SELECT * FROM exam WHERE id = " + lastId("exam", "id")
      );
  }

  public Exam retrieveByID(int id) {
    List<Exam> exams =
      this.retrieve("SELECT * FROM exam WHERE id = " + id);

    return (exams.isEmpty() ? null : exams.get(0));
  }

  public List retrieveByAppointmentId(String id) {
    return this.retrieve(
        "SELECT * FROM exam WHERE appointment_id = " + id
      );
  }

  public void update(Exam exam) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement(
            "UPDATE exam SET name = ?, result = ?, description = ?, appointment_id = ? WHERE id = ?"
          );
      statement.setString(1, exam.getName());
      statement.setString(2, exam.getResult());
      statement.setString(3, exam.getDescription());
      statement.setInt(4, exam.getAppointmentId());
      statement.setInt(5, exam.getId());
      executeUpdate(statement);
    } catch (SQLException e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }

  public void delete(Exam exam) {
    try {
      PreparedStatement statement;
      statement =
        DAO
          .getConnection()
          .prepareStatement("DELETE FROM exam WHERE id = ?");
      statement.setInt(1, exam.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
