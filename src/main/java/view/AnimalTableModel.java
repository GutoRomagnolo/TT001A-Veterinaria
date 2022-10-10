package view;

import java.util.List;
import model.Animal;

public class AnimalTableModel extends GenericTableModel {

    public AnimalTableModel(List vData) {
        super(vData, new String[]{"Name", "Birthday", "Gender"});
    }
    
    public Class<?> getColumnClass(int columnIndex) {
        
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
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
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
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
                animal.setGender((Integer) aValue);
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