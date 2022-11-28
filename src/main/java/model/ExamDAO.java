package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
    return (instance == null ? (instance = new ExamDAO()) : instance);
  }

  public Exam create(Calendar date, String name, int animalId) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "INSERT INTO exam (date, description, animal_id) VALUES (?, ?, ?)"
      );
      statement.setDate(1, new Date(date.getTimeInMillis()));
      statement.setString(2, name);
      statement.setInt(3, animalId);
      executeUpdate(statement);
    } catch (SQLException exception) {
      Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, exception);
    }
    return this.retrieveById(lastId("exam", "id"));
  }

  private Exam buildObject(ResultSet resultSet) {
    Exam exam = null;
    try {
      Calendar dt = Calendar.getInstance();
      dt.setTime(resultSet.getDate("date"));
      exam = new Exam(
        resultSet.getInt("id"),
        dt,
        resultSet.getString("description"),
        resultSet.getInt("animal_id")
      );
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
    return exam;
  }

  public List retrieve(String query) {
    List<Exam> exams = new ArrayList();
    ResultSet resultSet = getResultSet(query);
    try {
      while (resultSet.next()) {
        exams.add(buildObject(resultSet));
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

  public Exam retrieveById(int id) {
    List<Exam> exams = this.retrieve("SELECT * FROM exam WHERE id = " + id);
    return (exams.isEmpty() ? null : exams.get(0));
  }

  public List retrieveByAnimalId(int animal_id) {
    return this.retrieve("SELECT * FROM exam WHERE animal_id = " + animal_id);
  }

  public List retrieveBySimilarName(String name) {
    return this.retrieve(
      "SELECT * FROM exam WHERE description LIKE '%" + name + "%'"
    );
  }

  public void update(Exam exam) {
    try {
      PreparedStatement statement;
      statement = DAO.getConnection().prepareStatement(
        "UPDATE exam SET date = ?,description = ?, animal_id = ? WHERE id = ?"
      );
      statement.setDate(1, new Date(exam.getDate().getTimeInMillis()));
      statement.setString(2, exam.getDescription());
      statement.setInt(3, exam.getAnimalId());
      statement.setInt(4, exam.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }

  public void delete(Exam exam) {
    PreparedStatement statement;
    try {
      statement = DAO.getConnection().prepareStatement("DELETE FROM exam WHERE id = ?");
      statement.setInt(1, exam.getId());
      executeUpdate(statement);
    } catch (SQLException exception) {
      System.err.println("Exception: " + exception.getMessage());
    }
  }
}
