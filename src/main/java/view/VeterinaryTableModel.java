package view;

import java.util.List;
import model.Veterinary;

public class VeterinaryTableModel extends GenericTableModel {

  public VeterinaryTableModel(List vData) {
    super(vData, new String[] { "Name", "Email", "Phone" });
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
    Veterinary veterinary = (Veterinary) vData.get(rowIndex);

    switch (columnIndex) {
      case 0:
        return veterinary.getName();
      case 1:
        return veterinary.getEmail();
      case 2:
        return veterinary.getPhone();
      default:
        throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Veterinary veterinary = (Veterinary) vData.get(rowIndex);

    switch (columnIndex) {
      case 0:
        veterinary.setName((String) aValue);
        break;
      case 1:
        veterinary.setEmail((String) aValue);
        break;
      case 2:
        veterinary.setPhone((String) aValue);
        break;
      default:
        throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }
}
