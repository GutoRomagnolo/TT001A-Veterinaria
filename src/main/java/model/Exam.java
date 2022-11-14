package model;

public class Exam {
  private final int id;
  private String name;
  private String description;
  private String result;
  private final int appointment_id;

  public Exam(
    int id,
    String name,
    String description,
    String result,
    int appointment_id
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.result = result;
    this.appointment_id = appointment_id;
  }

  public int getId() {
    return id;
  }

  public int getAppointmentId() {
    return appointment_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
