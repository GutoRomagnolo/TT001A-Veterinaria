package view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Animal;
import model.AnimalDAO;
import model.CustomerDAO;
import model.Appointment;
import model.AppointmentDAO;
import model.VeterinaryDAO;

public class AppointmentTableModel extends GenericTableModel {
  private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

  public AppointmentTableModel(List vData) {
    super(
      vData,
      new String[] {
        "Date",
        "Hour",
        "Customer",
        "Animal",
        "Veterinarian",
        "Notes",
        "Finished"
      }
    );
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return String.class;
      case 1:
        return Integer.class;
      case 2:
        return String.class;
      case 3:
        return String.class;
      case 4:
        return String.class;
      case 5:
        return String.class;
      case 6:
        return Boolean.class;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Appointment appointment = (Appointment) vData.get(rowIndex);
    Animal animal;
    switch (columnIndex) {
      case 0:
        return dateFormat.format(appointment.getDate().getTime());
      case 1:
        return appointment.getHour();
      case 2:
        animal = AnimalDAO.getInstance().retrieveById(appointment.getAnimalId());
        return CustomerDAO.getInstance().retrieveById(animal.getCustomerId()).getName();
      case 3:
        animal = AnimalDAO.getInstance().retrieveById(appointment.getAnimalId());
        return animal.getName();
      case 4:
        return VeterinaryDAO.getInstance().retrieveById(appointment.getVeterinarianId()).getName();
      case 5:
        return appointment.getComments();
      case 6:
        return appointment.getHasFinished();
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Appointment appointment = (Appointment) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        Calendar calendar = Calendar.getInstance();
        try {
          calendar.setTime(dateFormat.parse((String) aValue));
        } catch (Exception exception) {
          Logger.getLogger(AppointmentTableModel.class.getName()).log(Level.SEVERE, null, exception);
        }
        appointment.setDate(calendar);
        break;
      case 1:
        appointment.setHour((Integer) aValue);
        break;
      case 2:
        break;
      case 3:
        break;
      case 4:
        break;
      case 5:
        appointment.setComments((String) aValue);
        break;
      case 6:
        appointment.setHasFinished((Boolean) aValue);
        break;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }

    AppointmentDAO.getInstance().update(appointment);
  }

  public boolean isCellEditable(int rowIndex, int columnIndex) {
    if ((columnIndex < 2) || (columnIndex > 4)) {
      return true;
    } else {
      return false;
    }
  }
}
