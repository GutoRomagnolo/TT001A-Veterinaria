package view;

import model.Animal;
import model.AnimalDAO;
import model.Treatment;
import java.util.List;

public class TreatmentTableModel extends GenericTableModel {

  public TreatmentTableModel(List vData) {
    super(
      vData,
      new String[] { "ID", "Data de início", "Data final", "Paciente" }
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
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int row_index, int column_index) {
    Treatment treatment = (Treatment) vData.get(row_index);

    switch (column_index) {
      case 0:
        return treatment.getId();
      case 1:
        return treatment.getInitialDate();
      case 2:
        return treatment.getFinalDate();
      case 3:
        Animal animal = AnimalDAO
          .getInstance()
          .retrieveByID(treatment.getAnimalId());
        return animal.getName();
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public boolean isCellEditable(int row_index, int column_index) {
    return false;
  }
}
