package model;

import java.util.Calendar;

public class Treatment {
  private final int id;
  private String name;
  private Calendar initialDate;
  private Calendar finalDate;
  private final int animalId;
  private int hasFinished;

  public Treatment(
    int id,
    String name,
    Calendar initialDate,
    Calendar finalDate,
    int animalId,
    int hasFinished
  ) {
    this.id = id;
    this.name = name;
    this.initialDate = initialDate;
    this.finalDate = finalDate;
    this.animalId = animalId;
    this.hasFinished = hasFinished;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Calendar getInitialDate() {
    return initialDate;
  }

  public void setInitialDate(Calendar initialDate) {
    this.initialDate = initialDate;
  }

  public Calendar getFinalDate() {
    return finalDate;
  }

  public void setFinalDate(Calendar finalDate) {
    this.finalDate = finalDate;
  }

  public int getAnimalId() {
    return animalId;
  }

  public int getHasFinished() {
    return hasFinished;
  }

  public void setHasFinished(int hasFinished) {
    this.hasFinished = hasFinished;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return (
      "Treatment{" +
      "id = " +
      id +
      ", name = " +
      name +
      '\'' +
      ", initialDate = " +
      initialDate +
      ", finalDate = " +
      finalDate +
      ", animalId = " +
      animalId +
      ", hasFinished = " +
      hasFinished +
      '}'
    );
  }
}
