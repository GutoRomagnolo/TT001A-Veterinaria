package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Treatment {
  private final int id;
  private String name;
  private String history;
  private Calendar initial_date;
  private Calendar final_date;
  private final int animal_id;

  public Treatment(
    int id,
    String name,
    String history,
    Calendar initial_date,
    Calendar final_date,
    int animal_id
  ) {
    this.id = id;
    this.name = name;
    this.history = history;
    this.initial_date = initial_date;
    this.final_date = final_date;
    this.animal_id = animal_id;
  }

  public int getId() {
    return id;
  }

  public int getAnimalId() {
    return animal_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHistory() {
    return history;
  }

  public void setHistory(String history) {
    this.history = history;
  }

  public String getInitialDate() {
    return dateFormat.format(initial_date.getTime());
  }

  public void setInitialDate(Calendar initial_date) {
    this.initial_date = initial_date;
  }

  public String getFinalDate() {
    return dateFormat.format(final_date.getTime()
  }

  public void setFinalDate(Calendar final_date) {
    this.final_date = final_date;
  }
}
