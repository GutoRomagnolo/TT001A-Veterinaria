package model;

import java.util.Calendar;

public class Appointment {

  private final int id;
  private Calendar date;
  private int hour;
  private String comments;
  private final int animalId;
  private final int veterinarianId;
  private final int treatmentId;
  private boolean hasFinished;

  public Appointment(
    int id,
    Calendar date,
    int hour,
    String comments,
    int animalId,
    int veterinarianId,
    int treatmentId,
    boolean hasFinished
  ) {
    this.id = id;
    this.date = date;
    this.hour = hour;
    this.comments = comments;
    this.animalId = animalId;
    this.veterinarianId = veterinarianId;
    this.treatmentId = treatmentId;
    this.hasFinished = hasFinished;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public int getAnimalId() {
    return animalId;
  }

  public int getVeterinarianId() {
    return veterinarianId;
  }

  public int getTreatmentId() {
    return treatmentId;
  }

  public boolean getHasFinished() {
    return hasFinished;
  }

  public void setHasFinished(boolean hasFinished) {
    this.hasFinished = hasFinished;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return (
      "Appointment{" +
      "id=" +
      id +
      ", date='" +
      date +
      '\'' +
      ", hour='" +
      hour +
      '\'' +
      ", comments='" +
      comments +
      '\'' +
      ", animalId=" +
      animalId +
      ", veterinarianId=" +
      veterinarianId +
      ", treatmentId=" +
      treatmentId +
      ", hasFinished=" +
      hasFinished +
      '}'
    );
  }
}
