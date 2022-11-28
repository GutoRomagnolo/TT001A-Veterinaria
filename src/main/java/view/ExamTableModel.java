package view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Exam;
import model.ExamDAO;

public class ExamTableModel extends GenericTableModel {
  private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

  public ExamTableModel(List vData) {
    super(vData, new String[] { "Date", "Description" });
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return String.class;
      case 1:
        return String.class;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Exam exam = (Exam) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return dateFormat.format(exam.getDate().getTime());
      case 1:
        return exam.getDescription();
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Exam appointment = (Exam) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        Calendar calendarObject = Calendar.getInstance();
        try {
          calendarObject.setTime(dateFormat.parse((String) aValue));
        } catch (Exception ex) {
          Logger.getLogger(AppointmentTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        appointment.setDate(calendarObject);
        break;
      case 1:
        appointment.setDescription((String) aValue);
        break;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
    ExamDAO.getInstance().update(appointment);
  }

  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }
}
