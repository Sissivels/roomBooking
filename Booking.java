package tablas;

import com.toedter.calendar.JDateChooser;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Booking {
    SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
    String start_date;
    String end_date;
    Integer room_number;

    public Booking(String start_date, String end_date, Object room_number) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.room_number = (Integer)room_number;
    }

    public void new_booking(){
        PreparedStatement preparedStatement = null;
        ResultSet result_set = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String sql = "INSERT INTO gebucht (raum_nr,von,bis) VALUES(?,?,?)";

        try {
            preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1, this.room_number);
        preparedStatement.setString(2, this.start_date);
        preparedStatement.setString(3, this.end_date);

        result_set = preparedStatement.executeQuery();
        System.out.println ("Booking added");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete_booking(){
        PreparedStatement preparedStatement = null;
        ResultSet result_set = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String sql = "DELETE from gebucht where raum_nr = ? and von = ? and bis = ?";

        try {
            preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1, this.room_number);
        preparedStatement.setString(2, this.start_date);
        preparedStatement.setString(3, end_date);

        result_set = preparedStatement.executeQuery();
        System.out.println ("Booking deleted");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList show_room_bookings(Integer room_nr){
        ArrayList<Object> bookings = new ArrayList<Object>();

        PreparedStatement preparedStatement = null;
        ResultSet result_set = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String sql = "SElECT von, bis from gebucht where raum_nr = ?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, this.room_number);

            result_set = preparedStatement.executeQuery();
            System.out.println ("Showing bookings for room"+ this.room_number);
            //;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

}
