import java.util.List;
import model.*;

public class TT01Veterinaria {

  public static void main(String args[]) {
    System.out.println("Registering new customer...");
    CustomerDAO
      .getInstance()
      .create(
        "Gustavo Romagnolo",
        "guto@teste.com.br",
        "563498862",
        "Rua das cerejeiras",
        82,
        "12459732",
        "Apto 32",
        "17983738293"
      );

    System.out.println("\n");

    System.out.println("Listing new customer");
    List<Customer> customers = CustomerDAO.getInstance().retrieveAllCustomers();

    customers.forEach(customer -> {
      System.out.println("Customer ID is: " + customer.getId() + " and his name: " + customer.getName());
    });

    System.out.println("\n");

    System.out.println("Registering new animal...");
    AnimalDAO.getInstance().create("Gragas", "22/04/2020", 1, 2, 1);

    System.out.println("\n");

    System.out.println("Listing animals from customers");
    List<Animal> animals = AnimalDAO.getInstance().retrieveAnimalsByID(1);

    animals.forEach(animal -> {
      System.out.println("Animal ID is: " + animal.getId() + ", name is: " + animal.getName() + " and ID of his customer is: " + animal.getCustomerId());
    });

    System.out.println("\n");

    System.out.println("Registering new specie...");
    SpecieDAO.getInstance().create("Calopsita");

    System.out.println("\n");

    System.out.println("Listing animal especies");
    List<Specie> species = SpecieDAO.getInstance().retrieveAll();

    species.forEach(specie -> {
      System.out.println("Specie ID is: " + specie.getId() + " and his name is: " + specie.getName());
    });

    System.out.println("\n");

    System.out.println("Listing appointments");
    List<Appointment> appointments = AppointmentDAO.getInstance().retrieveAll();

    appointments.forEach(appointment -> {
      System.out.println("Appointment ID is: " + appointment.getId() + ", his date is: " + appointment.getDate() + " and diagnosis is: " + appointment.getDiagnosis());
    });

    System.out.println("\n");

    System.out.println("Register new exam");
    ExamDAO.getInstance().create(
      "Exame de sangue", 
      "Coletar índices sanguíneos", 
      "Baixa taxa de cálcio no sangue", 
      1
    );

    System.out.println("\n");

    System.out.println("List exams");
    List<Exam> exams = ExamDAO.getInstance().retrieveAll();

    exams.forEach(exam -> {
      System.out.println("Exam ID is: " + exam.getId() + " and his description is: " + exam.getDescription());
    });
  }
}