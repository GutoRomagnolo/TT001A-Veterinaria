package controller;

import model.Animal;
import model.AnimalDAO;
import model.Customer;
import model.CustomerDAO;
import model.Appointment;
import model.AppointmentDAO;
import model.Specie;
import model.SpecieDAO;
import model.Exam;
import model.ExamDAO;
import model.Treatment;
import model.TreatmentDAO;
import model.Veterinary;
import model.VeterinaryDAO;
import view.AnimalTableModel;
import view.CustomerTableModel;
import view.AppointmentTableModel;
import view.SpecieTableModel;
import view.GenericTableModel;
import view.TreatmentTableModel;
import view.VeterinaryTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Controller {
  private static Customer selectedCustomer = null;
  private static Animal selectedAnimal = null;
  private static Veterinary selectedVeterinary = null;
  private static Treatment selectedTreatment = null;
  private static Appointment selectedAppointment = null;
  private static Specie selectedSpecie = null;
  private static JTextField selectedCustomerTextField = null;
  private static JTextField selectedAnimalTextField = null;
  private static JTextField selectedSpecieTextField = null;
  private static JTextArea selectedAppointmentTextField = null;
  private static JTextArea selectedAppointmentTextArea = null;
  private static JTextArea generalAppointmentsTextArea = null;
  private static JTextArea generalExamsTextArea = null;
  private static JTextArea examTextArea = null;
  private static JPanel visiblePanel = null;
  private static JPanel clickedNavItem = null;
  private static Color navItemColor = null;
  private static Color clickedColor = new Color(77, 86, 168);
  private static Color defaultColor = new Color(38, 38, 84);

  public static void setTableModel(JTable table, GenericTableModel tableModel) {
    table.setModel(tableModel);
  }

  public static void setFields(
    JTextField customerField,
    JTextField animalField,
    JTextField specieField,
    JTextArea appointmentField,
    JTextArea appointmentField2,
    JTextArea examField,
    JTextArea generalExams,
    JTextArea generalAppointments
  ) {
    selectedCustomerTextField = customerField;
    selectedAnimalTextField = animalField;
    selectedSpecieTextField = specieField;
    selectedAppointmentTextField = appointmentField;
    selectedAppointmentTextArea = appointmentField2;
    generalExamsTextArea = generalExams;
    generalAppointmentsTextArea = generalAppointments;
    examTextArea = examField;
  }

  public static void setVisiblePanel(JPanel customerAnimal) {
    visiblePanel = customerAnimal;
  }

  public static void setClickedItem(JPanel animalItem) {
    clickedNavItem = animalItem;
  }

  public static void setClicked(JPanel panel) {
    clickedNavItem.setBackground(defaultColor);
    clickedNavItem = panel;
    clickedNavItem.setBackground(clickedColor);
    navItemColor = clickedColor;
  }

  public static void hoverEffect(JPanel panel) {
    navItemColor = panel.getBackground();
    if (!panel.getBackground().equals(clickedColor)) {
      panel.setBackground(new Color(55, 55, 123));
    }
  }

  public static Color exitedHover() {
    return navItemColor;
  }

  public static Customer getSelectedCustomer() {
    return selectedCustomer;
  }

  public static Animal getSelectedAnimal() {
    return selectedAnimal;
  }

  public static Treatment getSelectedTreatment() {
    return selectedTreatment;
  }

  public static Veterinary getSelectedVeterinary() {
    return selectedVeterinary;
  }

  public static boolean selectedFinishedAppointment() {
    if (selectedAppointment.getHasFinished()) return true;
    return false;
  }

  public static void changeInputStatus(JTextField input, JToggleButton button) {
    if (input.isEnabled()) {
      input.setEnabled(false);
      input.setText("");
      button.setSelected(false);
    } else {
      input.setEnabled(true);
      button.setSelected(true);
    }
  }

  public static void changeInputStatus(JDateChooser input, JToggleButton button) {
    if (input.isEnabled()) {
      input.setEnabled(false);
      input.setDate(null);
      button.setSelected(false);
    } else {
      input.setEnabled(true);
      button.setSelected(true);
    }
  }

  public static void filterAppointment(
    JTable appointmentTable,
    Date date,
    String symptoms,
    String customerName,
    String veterinaryName,
    String treatmentName,
    Boolean has_finished
  ) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar calendar = Calendar.getInstance();
    String day;
    if (date != null) {
      calendar.setTime(date);
      day = dateFormat.format(calendar.getTime());
    } else day = "";

    int finishedAppointments = has_finished ? 1 : 0;
    ((GenericTableModel) appointmentTable.getModel()).addListOfItems(
        AppointmentDAO
          .getInstance()
          .retrieveByFilter(
            day,
            symptoms,
            customerName,
            veterinaryName,
            treatmentName,
            finishedAppointments
          )
      );
  }

  public static void getAllAppointments(JTable appointmentTable) {
    ((GenericTableModel) appointmentTable.getModel()).addListOfItems(
        AppointmentDAO.getInstance().retrieveAll()
      );
  }

  public static void setSelected(Object selected) {
    if (selected instanceof Customer customer) {
      selectedCustomer = customer;
      selectedCustomerTextField.setText(selectedCustomer.getName());
      selectedAnimalTextField.setText("");
      selectedSpecieTextField.setText("");
      selectedAppointmentTextField.setText("");
      selectedAppointmentTextArea.setText("");
    } else if (selected instanceof Animal animal) {
      selectedAnimal = animal;
      selectedAnimalTextField.setText(selectedAnimal.getName());
      selectedSpecieTextField.setText(
        SpecieDAO
          .getInstance()
          .retrieveByID(selectedAnimal.getId())
          .getName()
      );
      selectedAppointmentTextField.setText("");
      selectedAppointmentTextArea.setText("");
      Controller.verifyExistentAppointments();
    } else if (selected instanceof Veterinary veterinary) {
      selectedVeterinary = veterinary;
    } else if (selected instanceof Treatment treatment) {
      selectedTreatment = treatment;
      examTextArea.setText("");
      selectedAppointmentTextArea.setText("");
    } else if (selected instanceof Appointment appointment) {
      selectedAppointment = appointment;
      String status = selectedAppointment.getHasFinished()
        ? "(Finished) - "
        : "(Pending) - ";
      selectedAppointmentTextArea.setText(
        status + selectedAppointment.getDiagnosis()
      );

      examTextArea.setText("");
      List<Exam> exam = (List<Exam>) ExamDAO
        .getInstance()
        .retrieveByID(selectedAppointment.getId());

      if (exam.isEmpty()) {
        examTextArea.setText(
          "Sem exams registrados para a appointment selecionada!"
        );
      } else {
        for (Exam actualExam : exam) {
          examTextArea.append(actualExam.getName() + "\n");
        }
      }
    } else if (selected instanceof Specie specie) {
      selectedSpecie = specie;
    }
  }

  public static void setSelectedGeneralAppointments(Object selected) {
    generalExamsTextArea.setText("");
    Appointment appointment = (Appointment) selected;
    List<Exam> exams = (List<Exam>) ExamDAO
      .getInstance()
      .retrieveByID(appointment.getId());
    generalAppointmentsTextArea.setText(appointment.getDiagnosis());
    for (Exam exam : exams) {
      generalExamsTextArea.append(exam.getName() + "\n");
    }
  }

  public static void updateInstance(Object instance) {
    if (instance.getClass().equals(Customer.class)) CustomerDAO
      .getInstance()
      .updateCustomer((Customer) instance); else if (
      instance.getClass().equals(Animal.class)
    ) AnimalDAO.getInstance().update((Animal) instance); else if (
      instance.getClass().equals(Veterinary.class)
    ) VeterinaryDAO.getInstance().update((Veterinary) instance); else if (
      instance.getClass().equals(Appointment.class)
    ) {
      AppointmentDAO.getInstance().update((Appointment) instance);
    } else if (instance.getClass().equals(Exam.class)) ExamDAO
      .getInstance()
      .update((Exam) instance); else if (
      instance.getClass().equals(Treatment.class)
    ) TreatmentDAO.getInstance().update((Treatment) instance); else if (
      instance.getClass().equals(Specie.class)
    ) SpecieDAO.getInstance().update((Specie) instance);
  }

  public static void setBySearch(JTable table, String input) {
    if (table.getModel() instanceof CustomerTableModel) (
      (GenericTableModel) table.getModel()
    ).addListOfItems(
        CustomerDAO.getInstance().retrieveCustomerBySimilarName(input)
      ); else if (table.getModel() instanceof VeterinaryTableModel) (
      (GenericTableModel) table.getModel()
    ).addListOfItems(
        VeterinaryDAO.getInstance().retrieveBySimilarName(input)
      ); else if (table.getModel() instanceof AnimalTableModel) {
      if (selectedCustomer != null) (
        (GenericTableModel) table.getModel()
      ).addListOfItems(
          AnimalDAO
            .getInstance()
            .retrieveBySimilarName(input)
        );
    } else if (table.getModel() instanceof SpecieTableModel) (
      (GenericTableModel) table.getModel()
    ).addListOfItems(SpecieDAO.getInstance().retrieveBySimilarName(input));
  }

  public static void insertLine(JTable table) {
    if (table.getModel() instanceof CustomerTableModel) {
      Customer customer = CustomerDAO.getInstance().create("", "", "", "", 0, "", "", "");
      ((GenericTableModel) table.getModel()).addItem(customer);
    } else if (table.getModel() instanceof VeterinaryTableModel) {
      Veterinary veterinary = VeterinaryDAO.getInstance().create("", "", "", "", 0, "", "", "");
      ((GenericTableModel) table.getModel()).addItem(veterinary);
    } else if (table.getModel() instanceof AnimalTableModel) {
      if (Controller.getSelectedCustomer() != null) {
        Specie specie = SpecieDAO.getInstance().retrieveByID(1);
        Animal animal = AnimalDAO
          .getInstance()
          .create("", "", 2, specie.getId(), selectedCustomer.getId());
        ((GenericTableModel) table.getModel()).addItem(animal);
      } else JOptionPane.showMessageDialog(
        new JFrame(),
        "Um customer deve ser selecionado para fazer o cadastro de um animal",
        "Dialog",
        JOptionPane.ERROR_MESSAGE
      );
    } else if (table.getModel() instanceof TreatmentTableModel) {
      if (Controller.getSelectedAnimal() != null) {
        Calendar firstCalendar = Calendar.getInstance();
        Treatment treatment = TreatmentDAO
          .getInstance()
          .create("", "", firstCalendar, firstCalendar, selectedAnimal.getId());
        ((GenericTableModel) table.getModel()).addItem(treatment);
      } else JOptionPane.showMessageDialog(
        new JFrame(),
        "Um animal deve ser selecionado para fazer o cadastro de um treatment",
        "Dialog",
        JOptionPane.ERROR_MESSAGE
      );
    } else if (table.getModel() instanceof SpecieTableModel) {
      Specie specie = SpecieDAO.getInstance().create("");
      ((GenericTableModel) table.getModel()).addItem(specie);
    }
  }

  public static void cleanSearch(JTextField textField) {
    textField.setText("");
  }

  public static void deleteCustomerRow(JTable customerTable, JTable animalTable) {
    if (customerTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(
        new JFrame(),
        "Uma linha deve ser selecionada",
        "Dialog",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }

    Customer customer = (Customer) (
      (GenericTableModel) customerTable.getModel()
    ).getItem(customerTable.getSelectedRow());

    List<Animal> animals = AnimalDAO
      .getInstance()
      .retrieveAnimalByCustomerID(customer.getId());
    for (Animal animal : animals) {
      AnimalDAO.getInstance().delete(animal);
      ((GenericTableModel) animalTable.getModel()).removeItem(0);
    }

    CustomerDAO.getInstance().deleteCustomer(customer);
    ((GenericTableModel) customerTable.getModel()).removeItem(
        customerTable.getSelectedRow()
      );

    selectedAnimalTextField.setText("");
    selectedSpecieTextField.setText("");
    selectedAppointmentTextArea.setText("");
    selectedCustomerTextField.setText("");
    selectedAppointment = null;
    selectedAnimal = null;
    selectedCustomer = null;
    selectedTreatment = null;
  }

  public static void deleteRow(JTable table) {
    if (table.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(
        new JFrame(),
        "Uma linha deve ser selecionada",
        "Dialog",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }
    Object rowObject = ((GenericTableModel) table.getModel()).getItem(table.getSelectedRow());

    if (table.getModel() instanceof VeterinaryTableModel) {
      Veterinary veterinary = (Veterinary) rowObject;
      List<Appointment> appointments = (List<Appointment>) AppointmentDAO
        .getInstance()
        .retrieveByID(veterinary.getId());
      if (!appointments.isEmpty()) {
        JOptionPane.showMessageDialog(
          new JFrame(),
          "Apague as appointments que este veterinário participa antes de prosseguir",
          "Dialog",
          JOptionPane.ERROR_MESSAGE
        );
        return;
      }
      VeterinaryDAO.getInstance().delete(veterinary);
      selectedVeterinary = null;
    } else if (table.getModel() instanceof SpecieTableModel) {
      Specie specie = (Specie) rowObject;
      List<Animal> animals = AnimalDAO.getInstance().retrieveAll();

      for (Animal animal : animals) {
        if (animal.getSpecieId() == specie.getId()) {
          JOptionPane.showMessageDialog(
            new JFrame(),
            "Apague os animals desta espécie antes de prosseguir",
            "Dialog",
            JOptionPane.ERROR_MESSAGE
          );
          return;
        }
      }
      SpecieDAO.getInstance().delete(specie);
    } else if (table.getModel() instanceof AnimalTableModel) {
      Animal animal = (Animal) rowObject;
      List<Treatment> treatments = (List<Treatment>) TreatmentDAO
        .getInstance()
        .retrieveByID(animal.getId());

      if (!treatments.isEmpty()) {
        JOptionPane.showMessageDialog(
          new JFrame(),
          "Apague os treatments associados a este animal antes de prosseguir",
          "Dialog",
          JOptionPane.ERROR_MESSAGE
        );
        return;
      }
      AnimalDAO.getInstance().delete(animal);
      selectedAnimalTextField.setText("");
      selectedSpecieTextField.setText("");
      selectedAppointmentTextArea.setText("");
      selectedCustomer = null;
      selectedAppointment = null;
      selectedTreatment = null;
    } else if (table.getModel() instanceof AppointmentTableModel) {
      Appointment appointment = (Appointment) rowObject;

      List<Exam> exams = (List<Exam>) ExamDAO
        .getInstance()
        .retrieveByID(appointment.getId());

      for (Exam exam : exams) {
        ExamDAO.getInstance().delete(exam);
      }
      selectedAppointmentTextArea.setText("");
      examTextArea.setText("");
      selectedAppointmentTextField.setText("");
      AppointmentDAO.getInstance().delete(selectedAppointment);
      Controller.verifyExistentAppointments();
      selectedAppointment = null;
    }
    ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
  }

  public static void insertExam(JTable appointmentTable, String exam) {
    if (selectedAppointment != null) {
      if (!exam.isBlank()) {
        if (ExamDAO.getInstance().retrieveByID(selectedAppointment.getId()).isEmpty()) {
          examTextArea.setText("");
        }
        ExamDAO.getInstance().create(exam, "", "", selectedAppointment.getId());
        examTextArea.append(exam + "\n");
      } else JOptionPane.showMessageDialog(
        new JFrame(),
        "O campo exam é obrigatório",
        "Dialog",
        JOptionPane.ERROR_MESSAGE
      );
    } else JOptionPane.showMessageDialog(
      new JFrame(),
      "Uma appointment deve ser selecionada para inserir um novo exam",
      "Dialog",
      JOptionPane.ERROR_MESSAGE
    );
  }

  public static void updateAppointment(JTable appointmentTable, boolean getHasFinished) {
    if (selectedAppointment != null) {
      selectedAppointment.setHasFinished(getHasFinished);
      AppointmentDAO.getInstance().update(selectedAppointment);
      selectedAppointmentTextArea.setText("");
      if (getHasFinished) selectedAppointmentTextArea.setText(
        "(Finished) - " + selectedAppointment.getDiagnosis()
      ); else selectedAppointmentTextArea.setText(
        "(Pending) - " + selectedAppointment.getDiagnosis()
      );
      selectedAppointmentTextField.setText("");
      Controller.verifyExistentAppointments();
    } else JOptionPane.showMessageDialog(
      new JFrame(),
      "Uma appointment deve ser selecionada para inserir um novo exam",
      "Dialog",
      JOptionPane.ERROR_MESSAGE
    );
  }

  public static void switchPanels(JPanel panel) {
    visiblePanel.setVisible(false);
    visiblePanel = panel;
    visiblePanel.setVisible(true);
  }

  public static boolean validSchedulesField() {
    if (selectedCustomer != null && selectedAnimal != null) {
      if (selectedVeterinary != null) {
        if (selectedTreatment != null) {
          return true;
        } else JOptionPane.showMessageDialog(
          new JFrame(),
          "Um treatment deve ser selecionado para fazer um agendamento",
          "Dialog",
          JOptionPane.ERROR_MESSAGE
        );
      } else JOptionPane.showMessageDialog(
        new JFrame(),
        "Um veterinário deve ser selecionado para fazer um agendamento",
        "Dialog",
        JOptionPane.ERROR_MESSAGE
      );
    } else JOptionPane.showMessageDialog(
      new JFrame(),
      "Um customer e um animal devem ser selecionados para fazer um agendamento",
      "Dialog",
      JOptionPane.ERROR_MESSAGE
    );

    return false;
  }

  public static boolean scheduleAppointment(
    Date date,
    String symptoms,
    String diagnosis
  ) {
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      AppointmentDAO
        .getInstance()
        .create(
          calendar,
          symptoms,
          diagnosis,
          selectedAnimal.getId(),
          selectedVeterinary.getId(),
          selectedTreatment.getId(),
          false
        );
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  public static void fillAppointmentField(
    JTextField customerField,
    JTextField veterinaryField,
    JTextField animalField,
    JTextField treatmentField
  ) {
    treatmentField.setText(selectedTreatment.getName());
    customerField.setText(selectedCustomer.getName());
    animalField.setText(selectedAnimal.getName());
    veterinaryField.setText(selectedVeterinary.getName());
  }

  public static void retrieveAppointments(JTable appointmentTable) {
    ((GenericTableModel) appointmentTable.getModel()).addListOfItems((List<Object>) AppointmentDAO.getInstance().retrieveByID(selectedAnimal.getId()));
    selectedAppointmentTextField.setText("");
    Controller.verifyExistentAppointments();
  }

  public static void verifyExistentAppointments() {
    List<Appointment> appointment = (List<Appointment>) AppointmentDAO
      .getInstance()
      .retrieveByID(selectedAnimal.getId());
    if (appointment.isEmpty()) {
      selectedAppointmentTextField.setText("Sem appointments registradas");
      selectedAppointmentTextArea.setText("Sem appointments registradas");
    } else {
      for (Appointment calendar : appointment) {
        String status = calendar.getHasFinished() ? "(Finished) - " : "(Pending) - ";
        selectedAppointmentTextField.append(status + calendar.getDiagnosis() + "\n");
      }
    }
  }

  public static void filterButtonClick(JToggleButton button) {
    Color actualColor = button.getBackground();
    Color beforeClick = new Color(238, 238, 252);
    if (actualColor.equals(beforeClick)) button.setBackground(
      new Color(226, 239, 255)
    ); else button.setBackground(beforeClick);
  }
}
