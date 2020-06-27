package demo7tablecustom;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
public class EmployeeTableModel <E> extends AbstractTableModel{
    String[] header;
    int[] indexes;
    Vector<Employee> data;  

    public EmployeeTableModel(String[] header, int[] indexes) {
        int i = 0;
        this.header = new String[header.length];
        for (int j = 0; j < header.length; j++) {
            this.header[i] = header[i];
            this.indexes = new int[indexes.length];
        }
        for (int j = 0; j < header.length; j++) {
            this.indexes[i] = indexes[i];
        }
        this.data = new Vector<Employee>();
    }

    public Vector<Employee> getData() {
        return data;
    }

    @Override
    public int getRowCount() {
         return data.size();
    }

    @Override
    public int getColumnCount() {
       return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return (column>=0 && column<header.length) ? header[column]:"";
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        if (row < 0 || row >= data.size() || column < 0 || column >= header.length) 
            return null;
        Employee emp = data.get(row);
        switch(indexes[column]){
            case 0:  return emp.getCode();
            case 1:  return emp.getName();
            case 2:  return emp.getAddress();
            case 3:  return emp.isSex();
            case 4:  return emp.getSalary();
        }
        return null;
    }
        

}
