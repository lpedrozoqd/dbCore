package edu.clarape.al.allOracleRes;

import java.util.Scanner;

public class MensajeServices {

    public static void crearMensaje(){
        System.out.println("***CREAR-MENSAJE***");
        Scanner sc = new Scanner(System.in);
        System.out.println(">>>Escribe tú mensaje:");
        String mensaje = sc.nextLine();
        System.out.println(">>>Escribe tú nombre:");
        String nombre = sc.nextLine();
        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);
        MensajeDAO.crearMensaje(registro);
    }

    public static void listarMensajes(){
        System.out.println("***LEER-MENSAJE***");
        MensajeDAO.leerMensajes();
    }

    public static void borrarMensaje() {
        System.out.println("***BORRAR-MENSAJE***");
        Scanner sc = new Scanner(System.in);
        System.out.println(">>>Id del mensaje:");
        String id = sc.nextLine();
        MensajeDAO.borrarMensaje(Integer.parseInt(id));
    }

    public static void actualizarMensaje() {
        System.out.println("***ACTUALIZAR-MENSAJE***");
        Scanner sc = new Scanner(System.in);
        System.out.println(">>>Id de mensaje:");
        String id = sc.nextLine();
        System.out.println(">>>Mensaje");
        String mensaje = sc.nextLine();
        Mensaje actualizacionMensaje = new Mensaje();
        actualizacionMensaje.setMensaje(mensaje);
        actualizacionMensaje.setIdMensaje(Integer.parseInt(id));
        MensajeDAO.actualizarMensaje(actualizacionMensaje);

    }
}
