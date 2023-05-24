package petStore;

import org.json.JSONObject;

import java.net.HttpURLConnection;

public class CreateUser {

    private PetStoreConnection miConnection = new PetStoreConnection();
    private JSONObject objectJson;
    public CreateUser(JSONObject objectJson){
        this.objectJson=objectJson;
    }
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
