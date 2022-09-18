package model;

public class Appointment {
  private final int id;
  private String date;
  private String symptoms;
  private String diagnosis;
  private int treatment_id;
  private int veterinary_id;

  public Appointment(
    int id,
    String date,
    String symptoms,
    String diagnosis,
    int treatment_id,
    int veterinary_id
  ) {
    this.id = id;
    this.date = date;
    this.symptoms = symptoms;
    this.diagnosis = diagnosis;
    this.treatment_id = treatment_id;
    this.veterinary_id = veterinary_id;
  }

  public int getId() {
    return id;
  }

  public int getTreatmentId() {
    return treatment_id;
  }

  public int getVeterinaryId() {
    return veterinary_id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public void setSymptoms(String symptoms) {
    this.symptoms = symptoms;
  }

  public String getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }
}
