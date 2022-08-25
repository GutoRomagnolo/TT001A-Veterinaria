package model;

public class Customer {
    private final int id;
    private int number;
    private String name;
    private String email;
    private String document_number;
    private String address;
    private String postal_code;
    private String complement;

    public Customer(int id, int number, String name, String email, String document_number, String address, String postal_code, String complement) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.email = email;
        this.document_number = document_number;
        this.address = address;
        this.postal_code = postal_code;
        this.complement = complement;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
