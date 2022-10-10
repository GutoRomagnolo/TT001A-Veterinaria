package view;

import model.Customer;
import java.util.List;

public class CustomerTableModel extends GenericTableModel {

  public CustomerTableModel(List vData) {
    super(
      vData,
      new String[] {
        "ID",
        "Name",
        "Document number",
        "Phone",
        "Email",
        "Postal code",
        "Number",
        "Complement",
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
    Customer customer = (Customer) vData.get(row_index);

    switch (column_index) {
      case 0:
        return customer.getId();
      case 1:
        return customer.getName();
      case 2:
        return customer.getEmail();
      case 3:
        return customer.getPhone();
      case 4:
        return customer.getDocumentNumber();
      case 5:
        return customer.getPostalCode();
      case 6:
        return customer.getNumber();
      case 7:
        return customer.getComplement();
      default:
        throw new IndexOutOfBoundsException("column_index out of bounds");
    }
  }

  /* @Override
    public void setValueAt(Object a_value, int row_index, int column_index) {
        Customer customer = (Customer) vData.get(row_index);
        
        switch (column_index) {
            case 0:
                customer.getName();
                break;
            case 1:
                customer.getEmail();
                break;
            case 2:
                customer.getPhone();
                break;
            case 3:
                customer.getDocumentNumber();
                break;
            case 4:
                customer.getPostalCode();
                break;
            case 5:
                customer.getNumber();
                break;
            case 6:
                customer.getComplement();
                break;
            default:
                throw new IndexOutOfBoundsException("column_index out of bounds");
        }
        
        CustomerDAO.getInstance().update(customer);
    } */

  @Override
  public boolean isCellEditable(int row_index, int column_index) {
    return false;
  }
}
