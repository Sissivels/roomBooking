
package tablas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Selected_room extends javax.swing.JFrame {

        //======================= Class Variables =============================//
        public static ArrayList<Object> free_rooms_list_int = new ArrayList<Object>();
        Integer room;
        String start_date;
        String end_date;

    //======================= Constructor =============================//
    public Selected_room(Integer room, String start_date, String end_date) {
        this.room = room;
        this.start_date = start_date;
        this.end_date = end_date;

        initComponents();

        try {
            // creating a model obj:
            DefaultTableModel table_model_3= new DefaultTableModel();

            // put data into table
            room__bookings.setModel(table_model_3);


            //getting the renderer obj:
            Column_render renderer = new Column_render();
            //setting the renderer for table room_overview.
            room__bookings.setDefaultRenderer(Object.class, renderer);


            //===================-Preparing DB connection======================//
            PreparedStatement prepared_statement = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            //SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
             //start_date = date_format.format(von_chooser.getDate());
            // end_date = date_format.format(bis_chooser.getDate());



            String sql = "SELECT von, bis FROM raum " +
                    "LEFT JOIN gebucht ON (gebucht.raum_nr = raum.raum_nr AND " +
                    "NOT((gebucht.von < ? AND gebucht.bis < ? ) " +
                    "OR (gebucht.von > ? and gebucht.bis > ?))) " +
                    "WHERE (gebucht.raum_nr IS NOT NULL) AND (raum.raum_nr = ?) " +
                    "ORDER BY von ASC";


            prepared_statement = con.prepareStatement(sql);

            prepared_statement.setString(1, start_date);
            prepared_statement.setString(2, start_date);
            prepared_statement.setString(3, end_date);
            prepared_statement.setString(4, end_date);
            prepared_statement.setInt(5, room);


            rs = prepared_statement.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int column_quantity = rsMd.getColumnCount();


            //==================== adding Columns to table  ===============//


            table_model_3.addColumn("Von");
            table_model_3.addColumn("Bis");


            int[] widths = {50, 200, 50, 50};
            for (int i = 0; i < room__bookings.getColumnCount(); i++) {
                room__bookings.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            }

            //--------------getting db data ----------------------//
            while (rs.next()) {
                Object[] rows = new Object[column_quantity];
                for (int i = 0; i < column_quantity; i++) {
                    rows[i] = rs.getObject(i + 1);
                    System.out.println(rows[i]);

                    //table_model_3.addRow(rows);
                }
                //------------populating table with db data------------------//

                table_model_3.addRow(rows);
                refresh_table();
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        room__bookings = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        title_room_nr = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        von_chooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        bis_chooser = new com.toedter.calendar.JDateChooser();
        check_dates_room = new javax.swing.JButton();
        delete_room_booking = new javax.swing.JButton();
        book_room_button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        to_dashboard_button = new javax.swing.JButton();
        Menubar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        room__bookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Von", "Bis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        room__bookings.setColumnSelectionAllowed(true);
        room__bookings.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(room__bookings);
        room__bookings.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        title_room_nr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        title_room_nr.setText("Raum "+ room);

        jLabel2.setText("Von:");

        jLabel3.setText("Bis:");

        check_dates_room.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tablas/images/icons8_date_to_16.png"))); // NOI18N
        check_dates_room.setText("Daten überprüfen");
        check_dates_room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_dates_roomActionPerformed(evt);
            }
        });

        delete_room_booking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tablas/images/icons8_cancel_16.png"))); // NOI18N
        delete_room_booking.setText("Buchung löschen");
        delete_room_booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_room_bookingActionPerformed(evt);
            }
        });

        book_room_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tablas/images/icons8_ok_16.png"))); // NOI18N
        book_room_button.setText("Buchen");
        book_room_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_room_buttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Buchungübersicht");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_room_nr, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(check_dates_room, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bis_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(von_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delete_room_booking, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(book_room_button, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_room_nr, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(von_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bis_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addComponent(check_dates_room, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(delete_room_booking, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(book_room_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(605, Short.MAX_VALUE)))
        );

        to_dashboard_button.setText("Zum Dashboard");
        to_dashboard_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                to_dashboard_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(408, Short.MAX_VALUE)
                .addComponent(to_dashboard_button, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(to_dashboard_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jMenu1.setText("Klassenzimmer");
        Menubar2.add(jMenu1);

        jMenu2.setText("Lehrkräfte");
        Menubar2.add(jMenu2);

        jMenu3.setText("Teilnehmer");
        Menubar2.add(jMenu3);

        jMenu4.setText("Unterricht");
        Menubar2.add(jMenu4);

        jMenu5.setText("Benutzer");
        Menubar2.add(jMenu5);

        setJMenuBar(Menubar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void to_dashboard_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_to_dashboard_buttonActionPerformed
        //new Login().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_to_dashboard_buttonActionPerformed

    private void book_room_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_room_buttonActionPerformed
        //get the user selected room number:
        int row = room__bookings.getSelectedRow();
        int column = room__bookings.getSelectedColumn();
        //Integer selected_room = (Integer) room_overview.getValueAt(row,column);
        Object selected_room = room__bookings.getValueAt(row,column);
        SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
        String start_date = date_format.format(von_chooser.getDate());
        String end_date = date_format.format(bis_chooser.getDate());

        if(column == 0){
            if(free_rooms_list_int.contains(selected_room)){
                Booking booking = new Booking(start_date,end_date,selected_room);
                booking.new_booking();
                System.out.println("Booking was created!");
                JOptionPane.showMessageDialog(null,"Buchung bestätig!");
                check_dates();

            }else {
                System.out.println("Rooms is already booked, delete the booking first!");
                JOptionPane.showMessageDialog(null,"Raum ist bereits gebucht!");
            }
            check_dates();
            refresh_table();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_book_room_buttonActionPerformed

    private void delete_room_bookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_room_bookingActionPerformed
        //get the user selected room number:
        int row = room__bookings.getSelectedRow();
        int column = room__bookings.getSelectedColumn();
        //Integer selected_room = (Integer) room_overview.getValueAt(row,column);
        Object selected_room = room__bookings.getValueAt(row,column);
        SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
        String start_date = date_format.format(von_chooser.getDate());
        String end_date = date_format.format(bis_chooser.getDate());

        if (column ==  0){
            if(free_rooms_list_int.contains(selected_room)){

                System.out.println("There is no booking to delete!");
                JOptionPane.showMessageDialog(null, "Es gibt keine Buchungen zu stornieren!");
            }else{
                Booking booking = new Booking(start_date, end_date,selected_room);
                JOptionPane.showConfirmDialog(null,"Wollen Sie die Buchung wirklich stornieren?");
                booking.delete_booking();
                System.out.println("Booking deleted!");
                JOptionPane.showMessageDialog(null, "Buchung storniert!");

            }
            check_dates();
            refresh_table();

        }
    }//GEN-LAST:event_delete_room_bookingActionPerformed

    private void check_dates_roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_dates_roomActionPerformed
        // checks in db wich rooms are free, fills the free_rooms_list
        check_dates();
    }//GEN-LAST:event_check_dates_roomActionPerformed


    private void refresh_table() {
        room__bookings.repaint();
    }

    private void check_dates(){
        try {
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
            String start_date = date_format.format(von_chooser.getDate());
            String end_date = date_format.format(bis_chooser.getDate());

            if(von_chooser.getDate().after(bis_chooser.getDate())){
                System.out.println("Start date is after end date");
                JOptionPane.showMessageDialog(null,"Das Startdatum muss vor dem Enddatum liegen!");
            }




            String sql = "SELECT von, bis FROM raum " +
                    "LEFT JOIN gebucht ON (gebucht.raum_nr = raum.raum_nr AND " +
                    "NOT((gebucht.von < ? AND gebucht.bis < ? ) " +
                    "OR (gebucht.von > ? and gebucht.bis > ?))) " +
                    "WHERE (gebucht.raum_nr IS NOT NULL) AND (raum.raum_nr = ?) " +
                    "ORDER BY von ASC";


            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, start_date);
            preparedStatement.setString(2, start_date);
            preparedStatement.setString(3, end_date);
            preparedStatement.setString(4, end_date);
            preparedStatement.setInt(5, room);

            rs = preparedStatement.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int column_quantity = rsMd.getColumnCount();


            while (rs.next()) {
                // will store the answer from db, this is only one column with integers:
                Object[] free_rooms_list = new Object[column_quantity];
                //the list free_rooms_list_int is public and will be passed on to column_renderer.

                for (int i = 0; i < column_quantity; i++) {
                    free_rooms_list[i] = rs.getObject(i + 1);
                    free_rooms_list_int.add(free_rooms_list[i]);
                    // Printing to console just to make sure db is ok.
                    System.out.println((int) free_rooms_list[i]);
                }
                //*********************************************commented out refresh table, cant find method
                Column_render renderer = new Column_render();
                room__bookings.setDefaultRenderer(Object.class, renderer);
                refresh_table();

            }


        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }


  private ImageIcon get_image(String file_path){
        // adds icon to a cell 
        java.net.URL url = getClass().getResource(file_path);
        if(url != null) {
            return (new ImageIcon(url));
        }else{
            System.out.println(url);
            return null;
        }
    }
     //todo: ERASE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Selected_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selected_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selected_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selected_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Selected_room().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menubar2;
    private com.toedter.calendar.JDateChooser bis_chooser;
    private javax.swing.JButton book_room_button;
    private javax.swing.JButton check_dates_room;
    private javax.swing.JButton delete_room_booking;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable room__bookings;
    private javax.swing.JLabel title_room_nr;
    private javax.swing.JButton to_dashboard_button;
    private com.toedter.calendar.JDateChooser von_chooser;
    // End of variables declaration//GEN-END:variables
}
