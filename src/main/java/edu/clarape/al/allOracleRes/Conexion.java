package edu.clarape.al.allOracleRes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Conexion {
    public Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/orcl",
                    "appall",
                    "r3b3qu1t4"
                    );
            //System.out.println("******* Conectado! *******");
            return conn;
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do{
            System.out.println("=======================");
            System.out.println(" APLICACION DE MENSAJES ");
            System.out.println(" 1. CREAR MENSAJE ");
            System.out.println(" 2. LISTAR MENSAJES ");
            System.out.println(" 3. EDITAR MENSAJE ");
            System.out.println(" 4. ELIMINAR MENSAJE ");
            System.out.println(" 5. SALIR ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    MensajeServices.crearMensaje();
                    break;
                case 2:
                    MensajeServices.listarMensajes();
                    break;
                case 3:
                    MensajeServices.actualizarMensaje();
                    break;
                case 4:
                    MensajeServices.borrarMensaje();
                    break;
                default:
                    System.out.println("....saliendo!");
                    break;

            }

        }while(opcion != 5);

        /*
        Conexion conn = new Conexion();
        Connection cxx = conn.getConnection();
        */
    }
}
