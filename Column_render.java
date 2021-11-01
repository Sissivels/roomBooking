package tablas;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import static tablas.Dashboard.free_rooms_list_int;




public class Column_render implements TableCellRenderer{
    
     ArrayList<Object> free_rooms = Dashboard.free_rooms_list_int;
     
    private static final TableCellRenderer renderer = new DefaultTableCellRenderer();
    
    @Override
    
    public Component getTableCellRendererComponent (JTable table, Object value, boolean Selected, boolean hasFocus, int row, int column){
        Component component = renderer.getTableCellRendererComponent(table, value, Selected, hasFocus,row,column);
        
        
        if(column == 0) {
            Object raum_nr_cell = table.getModel().getValueAt(row, column);
            

            Color color = null;
            
            if(free_rooms.contains(raum_nr_cell)){
                color = Color.decode("0xB1D8B7");      //GREEN;
            }else{
                color = Color.decode("0xFFAEBC");        //RED;
            }component.setBackground(color);}
        return component;
        }
}
        
