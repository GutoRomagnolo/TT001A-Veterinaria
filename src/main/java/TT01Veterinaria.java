import java.util.List;
import model.*;

public class TT01Veterinaria {
  public static void main(String args[]) {
    System.out.println("List customers");

    List<Customer> customers = CustomerDAO.getInstance().retrieveAll();

    for (Customer customer : customers) {
      System.out.println(
        "id=" + customer.getId() + ", name=" + customer.getName()
      );
    }

    System.out.println("List animals from customer 2");

    List<Animal> animals = AnimalDAO.getInstance().retrieveAnimalsByID(2);

    for (Animal animal : animals) {
      System.out.println(
        "id=" +
        animal.getId() +
        ", name=" +
        animal.getName() +
        ", customer_id=" +
        animal.getCustomerId()
      );
    }

    System.out.println("List animal especies");

    List<Specie> species = SpecieDAO.getInstance().retrieveAll();

    for (Specie specie : species) {
      System.out.println("id=" + specie.getId() + ", name=" + specie.getName());
    }

    System.out.println("List veterinary");

    List<Veterinary> veterinarians = VeterinaryDAO.getInstance().retrieveAll();

    for (Veterinary veterinary : veterinarians) {
      System.out.println(
        "document_number=" +
        veterinary.getDocumentNumber() +
        ", name=" +
        veterinary.getName()
      );
    }

    System.out.println("List treatments from animal 1");

    List<Treatment> treatments = TreatmentDAO
      .getInstance()
      .retrieveByAnimalId(1);

    for (Treatment treatment : treatments) {
      System.out.println(
        "animal_id=" +
        treatment.getAnimalId() +
        ", initial_date=" +
        treatment.getInitialDate()
      );
    }

    System.out.println("List appointments");

    List<Appointment> appointments = AppointmentDAO.getInstance().retrieveAll();

    for (Appointment appointment : appointments) {
      System.out.println(
        "id=" +
        appointment.getId() +
        ", date=" +
        appointment.getDate() +
        ", diagnosis=" +
        appointment.getDiagnosis()
      );
    }

    System.out.println("List exams");

    List<Exam> exams = ExamDAO.getInstance().retrieveAll();

    for (Exam exam : exams) {
      System.out.println(
        "id=" + exam.getId() + ", description=" + exam.getDescription()
      );
    }
  }
}
