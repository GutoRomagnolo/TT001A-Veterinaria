package view;

import java.util.List;
import model.Veterinary;
import model.VeterinaryDAO;

public class VeterinaryTableModel extends GenericTableModel {
  public VeterinaryTableModel(List vData) {
    super(vData, new String[] { "Name", "E-mail", "Phone" });
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return String.class;
      case 1:
        return String.class;
      case 2:
        return String.class;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Veterinary veterinarian = (Veterinary) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return veterinarian.getName();
      case 1:
        return veterinarian.getEmail();
      case 2:
        return veterinarian.getPhone();
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Veterinary veterinarian = (Veterinary) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        veterinarian.setName((String) aValue);
        break;
      case 1:
        veterinarian.setEmail((String) aValue);
        break;
      case 2:
        veterinarian.setPhone((String) aValue);
        break;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
    VeterinaryDAO.getInstance().update(veterinarian);
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }
}
