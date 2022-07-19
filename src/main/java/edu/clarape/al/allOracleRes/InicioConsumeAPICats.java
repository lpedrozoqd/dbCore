package edu.clarape.al.allOracleRes;

import javax.swing.*;
import java.io.IOException;

public class InicioConsumeAPICats {
    public static void main(String[] args) {
        int opcionMenu = -1;
        String[] botones = {
          "1. Ver gatos",
          "2. Salir"
        };

        do{
            //Config de la UI
            String opcion = (String)JOptionPane.showInputDialog(
                    null,
                    "Gatitos java",
                    "Menu principal",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botones,
                    botones[0]);

            //Validamos que opción selecciona el usuario
            for(int i = 0; i < botones.length; i++ ){
                if (opcion.equals(botones[i])){
                    opcionMenu = i;
                }
            }

            switch (opcionMenu){
                case 0:
                    GatosService g = new GatosService();
                    try {
                        g.verGatitos();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }while(opcionMenu != 1);
    }
}
