package view;

import java.util.List;
import model.Appointment;

public class AppointmentTableModel extends GenericTableModel {
  public AppointmentTableModel(List vData) {
    super(vData, new String[]{"Date", "Symptoms", "Diagnosis"});
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0 -> {
        return String.class;
      }
      case 1 -> {
        return String.class;
      }
      case 2 -> {
        return String.class;
      }
      default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Appointment appointment = (Appointment) vData.get(rowIndex);
    
    switch (columnIndex) {
      case 0 -> {
        return appointment.getDate();
      }
      case 1 -> {
        return appointment.getSymptoms();
      }
      case 2 -> {
        return appointment.getDiagnosis();
      }
      default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Appointment appointment = (Appointment) vData.get(rowIndex);
    switch (columnIndex) {
      case 0 -> appointment.setDate(((String) aValue));
      case 1 -> appointment.setSymptoms((String) aValue);
      case 2 -> appointment.setDiagnosis((String) aValue);
      default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
  }
  
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  } 
  
}