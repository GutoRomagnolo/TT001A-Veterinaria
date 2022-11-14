package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Appointment {
  private final int id;
  private Calendar date;
  private String symptoms;
  private String diagnosis;
  private final int treatment_id;
  private final int veterinary_id;
  private final int animal_id;
  private boolean has_finished; 

  public Appointment(
    int id,
    Calendar date,
    String symptoms,
    String diagnosis,
    int treatment_id,
    int veterinary_id,
    int animal_id,
    boolean has_finished
  ) {
    this.id = id;
    this.date = date;
    this.symptoms = symptoms;
    this.diagnosis = diagnosis;
    this.treatment_id = treatment_id;
    this.veterinary_id = veterinary_id;
    this.animal_id = animal_id;
    this.has_finished = has_finished;
  }
  
  protected static SimpleDateFormat dateFormat = new SimpleDateFormat(
    "dd/MM/yyyy"
  );


  public int getId() {
    return id;
  }

  public int getTreatmentId() {
    return treatment_id;
  }

  public int getVeterinaryId() {
    return veterinary_id;
  }

  public int getAnimalId() {
    return animal_id;
  }

  public String getDate() {
    return dateFormat.format(date.getTime());
  }

  public void setDate(Calendar date) {
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

  public Boolean getHasFinished() {
    return has_finished;
  }

  public void setHasFinished(Boolean has_finished) {
    this.has_finished = has_finished;
  }
}
