
package tablas;

import com.toedter.calendar.JDateChooser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends javax.swing.JFrame {

        //======================= Class Variables =============================//
        public static ArrayList<Object> free_rooms_list_int = new ArrayList<Object>();
        String room_str;

    //======================= Constructor =============================//
    public Dashboard() {
        initComponents();
        fill_combo_list();

        try {
            // creating a model obj:
            DefaultTableModel table_model = new DefaultTableModel();

            // put data into table
            room_overview.setModel(table_model);


            //getting the renderer obj:
            Column_render renderer = new Column_render();
            //setting the renderer for table room_overview.
            room_overview.setDefaultRenderer(Object.class, renderer);


            //===================-Preparing DB connection======================//
            PreparedStatement prepared_statement = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();


            String sql = "SELECT raum.raum_nr, raumtyp.beschreibung" +
                    " FROM raum LEFT JOIN raumtyp on raumtyp.raumtyp_id = raum.raumtyp_id" +
                    " ORDER BY raum_nr ASC";
            prepared_statement = con.prepareStatement(sql);
            rs = prepared_statement.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int column_quantity = rsMd.getColumnCount();


            //==================== adding Columns to table 1 (room overview) ===============//

            table_model.addColumn("Raum_nr");
            table_model.addColumn("Raum_typ");


            int[] width = {50, 200, 50, 50};
            for (int i = 0; i < room_overview.getColumnCount(); i++) {
                room_overview.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
            }

            //--------------getting db data ----------------------//
            while (rs.next()) {
                Object[] rows = new Object[column_quantity];
                for (int i = 0; i < column_quantity; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                //------------populating table with db data------------------//

                table_model.addRow(rows);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        //===============adding info for second table rooms_items=====================//
        try {
            DefaultTableModel table_model2 = new DefaultTableModel();
            rooms_items.setModel(table_model2);

            PreparedStatement prepared_statement = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "Select raum.raum_nr,\n" +
                    "SUM(CASE WHEN m_raum.id_aust = 0 THEN menge ELSE 0 END) AS 'Plaetze',\n" +
                    "SUM(CASE WHEN m_raum.id_aust = 1 THEN menge ELSE 0 END) AS 'Beamer',\n" +
                    "SUM(CASE WHEN m_raum.id_aust = 2 THEN menge ELSE 0 END) AS 'Smartboard',\n" +
                    "SUM(CASE WHEN m_raum.id_aust = 3 THEN menge ELSE 0 END) AS 'Flipchart',\n" +
                    "SUM(CASE WHEN m_raum.id_aust = 4 THEN menge ELSE 0 END) AS 'VideoKonf',\n" +
                    "SUM(CASE WHEN m_raum.id_aust = 5 THEN menge ELSE 0 END) AS 'Drucker',\n" +
                    "SUM(CASE WHEN m_raum.id_aust = 6 THEN menge ELSE 0 END) AS 'PC',\n" +
                    "SUM(CASE WHEN m_raum.id_aust = 7 THEN menge ELSE 0 END) AS 'DockingS',\n" +
                    "SUM(CASE WHEN m_raum.id_aust = 8 THEN menge ELSE 0 END) AS 'Tv/media'\n" +
                    "from m_raum\n" +
                    "left join ausstattung\n" +
                    "on m_raum.id_aust = ausstattung.id_aust\n" +
                    "right join raum\n" +
                    " on raum.raum_nr = m_raum.raum_nr\n" +
                    "GROUP BY raum.raum_nr\n";

            prepared_statement = con.prepareStatement(sql);
            rs = prepared_statement.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int column_quantity = rsMd.getColumnCount();

            table_model2.addColumn("Raum_nr");
            table_model2.addColumn("Plätze");
            table_model2.addColumn("Beamer");
            table_model2.addColumn("Smartboard");
            table_model2.addColumn("Flipchart");
            table_model2.addColumn("VideoKonf");
            table_model2.addColumn("Drucker");
            table_model2.addColumn("PC");
            table_model2.addColumn("DockingS");
            table_model2.addColumn("Tv/media");

            while (rs.next()) {
                Object[] rows = new Object[column_quantity];
                for (int i = 0; i < column_quantity; i++) {
                    rows[i] = rs.getObject(i + 1);
                }

                table_model2.addRow(rows);
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
        room_overview = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        von_chooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        bis_chooser = new com.toedter.calendar.JDateChooser();
        check_dates = new javax.swing.JButton();
        delete_booking = new javax.swing.JButton();
        book_button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        room_list_dropdown = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        check_room_booking = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Abmelden_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rooms_items = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
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

        room_overview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raumnummer", "Raumtyp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        room_overview.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(room_overview);
        room_overview.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Raumübersicht");

        jLabel2.setText("Von:");

        jLabel3.setText("Bis:");

        check_dates.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tablas/images/icons8_date_to_16.png"))); // NOI18N
        check_dates.setText("Daten überprüfen");
        check_dates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_datesActionPerformed(evt);
            }
        });

        delete_booking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tablas/images/icons8_cancel_16.png"))); // NOI18N
        delete_booking.setText("Buchung löschen");
        delete_booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_bookingActionPerformed(evt);
            }
        });

        book_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tablas/images/icons8_ok_16.png"))); // NOI18N
        book_button.setText("Buchen");
        book_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_buttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Buchungübersicht");

        jLabel5.setText("Raumnummer");

        room_list_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room_list_dropdownActionPerformed(evt);
            }
        });

        check_room_booking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tablas/images/icons8_date_to_16.png"))); // NOI18N
        check_room_booking.setText("Daten überprüfen");
        check_room_booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_room_bookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(check_dates, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bis_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(von_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room_list_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(check_room_booking, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delete_booking, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(book_button, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(check_dates, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(room_list_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(check_room_booking, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(delete_booking, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(book_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(605, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(355, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(315, 315, 315)))
        );

        Abmelden_button.setText("Abmelden");
        Abmelden_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abmelden_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 972, Short.MAX_VALUE)
                .addComponent(Abmelden_button, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Abmelden_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        rooms_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raum", "Plätze", "Beamer", "Smartboard", "Flipchart", "VideoKonf", "Drucker", "PC", "DockingSt", "Tv/Media"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rooms_items.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(rooms_items);

        jMenu1.setText("Klassenzimmer");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Lehrkräfte");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Teilnehmer");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Unterricht");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Benutzer");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Abmelden_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abmelden_buttonActionPerformed
       int answer = JOptionPane.showConfirmDialog(null, "Wollen Sie sich wirklich abmelden?");

       if (answer == 0){
           new Login().setVisible(true);
           this.setVisible(false);
       }


    }//GEN-LAST:event_Abmelden_buttonActionPerformed


    private void check_datesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_datesActionPerformed
        // checks in db wich rooms are free, fills the free_rooms_list
        check_dates();
        refresh_table();

    }//GEN-LAST:event_check_datesActionPerformed

    private void refresh_table() {
        rooms_items.repaint();
        room_overview.repaint();
    }

    private void check_dates(){

        try {
            free_rooms_list_int.clear();
            refresh_table();
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
            String sql = "SELECT raum.raum_nr "
                    + "FROM raum "
                    + "LEFT JOIN gebucht ON (gebucht.raum_nr = raum.raum_nr AND "
                    + "NOT ((gebucht.von < ? AND gebucht.bis < ? )"
                    + "OR (gebucht.von > ? and gebucht.bis > ?))) "
                    + "WHERE gebucht.raum_nr IS NULL "
                    + "ORDER BY raum.raum_nr ASC";

            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, start_date);
            preparedStatement.setString(2, start_date);
            preparedStatement.setString(3, end_date);
            preparedStatement.setString(4, end_date);

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
                room_overview.setDefaultRenderer(Object.class, renderer);
                refresh_table();

            }

            //table_model.addRow(rows);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }



    private void delete_bookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_bookingActionPerformed
        //get the user selected room number:
        int row = room_overview.getSelectedRow();
        int column = room_overview.getSelectedColumn();
        //Integer selected_room = (Integer) room_overview.getValueAt(row,column);
        Object selected_room = room_overview.getValueAt(row,column);
        SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
        String start_date = date_format.format(von_chooser.getDate());
        String end_date = date_format.format(bis_chooser.getDate());

        if (column ==  0){
            if(free_rooms_list_int.contains(selected_room)){
             System.out.println("There is no booking to delete!");
             JOptionPane.showMessageDialog(null, "Es gibt keine Buchungen zu stornieren!");
            }else{
             Booking booking = new Booking(start_date, end_date,selected_room);
             int answer = JOptionPane.showConfirmDialog(null,"Wollen Sie die Buchung wirklich stornieren?");

             if(answer == 0){
                 booking.delete_booking();
                 System.out.println("Booking deleted!");
                 JOptionPane.showMessageDialog(null, "Buchung storniert!");
             }


            }


        }
        check_dates();
        refresh_table();


    }//GEN-LAST:event_delete_bookingActionPerformed

    private void book_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_buttonActionPerformed
        //get the user selected room number:
        int row = room_overview.getSelectedRow();
        int column = room_overview.getSelectedColumn();
        //Integer selected_room = (Integer) room_overview.getValueAt(row,column);
        Object selected_room = room_overview.getValueAt(row,column);
        SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
        String start_date = date_format.format(von_chooser.getDate());
        String end_date = date_format.format(bis_chooser.getDate());

        if(column == 0){
            if(free_rooms_list_int.contains(selected_room)){
                Booking booking = new Booking(start_date,end_date,selected_room);
                booking.new_booking();
                free_rooms_list_int.remove(selected_room);

                JOptionPane.showMessageDialog(null,"Buchung bestätig!");
                System.out.println("Booking was created!");


                check_dates();
                refresh_table();
            }else {
                System.out.println("Room is already booked, delete the booking first!");
                JOptionPane.showMessageDialog(null,"Das Zimmer ist bereits gebucht, löschen " +
                        "Sie die Buchung zuerst!");
            }

        }
        check_dates();
        refresh_table();

    }//GEN-LAST:event_book_buttonActionPerformed

    private void check_room_bookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_room_bookingActionPerformed
        Date date1 = von_chooser.getDate();
        Date date2 = bis_chooser.getDate();

        if(date1 == null || date2 == null){
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie die Datumsangaben.");
        }

        if (room_str == null){
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie die Raumnummer");
        }
        SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
        System.out.println("Checking given dates...");
        String start_date = date_format.format(date1);
        String end_date = date_format.format(date2);

        System.out.println("Fetching the bookings for the room...");
        Selected_room show_selected_room = new Selected_room(Integer.valueOf(room_str),start_date, end_date);
        show_selected_room.setVisible(true);

          }//GEN-LAST:event_check_room_bookingActionPerformed

    private void room_list_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_list_dropdownActionPerformed
    Object room = room_list_dropdown.getSelectedItem();
    room_str = room.toString();
    System.out.println("room selected: "+ room_str);


    }//GEN-LAST:event_room_list_dropdownActionPerformed


    private void fill_combo_list(){
        
        try {
            PreparedStatement prepared_Statement = null;
            ResultSet result_set = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
           
            //get the room list from the database:
            String sql = "SELECT raum_nr FROM raum ORDER BY raum_nr asc";
            // send sql:
            prepared_Statement = con.prepareStatement(sql);
            result_set = prepared_Statement.executeQuery();

            //read and save info from database:
            while(result_set.next()){
                String room = String.valueOf(result_set.getInt("raum_nr"));
                room_list_dropdown.addItem(room);
            }

            //send info to dropdown.

        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    private ImageIcon get_image(String file_path){
        /* adds icon to a cell */
        java.net.URL url = getClass().getResource(file_path);
        if(url != null) {
            return (new ImageIcon(url));
        }else{
            System.out.println(url);
            return null;
        }
    }

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abmelden_button;
    private com.toedter.calendar.JDateChooser bis_chooser;
    private javax.swing.JButton book_button;
    private javax.swing.JButton check_dates;
    private javax.swing.JButton check_room_booking;
    private javax.swing.JButton delete_booking;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> room_list_dropdown;
    private javax.swing.JTable room_overview;
    private javax.swing.JTable rooms_items;
    private com.toedter.calendar.JDateChooser von_chooser;
    // End of variables declaration//GEN-END:variables
}
