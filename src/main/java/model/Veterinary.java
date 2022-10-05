package model;

public class Veterinary {
  private final int id;
  private String name;
  private String document_number;
  private String email;
  private String address;
  private int number;
  private String postal_code;
  private String complement;
  private String phone;

  public Veterinary(
    int id,
    String name,
    String document_number,
    String email,
    String address,
    int number,
    String postal_code,
    String complement,
    String phone
  ) {
    this.id = id;
    this.name = name;
    this.document_number = document_number;
    this.email = email;
    this.address = address;
    this.number = number;
    this.postal_code = postal_code;
    this.complement = complement;
    this.phone = phone;
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

  public String getDocumentNumber() {
    return document_number;
  }

  public void setDocumentNumber(String document_number) {
    this.document_number = document_number;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getPostalCode() {
    return postal_code;
  }

  public void setPostalCode(String postal_code) {
    this.postal_code = postal_code;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
