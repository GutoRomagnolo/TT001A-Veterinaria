package view;

import java.util.List;
import model.Exam;

public class ExamTableModel extends GenericTableModel {

  public ExamTableModel(List vData) {
    super(vData, new String[] { "ID", "Description", "Appointment" });
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
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int row_index, int column_index) {
    Exam exam = (Exam) vData.get(row_index);

    switch (column_index) {
      case 0:
        return exam.getId();
      case 1:
        return exam.getDescription();
      case 2:
        return exam.getAppointmentId();
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public boolean isCellEditable(int row_index, int column_index) {
    return false;
  }
}
