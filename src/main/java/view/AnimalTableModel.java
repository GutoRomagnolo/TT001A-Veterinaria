package view;

import java.util.List;
import model.Animal;
import model.AnimalDAO;
import model.Specie;
import model.SpecieDAO;

public class AnimalTableModel extends GenericTableModel {

  public AnimalTableModel(List vData) {
    super(vData, new String[] { "Name", "Age", "Gender", "Specie" });
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
      case 3:
        return String.class;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Animal animal = (Animal) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return animal.getName();
      case 1:
        return animal.getBirthday();
      case 2:
        return animal.getGender();
      case 3:
        Specie species = SpecieDAO
          .getInstance()
          .retrieveById(animal.getSpecieId());
        if (species != null) {
          return species.getName();
        }
        return "";
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Animal animal = (Animal) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        animal.setName((String) aValue);
        break;
      case 1:
        animal.setBirthday(Integer.parseInt((String) aValue));
        break;
      case 2:
        animal.setGender((String) aValue);
        break;
      case 3:
        Specie species = SpecieDAO
          .getInstance()
          .retrieveByName((String) aValue);
        if (species == null) {
          species = SpecieDAO.getInstance().create((String) aValue);
        }
        animal.setSpecieId(species.getId());
        break;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }

    AnimalDAO.getInstance().update(animal);
  }

  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }
}
