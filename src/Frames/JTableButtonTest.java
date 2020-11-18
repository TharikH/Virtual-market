/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

/**
 *
 * @author aswin
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class JTableButtonTest extends JFrame {
   private JTable table;
   private JScrollPane scrollPane;
   public JTableButtonTest(Object[][] rows,String[] columns) {
      //setTitle("JTableButton Test");
      TableCellRenderer tableRenderer;
      table = new JTable(new JTableButtonModel(rows,columns));
      tableRenderer = table.getDefaultRenderer(JButton.class);
      table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
      //scrollPane = new JScrollPane(table);
      //add(scrollPane, BorderLayout.CENTER);
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //setLocationRelativeTo(null);
      //setSize(400, 300);
      //setVisible(true);
   }
   public JTable getJtable(){
       return table;
   }
   public static void main(String[] args) {
     Object[][] rows = {{"Button1","col2", new JButton("Button1")},{"Button2" ,"col2",new JButton("Button2")},{"Button3","col2", new JButton("Button3")}, {"Button4","col2", new JButton("Button4")}};
     String[] columns ={"Count","col2", "Buttons"};
      new JTableButtonTest(rows,columns);
   }
}
class JTableButtonRenderer implements TableCellRenderer {
   private TableCellRenderer defaultRenderer;
   public JTableButtonRenderer(TableCellRenderer renderer) {
      defaultRenderer = renderer;
   }
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      if(value instanceof Component)
         return (Component)value;
         return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
   }
}
class JTableButtonModel extends AbstractTableModel {
   private Object[][] rows ;//= {{"Button1","col2", new JButton("Button1")},{"Button2" ,"col2",new JButton("Button2")},{"Button3","col2", new JButton("Button3")}, {"Button4","col2", new JButton("Button4")}};
   private String[] columns ;//{"Count","col2", "Buttons"};
   public JTableButtonModel(Object[][] rows,String[] columns){
       this.rows=rows;
       this.columns=columns;
   }
   public String getColumnName(int column) {
      return columns[column];
   }
   public int getRowCount() {
      return rows.length;
   }
   public int getColumnCount() {
      return columns.length;
   }
   public Object getValueAt(int row, int column) {
      return rows[row][column];
   }
   public boolean isCellEditable(int row, int column) {
      return false;
   }
   public Class getColumnClass(int column) {
      return getValueAt(0, column).getClass();
   }
}