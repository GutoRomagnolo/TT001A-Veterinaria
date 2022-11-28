package view;

import java.util.List;
import model.Customer;
import model.CustomerDAO;

public class CustomerTableModel extends GenericTableModel {
  public CustomerTableModel(List vData) {
    super(
      vData,
      new String[] { "Name", "Address", "Zip code", "E-mail", "Phone" }
    );
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
      case 4:
        return String.class;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Customer customer = (Customer) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return customer.getName();
      case 1:
        return customer.getAddress();
      case 2:
        return customer.getZipCode();
      case 3:
        return customer.getEmail();
      case 4:
        return customer.getPhone();
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Customer customer = (Customer) vData.get(rowIndex);
    switch (columnIndex) {
      case 0:
        customer.setName((String) aValue);
        break;
      case 1:
        customer.setAddress((String) aValue);
        break;
      case 2:
        customer.setZipCode((String) aValue);
        break;
      case 3:
        customer.setEmail((String) aValue);
        break;
      case 4:
        customer.setPhone((String) aValue);
        break;
      default:
        throw new IndexOutOfBoundsException("Column index out of bounds");
    }

    CustomerDAO.getInstance().update(customer);
  }

  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }
}
