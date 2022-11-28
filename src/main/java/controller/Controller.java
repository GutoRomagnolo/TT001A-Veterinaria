package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import model.*;
import view.AnimalTableModel;
import view.CustomerTableModel;
import view.AppointmentTableModel;
import view.SpecieTableModel;
import view.ExamTableModel;
import view.GenericTableModel;
import view.VeterinaryTableModel;

public class Controller {
  private static Customer selectedCustomer = null;
  private static Animal selectedAnimal = null;
  private static Veterinary selectedVeterinarian = null;
  private static JTextField selectedCustomerTextField = null;
  private static JTextField selectedAnimalTextField = null;
  private static JTextField selectedVeterinarianTextField = null;

  public static void setTextFields(
    JTextField customer,
    JTextField animal,
    JTextField veterinarian
  ) {
    selectedCustomerTextField = customer;
    selectedAnimalTextField = animal;
    selectedVeterinarianTextField = veterinarian;
  }

  public static void setTableModel(JTable table, GenericTableModel tableModel) {
    table.setModel(tableModel);
  }

  public static Customer getSelectedCustomer() {
    return selectedCustomer;
  }

  public static Animal getSelectedAnimal() {
    return selectedAnimal;
  }

  public static void setSelected(Object selected) {
    if (selected == null) {
      selectedCustomer = null;
      selectedAnimal = null;
      selectedVeterinarian = null;
    }
    if (selected instanceof Customer) {
      selectedCustomer = (Customer) selected;
      selectedCustomerTextField.setText(selectedCustomer.getName());
      selectedAnimalTextField.setText("");
    } else if (selected instanceof Animal) {
      selectedAnimal = (Animal) selected;
      selectedAnimalTextField.setText(selectedAnimal.getName());
    } else if (selected instanceof Veterinary) {
      selectedVeterinarian = (Veterinary) selected;
      selectedVeterinarianTextField.setText(selectedVeterinarian.getName());
    }
  }

  //jradioButtons:

  public static void jradioButtonSelectedCustomer(JTable table) {
    setTableModel(
      table,
      new CustomerTableModel(CustomerDAO.getInstance().retrieveAll())
    );
  }

  public static boolean jradioButtonSelectedAnimals(JTable table) {
    if (getSelectedCustomer() != null) {
      setTableModel(
        table,
        new AnimalTableModel(
          AnimalDAO
            .getInstance()
            .retrieveByCustomerId(getSelectedCustomer().getId())
        )
      );
      return true;
    } else {
      Controller.setTableModel(table, new AnimalTableModel(new ArrayList()));
      return false;
    }
  }

  public static void jradioButtonSelectedSpecies(JTable table) {
    setTableModel(
      table,
      new SpecieTableModel(SpecieDAO.getInstance().retrieveAll())
    );
  }

  public static void jradioButtonSelectedVeterinarian(JTable table) {
    setTableModel(
      table,
      new VeterinaryTableModel(VeterinaryDAO.getInstance().retrieveAll())
    );
  }

  public static void updateSimilarName(JTable table, String name) {
    if (table.getModel() instanceof CustomerTableModel) {
      ((GenericTableModel) table.getModel()).addListOfItems(
          CustomerDAO.getInstance().retrieveBySimilarName(name)
        );
    } else if (table.getModel() instanceof VeterinaryTableModel) {
      ((GenericTableModel) table.getModel()).addListOfItems(
          VeterinaryDAO.getInstance().retrieveBySimilarName(name)
        );
    } else if (table.getModel() instanceof AnimalTableModel) {
      if (getSelectedCustomer() != null) {
        ((GenericTableModel) table.getModel()).addListOfItems(
            AnimalDAO
              .getInstance()
              .retrieveBySimilarName(getSelectedCustomer().getId(), name)
          );
      }
    } else if (table.getModel() instanceof SpecieTableModel) {
      ((GenericTableModel) table.getModel()).addListOfItems(
          SpecieDAO.getInstance().retrieveBySimilarName(name)
        );
    }
  }

