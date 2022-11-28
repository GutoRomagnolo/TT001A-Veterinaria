package model;

public class Customer {
  private final int id;
  private String name;
  private String address;
  private String phone;
  private String zipCode;
  private String email;

  public Customer(
    int id,
    String name,
    String address,
    String zipCode,
    String email,
    String phone
  ) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.zipCode = zipCode;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if (!email.equals("")) {
      this.email = email;
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    String description =
      "Customer{" +
      "name = " +
      name +
      ", address = " +
      address +
      ", phone = " +
      phone +
      ", zipCode = " +
      zipCode +
      ", email = " +
      email +
      '}';
    return description + "\n";
  }
}
