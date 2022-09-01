import model.Customer;
import model.CustomerDAO;

public class TT01Veterinaria {
    public static void main(String args[]) {
        CustomerDAO customerDAO = new CustomerDAO();
       // int number, String name, String email, String document_number, String address, String postal_code, String complement, String phone
        customerDAO.create(82, "Carlos Alberto", "carluxo@gmail.com", "25425568", "Rua das Flores, Pinheiral", "123456764", "Apto 23", "17981873402");
        customerDAO.create(200, "Lucas Biscoito", "biscoito@gmail.com", "23423534", "Rua das Tequilas, Paulínia", "3453453235", "Casa 67", "1992155670");

        System.out.println(customerDAO.retrieveAll());
        System.out.println(customerDAO.retrieveByID(2));

        for (Customer customer:customerDAO.retrieveAll()) {
            System.out.println("id=" + customer.getId() + ", name=" + customer.getName());
        }

        customerDAO.update(1, 82, "Carlos Alberto Junior Castro", "carluxo@gmail.com", "25425568", "Rua das Flores, Pinheiral", "123456764", "Apto 26", "17981873402");
        System.out.println(customerDAO.retrieveAll());

        for (Customer customer:customerDAO.retrieveAll()) {
            System.out.println("id=" + customer.getId() + ", name=" + customer.getName());
        }

        customerDAO.delete(2);
        System.out.println(customerDAO.retrieveAll());

        for (Customer customer:customerDAO.retrieveAll()) {
            System.out.println("id=" + customer.getId() + ", name=" + customer.getName());
        }
    }
}