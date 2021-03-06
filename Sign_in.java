
package tablas;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author VelazquezSilwanySiha
 */
public class Sign_in extends javax.swing.JFrame {

    /**
     * Creates new form Sign_in
     */
    public Sign_in() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        message = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name_textbox = new javax.swing.JTextField();
        username_textbox = new javax.swing.JTextField();
        lastname_textbox = new javax.swing.JTextField();
        password_box = new javax.swing.JPasswordField();
        pass_confirm = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        confirm_emp = new javax.swing.JButton();
        clear_emp = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        anmelden_button = new javax.swing.JButton();

        message.setText("Das Passwort muss folgende Bedingungen erfüllen:\n                       - Es enthält mindestens 8 und höchstens 20 Zeichen.\n                       - Es enthält mindestens ein Großbuchstaben.\n                       - Es enthält mindestens eine Ziffer.\n                       - Es enthält mindestens ein Kleinbuchstaben.\n                       - Es enthält mindestens ein Sonderzeichen, darunter !@#$%&*()-+=^.\\n\n                       - Er enthält keine Leerzeichen.");
        message.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Neue Benutzer angeben");

        jLabel2.setText("Vorname");

        jLabel3.setText("Nachname");

        jLabel4.setText("Passwort");

        jLabel5.setText("Benutzername");

