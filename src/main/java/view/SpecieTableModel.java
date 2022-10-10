package view;

import model.Specie;
import java.util.List;

public class SpecieTableModel extends GenericTableModel {

  public SpecieTableModel(List vData) {
    super(vData, new String[] { "ID", "Name" });
  }

  @Override
  public Class<?> getColumnClass(int column_index) {
    switch (column_index) {
      case 0:
        return Integer.class;
      case 1:
        return String.class;
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int row_index, int column_index) {
    Specie specie = (Specie) vData.get(row_index);

    switch (column_index) {
      case 0:
        return specie.getId();
      case 1:
        return specie.getName();
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public boolean isCellEditable(int row_index, int column_index) {
    return false;
  }
}
