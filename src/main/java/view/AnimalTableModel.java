package view;

import java.util.List;
import model.Animal;
import model.Customer;
import model.CustomerDAO;
import model.Specie;
import model.SpecieDAO;

public class AnimalTableModel extends GenericTableModel {

  public AnimalTableModel(List vData) {
    super(
      vData,
      new String[] { "ID", "Name", "Nascimento", "Sexo", "Espécie", "Dono" }
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
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int row_index, int column_index) {
    Animal animal = (Animal) vData.get(row_index);
 
    switch (column_index) {
      case 0:
        return animal.getId();
      case 1:
        return animal.getName();
      case 2:
        return animal.getBirthday();
      case 3:
        return animal.getGender();
      case 4:
        Specie specie = SpecieDAO
          .getInstance()
          .retrieveByID(animal.getSpecieId());
        return specie.getName();
      case 5:
        Customer customer = CustomerDAO
          .getInstance()
          .retrieveCustomerByID(animal.getCustomerId());
        return customer.getName();
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  @Override
  public boolean isCellEditable(int row_index, int column_index) {
    return false;
  }
}
