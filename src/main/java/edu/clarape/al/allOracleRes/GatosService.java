package edu.clarape.al.allOracleRes;

import com.google.gson.Gson;
import okhttp3.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class GatosService {
    public void verGatitos() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET",null)
                .build();
            Response  response = client.newCall(request).execute();
            String jsonResponse = response.body().string();

            //Se extraerá el objeto #1 del arreglo: (una forma arcaica impartida
            //por el dev-teacher)
            //jsonResponse = jsonResponse.substring(1,jsonResponse.length());
            jsonResponse = jsonResponse.substring(1,jsonResponse.length()-1);

            //Se crea el objeto json
            Gson gson = new Gson();
            Gatos gatos = gson.fromJson(jsonResponse, Gatos.class);

            //Redimensionar tamaño de imagen
            Image image = null;
            try{
                URL url = new URL(gatos.getUrl());
                image = ImageIO.read(url);
                ImageIcon fondoGato = new ImageIcon(image);
                if (fondoGato.getIconWidth() > 800){
                    Image fondo = fondoGato.getImage();
                    Image modificada = fondo.getScaledInstance(800,600, Image.SCALE_SMOOTH);
                    fondoGato = new ImageIcon(modificada);
                }

                String menu =  "Opciones: \n1.- Cambiar Gatitos \n2.-Favorito \n3.-Volver ";
                String botones[] = {
                        "1. Ver Otra imagen",
                        "2. Favoritos",
                        "3. Volver"
                };
                String idGato = gatos.getId();
                String opcion = (String) JOptionPane.showInputDialog(null,menu,idGato,JOptionPane.INFORMATION_MESSAGE
                        ,fondoGato,botones,botones[0]);

                int seleccion = -1;

                for(int i = 0; i < botones.length;i++){
                    if(opcion.equals(botones[i])){
                        seleccion = i;
                    }
                }

                switch(seleccion){
                    case 0:
                        verGatitos();
                        break;
                    case 1:
                        marcarGatoAFavoritos(idGato);
                        break;
                    default:
                        break;
                }



            }catch(Exception e){
                e.printStackTrace();
            }




    }
    public void marcarGatoAFavoritos(String idGato) throws IOException {
        final String DEMO_API_KEY = "e139eece-80d9-456d-b86a-1d119e0c4816";
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"image_id\":\"" + idGato + "\",\"sub_id\":\"your-user-1234\"}");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("x-api-key", DEMO_API_KEY)
                .build();
        Response response = client.newCall(request).execute();
        int ret = 1;
    }
}
