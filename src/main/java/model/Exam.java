package model;

import java.util.Calendar;

public class Exam {
  private int id;
  private Calendar date;
  private String description;
  private int animalId;

  public Exam(int id, Calendar date, String description, int appointmentId) {
    this.id = id;
    this.date = date;
    this.description = description;
    this.animalId = appointmentId;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getAnimalId() {
    return animalId;
  }

  public void setAnimalId(int appointmentId) {
    this.animalId = appointmentId;
  }
}
