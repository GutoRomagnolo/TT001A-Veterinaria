package view;

import java.util.List;
import model.Specie;
import model.SpecieDAO;

public class SpecieTableModel extends GenericTableModel {

  public SpecieTableModel(List vData) {
    super(vData, new String[] { "Name" });
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return String.class;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Specie specie = (Specie) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return specie.getName();
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Specie specie = (Specie) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        specie.setName((String) aValue);
        break;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
    SpecieDAO.getInstance().update(specie);
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }
}
