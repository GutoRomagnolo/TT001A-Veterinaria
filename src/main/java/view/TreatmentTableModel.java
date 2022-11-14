package view;

import java.util.Calendar;
import java.util.List;
import model.Treatment;

public class TreatmentTableModel extends GenericTableModel {

  public TreatmentTableModel(List vData) {
    super(vData, new String[]{"Name", "Start date", "Final date", "History"});
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
      case 3 -> {
        return String.class;
      }
      default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Treatment treatment = (Treatment) vData.get(rowIndex);
    switch (columnIndex) {
      case 0 -> {
        return treatment.getName();
      }
      case 1 -> {
        return treatment.getInitialDate();
      }
      case 2 -> {
        return treatment.getFinalDate();
      }
      case 3 -> {
        return treatment.getHistory();
      }
      default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
  }
  
  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Treatment treatment = (Treatment) vData.get(rowIndex);

    switch (columnIndex) {
      case 0 -> treatment.setName((String) aValue);
      case 1 -> treatment.setInitialDate((Calendar) aValue);
      case 2 -> treatment.setFinalDate((Calendar) aValue);
      case 3 ->treatment.setHistory((String) aValue);
      default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
  }
  
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  } 
}