        lastname_textbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname_textboxActionPerformed(evt);
            }
        });

        password_box.setToolTipText("");
        password_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_boxActionPerformed(evt);
            }
        });

        jLabel6.setText("Passwort bestätigen ");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        confirm_emp.setText("Bestätigen");
        confirm_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_empActionPerformed(evt);
            }
        });

        clear_emp.setText("Löschen");
        clear_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_empActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Das Passwort muss folgende Bedingungen erfüllen:    Es enthält mindestens 8 und höchstens 20 Zeichen, ");

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText(" ein Großbuchstaben, eine Ziffer, ein Kleinbuchstaben und  ein Sonderzeichen ( !@#$%&*()-+=^).");

        anmelden_button.setText("Anmelden");
        anmelden_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anmelden_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_textbox)
                            .addComponent(lastname_textbox)
                            .addComponent(username_textbox)
                            .addComponent(password_box)
                            .addComponent(pass_confirm)
                            .addComponent(confirm_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(clear_emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(anmelden_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(117, 117, 117))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(lastname_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(confirm_emp)
                .addGap(18, 18, 18)
                .addComponent(clear_emp)
                .addGap(18, 18, 18)
                .addComponent(anmelden_button)
                .addGap(83, 83, 83)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirm_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_empActionPerformed

        // getting information that user introduced:
        String name = name_textbox.getText();
        String last_name = lastname_textbox.getText();
        Integer new_id = null;
        String user_name = username_textbox.getText();

        //-----------------checking if username exist-------------------//
        try {
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql_0 = "SELECT user_login FROM com_gmbh WHERE username = ?";

            preparedStatement = con.prepareStatement(sql_0);

            preparedStatement.setString(1, user_name);

            rs = preparedStatement.executeQuery();

            if(!rs.isBeforeFirst()){ // user not found


        try{

            //------------------Hashing Pasword-----------------------//

            String username = username_textbox.getText();
            String password = String.valueOf(password_box.getPassword());

            //-------------------Validating password min requierments--------//

            boolean validation = validate_password(password);

            if (validation == false){
                JOptionPane.showMessageDialog(null,
                        "Das Passwort muss folgende Bedingungen erfüllen:\n" +
                        "- Es enthält mindestens 8 und höchstens 20 Zeichen.\n" +
                        "- Es enthält mindestens ein Großbuchstaben.\n" +
                        "- Es enthält mindestens eine Ziffer.\n" +
                        "- Es enthält mindestens ein Kleinbuchstaben.\n" +
                        "- Es enthält mindestens ein Sonderzeichen, darunter !@#$%&*()-+=^.\n" +
                        "- Er enthält keine Leerzeichen. ");

            }



            //--------------------confirmating the given password-----------//
            String password_confirm = String.valueOf(pass_confirm.getPassword());
            String hashed_p = null;
            Integer new_user_id = null;


        if (password.equals(password_confirm)) {
            H512 hash = new H512();
            hashed_p = hash.encrypter(password);
            System.out.println("Hashing ok!");


            //---------------------connecting to get mitarbeiter----------------//

            preparedStatement = null;
            rs = null;
            conn = new Conexion();
            con = conn.getConexion();

            String sql = "SELECT MAX(id_mitarbeiter) FROM mitarbeiter";

            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer last_id = rs.getInt("MAX(id_mitarbeiter)");
                new_id = last_id + 1;
            }

            //-----------------------inserting the mitarbeiter in DB---------------//

            String sql_2 = "INSERT INTO mitarbeiter (id_mitarbeiter,vorname,name) VALUES (?, ?, ?)";

            preparedStatement = con.prepareStatement(sql_2);

            preparedStatement.setInt(1, new_id );
            preparedStatement.setString(2, name );
            preparedStatement.setString(3, last_name );
            rs = preparedStatement.executeQuery();
            System.out.println("Employee was added to the database");

            JOptionPane.showMessageDialog(null,"Neuer Mitarbeiter wurde hinzugefügt");


            //-----coneccting tod db--------//
             preparedStatement = null;
             rs = null;
             conn = new Conexion();
             con = conn.getConexion();



            String sql_3 = "SELECT MAX(user_login) FROM com_gmbh";

            preparedStatement = con.prepareStatement(sql_3);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer last_id = rs.getInt("MAX(user_login)");
                new_user_id = last_id + 1;
            }


            String sql_4 = "INSERT INTO com_gmbh (user_login, pass_word, id_mitarbeiter, username) VALUES (?,?,?,?)";


            preparedStatement = con.prepareStatement(sql_4);

            preparedStatement.setInt(1, new_user_id);
            preparedStatement.setString(2, hashed_p);
            preparedStatement.setInt(3, new_id);
            preparedStatement.setString(4,user_name );

            rs = preparedStatement.executeQuery();

            JOptionPane.showMessageDialog(null,"Neue Benutzer wurde hinzugefügt!");
            con.close();


        }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }else{
                JOptionPane.showMessageDialog(null,"Der Benutzername ist bereits vergeben, " +
                        "bitte wählen Sie einen anderen.");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }



    }//GEN-LAST:event_confirm_empActionPerformed

    private void lastname_textboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname_textboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname_textboxActionPerformed


    public static boolean validate_password(String password){
        /* Method to validate if passwords minimun requierments are met, takes the password as argument */

        //Regular expression with password min requierments:
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // create a pattern class object, use compile method on regex
        Pattern pattern = Pattern.compile(regex);

        // if password is empty it throws false.
        if(password == null){
            return false;
        }

        // create a matcher obj to use the matcher method on password
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }







    private void clear_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_empActionPerformed
    lastname_textbox.setText("");
    name_textbox.setText("");
    pass_confirm.setText("");
    password_box.setText("");
    username_textbox.setText("");       

        
    }//GEN-LAST:event_clear_empActionPerformed

    private void password_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_boxActionPerformed

        
        
        
    }//GEN-LAST:event_password_boxActionPerformed

    private void anmelden_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anmelden_buttonActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_anmelden_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_in().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anmelden_button;
    private javax.swing.JButton clear_emp;
    private javax.swing.JButton confirm_emp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lastname_textbox;
    private javax.swing.JLabel message;
    private javax.swing.JTextField name_textbox;
    private javax.swing.JPasswordField pass_confirm;
    private javax.swing.JPasswordField password_box;
    private javax.swing.JTextField username_textbox;
    // End of variables declaration//GEN-END:variables
}
