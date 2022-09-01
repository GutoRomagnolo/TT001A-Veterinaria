package model;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CustomerDAO {
    private final List<Customer> customers = new ArrayList<>();
    private int customer_id = 1;
    
    public List<Customer> create(int number, String name, String email, String document_number, String address, String postal_code, String complement, String phone) {
        Customer customer = new Customer(customer_id, number, name, document_number, phone, email, postal_code, address, complement);
        this.customers.add(customer);
        customer_id++;
        return this.customers;
    }

    public List<Customer> retrieveAll() {
        return this.customers;
    }

    public List<Customer> retrieveByID(int id) {
        return (List<Customer>) this.customers.stream().filter(customer -> customer.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, int number, String name, String email, String document_number, String address, String postal_code, String complement, String phone) {
        Customer customer = this.customers.get(id - 1);
        customer.setName(name);
        customer.setDocumentNumber(document_number);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setPostalCode(postal_code);
        customer.setAddress(address);
        customer.setComplement(complement);

        return 1;
    }

    public int delete(int id) {
        this.customers.remove(id - 1);

        return 1;
    }
}