  public static void clearSearch(JTable table) {
    if (table.getModel() instanceof CustomerTableModel) {
      ((GenericTableModel) table.getModel()).addListOfItems(
          CustomerDAO.getInstance().retrieveAll()
        );
    } else if (table.getModel() instanceof AnimalTableModel) {
      if (getSelectedCustomer() != null) {
        ((GenericTableModel) table.getModel()).addListOfItems(
            AnimalDAO
              .getInstance()
              .retrieveByCustomerId(getSelectedCustomer().getId())
          );
      }
    } else if (table.getModel() instanceof SpecieTableModel) {
      ((GenericTableModel) table.getModel()).addListOfItems(
          SpecieDAO.getInstance().retrieveAll()
        );
    } else if (table.getModel() instanceof VeterinaryTableModel) {
      ((GenericTableModel) table.getModel()).addListOfItems(
          VeterinaryDAO.getInstance().retrieveAll()
        );
    } else if (table.getModel() instanceof AppointmentTableModel) {
      ((GenericTableModel) table.getModel()).addListOfItems(
          AppointmentDAO.getInstance().retrieveAll()
        );
    } else if (table.getModel() instanceof ExamTableModel) {
      if (selectedAnimal != null) {
        ((GenericTableModel) table.getModel()).addListOfItems(
            ExamDAO.getInstance().retrieveByAnimalId(selectedAnimal.getId())
          );
      }
    }
  }

  public static void filterAppointment(
    JTable table,
    JToggleButton buttonOne,
    JToggleButton buttonTwo,
    JToggleButton buttonThree
  ) {
    if (table.getModel() instanceof AppointmentTableModel) {
      String where = "";
      if (!buttonOne.isSelected()) {
        where = "WHERE date >= date('now')";
      }
      if (buttonTwo.isSelected()) {
        Calendar calendar = Calendar.getInstance();
        where =
          "WHERE date BETWEEN '" +
          (calendar.getTimeInMillis() - 86400000) +
          "' AND '" +
          (calendar.getTimeInMillis() + 86400000) +
          "'";
        if (buttonThree.isSelected()) {
          if (selectedVeterinarian != null) {
            where += "AND veterinary_id = " + selectedVeterinarian.getId();
          }
        }
      } else if (buttonThree.isSelected()) {
        if (selectedVeterinarian != null) {
          where = "WHERE veterinary_id = " + selectedVeterinarian.getId();
        }
      }

      String query =
        "SELECT * FROM appointment " + where + " ORDER BY date, hour";
      System.out.println(query);
      ((GenericTableModel) table.getModel()).addListOfItems(
          AppointmentDAO.getInstance().retrieve(query)
        );
    }
  }

  public static void filterExam(
    JTable table,
    JToggleButton buttonOne,
    JToggleButton buttonTwo
  ) {
    if (table.getModel() instanceof ExamTableModel) {
      String where = "WHERE";
      if (!buttonOne.isSelected()) {
        where = "WHERE date >= date('now') AND ";
      }
      if (buttonTwo.isSelected()) {
        Calendar calendar = Calendar.getInstance();
        where =
          "WHERE date BETWEEN '" +
          (calendar.getTimeInMillis() - 86400000) +
          "' AND '" +
          (calendar.getTimeInMillis() + 86400000) +
          "' AND ";
      }

      String query =
        "SELECT * FROM exam " +
        where +
        "  animal_id =" +
        selectedAnimal.getId() +
        " ORDER BY date";
      ((GenericTableModel) table.getModel()).addListOfItems(
          ExamDAO.getInstance().retrieve(query)
        );
    }
  }

