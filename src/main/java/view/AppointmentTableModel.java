package view;

import model.Appointment;
import model.Veterinary;
import model.VeterinaryDAO;
import java.util.List;

public class AppointmentTableModel extends GenericTableModel {

  public AppointmentTableModel(List vData) {
    super(
      vData,
      new String[] {
        "ID",
        "Data da consulta",
        "Diagnóstico",
        "Tratamento",
        "Veterinário",
      }
    );
  }

  @Override
  public Class<?> getColumnClass(int column_index) {
    switch (column_index) {
      case 0:
        return Integer.class;
      case 1:
        return String.class;
      case 2:
        return String.class;
      case 3:
        return String.class;
      case 4:
        return String.class;
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int row_index, int column_index) {
    Appointment appointment = (Appointment) vData.get(
      row_index
    );

    switch (column_index) {
      case 0:
        return appointment.getId();
      case 1:
        return appointment.getDate();
      case 2:
        return appointment.getDiagnosis();
      case 3:
        return appointment.getTreatmentId();
      case 4:
        Veterinary veterinary = VeterinaryDAO
          .getInstance()
          .retrieveByID(appointment.getVeterinaryId());
        return veterinary.getName();
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public boolean isCellEditable(int row_index, int column_index) {
    return false;
  }
}
