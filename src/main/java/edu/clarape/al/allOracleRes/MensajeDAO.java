package edu.clarape.al.allOracleRes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {

    public static void crearMensaje(Mensaje mensaje){
        Conexion conn = new Conexion();
        try(Connection cnx = conn.getConnection())
        {
            PreparedStatement ps  =null;
            try {
                String query = "insert into mensaje (mensaje, autor_mensaje) values(?, ?)";
               ps= cnx.prepareStatement(query);
               ps.setString(1,mensaje.getMensaje());
               ps.setString(2,mensaje.getAutorMensaje());
               ps.executeUpdate();
               System.out.println("Mensaje creado correctamente");


            }catch (SQLException e){
                System.out.println(e);
                return;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void leerMensajes(){
        Conexion conn = new Conexion();
        try(Connection cnx = conn.getConnection())
        {
            PreparedStatement ps  =null;
            ResultSet rs = null;
            try {
                String query = "select * from mensaje";
                ps= cnx.prepareStatement(query);
                rs = ps.executeQuery();
                System.out.println("Consuta ejecutada correctamente");
                 while(rs.next()){
                    System.out.println("ID: " + rs.getInt("ID_MENSAJE"));
                    System.out.println("MENSAJE: " + rs.getString("MENSAJE"));
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
                }
            }catch (SQLException e){
                System.out.println(e);
                return;
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void borrarMensaje(int idMensaje){
        Conexion conn = new Conexion();
        try(Connection cnx = conn.getConnection())
        {
            PreparedStatement ps  =null;
            try {
                String query = "delete from mensaje where id_mensaje = ?";
                ps= cnx.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("Mensaje correctamente borrado");
            }catch (SQLException e){
                System.out.println(e);
                return;
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void actualizarMensaje(Mensaje mensaje){
        Conexion conn = new Conexion();
        try(Connection cnx = conn.getConnection())
        {
            PreparedStatement ps  =null;
            try {
                String query = "update mensaje a set a.mensaje = ? where a.id_mensaje = ?";
                ps= cnx.prepareStatement(query);
                ps.setInt(2,mensaje.getIdMensaje());
                ps.setString(1,mensaje.getMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado correctamente");
            }catch (SQLException e){
                System.out.println(e);
                return;
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }
}