  public static boolean addRegister(JTable table) {
    if (table.getModel() instanceof CustomerTableModel) {
      ((GenericTableModel) table.getModel()).addItem(
          addCustomer("", "", "", "", "")
        );
    } else if (table.getModel() instanceof AnimalTableModel) {
      ((GenericTableModel) table.getModel()).addItem(
          addAnimal("", 0, "", "")
        );
    } else if (table.getModel() instanceof SpecieTableModel) {
      ((GenericTableModel) table.getModel()).addItem(addSpecie(""));
    } else if (table.getModel() instanceof VeterinaryTableModel) {
      ((GenericTableModel) table.getModel()).addItem(
          addVeterinarian("", "", "")
        );
    } else if (table.getModel() instanceof AppointmentTableModel) {
      if (
        (selectedCustomer != null) ||
        (selectedAnimal != null) ||
        (selectedVeterinarian != null)
      ) {
        ((GenericTableModel) table.getModel()).addItem(addAppointment());
      } else {
        return false;
      }
    } else if (table.getModel() instanceof ExamTableModel) {
      if ((selectedCustomer != null) || (selectedAnimal != null)) {
        ((GenericTableModel) table.getModel()).addItem(addExam());
      } else {
        return false;
      }
    }
    return true;
  }

  public static Customer addCustomer(String name, String address, String zipCode, String email, String phone){
    return CustomerDAO.getInstance().create(name, address, zipCode, email, phone);
  }

  public static Animal addAnimal(String name,int birthday, String gender, String specie){
    return AnimalDAO.getInstance().create(name, birthday, gender, 0, getSelectedCustomer());
  }
  
  public static Specie addSpecie(String name){
    return SpecieDAO.getInstance().create(name);
  }
  
  public static Veterinary addVeterinarian(String name, String email, String phone){
    return VeterinaryDAO.getInstance().create(name, email, phone);
  }
  
  public static Appointment addAppointment(){
    return AppointmentDAO.getInstance().create(Calendar.getInstance(), 8, "", selectedAnimal.getId(), selectedVeterinarian.getId(), 0, 0);
  }
  
  public static Exam addExam(){
    return ExamDAO.getInstance().create(Calendar.getInstance(), "", selectedAnimal.getId());
  }

  public static void deleteRegister(JTable table, Object selected) {
    if (table.getModel() instanceof CustomerTableModel) {
      if (selected != null) {
        deleteCustomer((Customer) selected);
      }
    } else if (table.getModel() instanceof AnimalTableModel) {
      deleteAnimal((Animal) selected);
    } else if (table.getModel() instanceof SpecieTableModel) {
      List<Animal> animals = AnimalDAO
        .getInstance()
        .retrieveBySpecieId(((Specie) selected).getId());
      if (animals.isEmpty()) {
        deleteSpecie((Specie) selected);
      }
    } else if (table.getModel() instanceof VeterinaryTableModel) {
      deleteVeterinarian((Veterinary) selected);
    } else if (table.getModel() instanceof AppointmentTableModel) {
      deleteAppointment((Appointment) selected);
    } else if (table.getModel() instanceof ExamTableModel) {
      deleteExam((Exam) selected);
    }
    clearSearch(table);
  }

  public static void deleteCustomer(Customer customer) {
    List<Animal> animals = AnimalDAO
      .getInstance()
      .retrieveByCustomerId(customer.getId());
    for (Animal animal : animals) {
      AnimalDAO.getInstance().delete(animal);
    }
    CustomerDAO.getInstance().delete(customer);
  }

  public static void deleteAnimal(Animal animal) {
    AnimalDAO.getInstance().delete(animal);
  }

  public static void deleteSpecie(Specie especie) {
    SpecieDAO.getInstance().delete(especie);
  }

  public static void deleteVeterinarian(Veterinary vet) {
    VeterinaryDAO.getInstance().delete(vet);
  }

  public static void deleteAppointment(Appointment appointment) {
    AppointmentDAO.getInstance().delete(appointment);
  }

  public static void deleteExam(Exam exam) {
    ExamDAO.getInstance().delete(exam);
  }
}
