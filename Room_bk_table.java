package tablas;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
/*
public class Room_bk_table extends javax.swing.JFrame {
    Integer room;


    //----------------Constructor --------------------//
    public Room_bk_table(Integer room) {
        this.room = room;

        initComponents();


        try {

            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
            String start_date = date_format.format(von_chooser.getDate());
            String end_date = date_format.format(bis_chooser.getDate());


            String sql = "SELECT raum.raum_nr, von, bis FROM raum " +
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
            preparedStatement.setInt(4, room);

            rs = preparedStatement.executeQuery();

          //  ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
         //   int cantidadColumnas = rsMd.getColumnCount();

         //   bookings_for_room_table.addColumn("Raum");
          //  bookings_for_room_table.addColumn("Von");
         //   bookings_for_room_table.addColumn("Bis");

/*
            while (rs.next()) {
                Object[] rows = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    rows[i] = rs.getObject(i + 1);
                }

                //*********************************************commented out refresh table, cant find method
                bookings_for_room_table.addRows();

            }



        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }












    }

    public Room_bk_table() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bookings_for_room_table = new javax.swing.JTable();
        Raum_nr_label = new javax.swing.JLabel();
        zum_dashboard = new javax.swing.JButton();
        dates_label = new javax.swing.JLabel();
        von_chooser = new com.toedter.calendar.JDateChooser();
        dates_label1 = new javax.swing.JLabel();
        bis_chooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bookings_for_room_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raum_nr", "Von", "Bis"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bookings_for_room_table);

        Raum_nr_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Raum_nr_label.setText("Raum");

        zum_dashboard.setText("Zum Dashboard");
        zum_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zum_dashboardActionPerformed(evt);
            }
        });

        dates_label.setText("jLabel1");

        dates_label1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dates_label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bis_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Raum_nr_label)
                        .addGap(271, 271, 271))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dates_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(von_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(zum_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Raum_nr_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(von_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dates_label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bis_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dates_label1))
                    .addComponent(zum_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();


















    }// </editor-fold>//GEN-END:initComponents

    private void zum_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zum_dashboardActionPerformed

      //  String campo = txtCampo.getText();
       // String where = "";
       // if (!"".equals(campo)) {
        //    where = "WHERE codigo = '" + campo + "'";
            this.setVisible(false);


    }//GEN-LAST:event_zum_dashboardActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Room_bk_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room_bk_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room_bk_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room_bk_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Room_bk_table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Raum_nr_label;
    private com.toedter.calendar.JDateChooser bis_chooser;
    private javax.swing.JTable bookings_for_room_table;
    private javax.swing.JLabel dates_label;
    private javax.swing.JLabel dates_label1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser von_chooser;
    private javax.swing.JButton zum_dashboard;
    // End of variables declaration//GEN-END:variables
}

*/
