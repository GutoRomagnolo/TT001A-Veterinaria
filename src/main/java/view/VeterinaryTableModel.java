package view;

import java.util.List;
import model.Veterinary;

public class VeterinaryTableModel extends GenericTableModel {

  public VeterinaryTableModel(List v_data) {
    super(
      v_data,
      new String[] {
        "ID",
        "Name",
        "Document number",
        "Phone",
        "Email",
        "Postal code",
        "Number",
        "Complement"
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
      case 5:
        return String.class;
      case 6:
        return Integer.class;
      case 7:
        return String.class;
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int row_index, int column_index) {
    Veterinary veterinary = (Veterinary) vData.get(row_index);

    switch (column_index) {
      case 0:
        return veterinary.getId();
      case 1:
        return veterinary.getName();
      case 2:
        return veterinary.getEmail();
      case 3:
        return veterinary.getPhone();
      case 4:
        return veterinary.getDocumentNumber();
      case 5:
        return veterinary.getPostalCode();
      case 6:
        return veterinary.getNumber();
      case 7:
        return veterinary.getComplement();
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public boolean isCellEditable(int row_index, int column_index) {
    return false;
  }
}
