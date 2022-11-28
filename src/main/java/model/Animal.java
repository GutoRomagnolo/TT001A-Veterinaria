package model;

public class Animal {

  private int id;
  private String name;
  private int birthday;
  private String gender; // Macho, Femea
  private int specieId;
  private int customerId;

  public Animal(
    int id,
    String name,
    int birthday,
    String gender,
    int specieId,
    int customerId
  ) {
    this.id = id;
    this.name = name;
    this.birthday = birthday;
    this.gender = gender;
    this.specieId = specieId;
    this.customerId = customerId;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBirthday() {
    return birthday;
  }

  public void setBirthday(int birthday) {
    this.birthday = birthday;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getSpecieId() {
    return specieId;
  }

  public void setSpecieId(int specieId) {
    this.specieId = specieId;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  @Override
  public String toString() {
    return "Animal{" + "name=" + name + '}';
  }
}
