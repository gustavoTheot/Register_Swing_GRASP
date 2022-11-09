package swing;

import sistem.People;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PeopleTableModel extends AbstractTableModel {

    private List<People> data;
    private String columns[] = {"Name", "Email", "Password"};
    private final int COLUMN_NAME = 0;
    private final int COLUMN_EMAIL = 1;
    private final int COLUMN_PASSWORD = 2;

    public PeopleTableModel(List<People> data) {
        this.data = new ArrayList<>(data);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUMN_NAME:
                return String.class;
            case COLUMN_EMAIL:
                return String.class;
            case COLUMN_PASSWORD:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        People people = data.get(rowIndex);

        switch (columnIndex){
            case COLUMN_NAME:
                return people.getName();
            case  COLUMN_EMAIL:
                return people.getEmail();
            case COLUMN_PASSWORD:
                return people.getPassword();
        }

        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        People people = data.get(rowIndex);

        switch (columnIndex) {
            case COLUMN_NAME:
                    people.setName(aValue.toString());
                break;
            case COLUMN_EMAIL:
                people.setEmail(aValue.toString());
                break;
            case COLUMN_PASSWORD:
                people.setPassword(aValue.toString());
                break;

        }
        fireTableDataChanged();
    }

}
