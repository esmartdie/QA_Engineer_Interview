package petStore;

import org.json.JSONObject;

import java.net.HttpURLConnection;

public class CreateUser {

    private PetStoreConnection miConnection = new PetStoreConnection();
    private JSONObject objectJson;

    /**
     * Constructor de la clase CreateUser que recibe el objeto JSON de entrada.
     */
    public CreateUser(JSONObject objectJson){
        this.objectJson=objectJson;
    }

    /**
     * Crea un nuevo usuario en la tienda de mascotas utilizando la conexión y el objeto JSON proporcionados.
     * Devuelve una nueva instancia de CreateUser.
     */
    public CreateUser createNewUser(){

        try {
            HttpURLConnection urlConnection = miConnection.buildHttpURLConnection("/user");
            miConnection.doPOST(urlConnection, objectJson);

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Usuario creado exitosamente");
            } else {
                System.out.println("Error al crear el usuario");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CreateUser(objectJson);
    }

}
