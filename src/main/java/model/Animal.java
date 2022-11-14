package model;

public class Animal {
  private final int id;
  private String name;
  private String birthday;
  private String gender;
  private int specie_id;
  private int customer_id;

  public Animal(
    int id,
    String name,
    String birthday,
    String gender,
    int specie_id,
    int customer_id
  ) {
    this.id = id;
    this.name = name;
    this.birthday = birthday;
    this.gender = gender;
    this.specie_id = specie_id;
    this.customer_id = customer_id;
  }

  public int getSpecieId() {
    return specie_id;
  }

  public void setSpecieId(int specieId) {
    this.specie_id = specieId;
  }

  public int getCustomerId() {
    return customer_id;
  }

  public void setCustomerId(int customerId) {
    this.customer_id = customerId;
  }

  public int getId() {
    return id;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public boolean setGender(String gender) {
    if(gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")){
        this.gender = gender;
        return true;
    }
    return false;
  }
}
