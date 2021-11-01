package tablas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Rooms {
    int room_nr;
    //ArrayList<Object> bookings = new ArrayList<Object>();
    private static ArrayList<Integer> rooms = new ArrayList<Integer>();

    public Rooms() {

    //}

    //private void room_list(){
        //connect to db
        try {
            PreparedStatement preparedStatement = null;
            ResultSet result_set = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");

            //get the room list from the database:
            String sql = "SELECT raum_nr FROM raum";
            // send sql:
            preparedStatement = con.prepareStatement(sql);


            //read and save info from database:


            while(result_set.next()){
                rooms.add(result_set.getInt("raum_nr"));
            }

            //send info to dropdown.




    } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
