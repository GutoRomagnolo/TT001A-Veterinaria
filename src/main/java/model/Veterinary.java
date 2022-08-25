package model;

public class Veterinary {
    private final int id;
    private String name;
    private String document_number;
    private String address;
    private String postal_code;
    private String complement;  
    private String phone;

    public Veterinary(int id, String name, String document_number, String address, String postal_code, String complement, String phone) {
        this.id = id;
        this.name = name;
        this.document_number = document_number;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
