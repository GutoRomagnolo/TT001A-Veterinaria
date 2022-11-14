package view;

import controller.Controller;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Animal;
import model.Specie;
import model.SpecieDAO;

public class AnimalTableModel extends GenericTableModel {

  public AnimalTableModel(List vData) {
    super(vData, new String[] { "Name", "Birthday", "Gender", "Specie" });
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return String.class;
      case 1:
        return Integer.class;
      case 2:
        return String.class;
      case 3:
        return String.class;
      default: throw new IndexOutOfBoundsException(
        "columnIndex out of bounds"
      );
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
        Specie specie = SpecieDAO.getInstance().retrieveByID(animal.getSpecieId());
        return specie != null ? specie.getName() : "";
      default: throw new IndexOutOfBoundsException(
        "columnIndex out of bounds"
      );
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
        animal.setBirthday((String) aValue);
        break;
      case 2:
        boolean validateGender = animal.setGender((String) aValue);
        if (!validateGender) {
          JOptionPane.showMessageDialog(new JFrame(), "Um cliente deve ser selecionado para fazer o cadastro de um animal", "Dialog",JOptionPane.ERROR_MESSAGE);
        }
        break;
      case 3:
        Specie specie = SpecieDAO.getInstance().retrieveByName((String)aValue);
        
        if(specie == null){
            specie = SpecieDAO.getInstance().create((String)aValue);
            Controller.updateInstance(specie);
        }
        animal.setSpecieId(specie.getId());
        break;
      default: throw new IndexOutOfBoundsException(
        "columnIndex out of bounds"
      );
    }

    Controller.updateInstance(animal); 
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }
}