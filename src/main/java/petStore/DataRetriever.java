package petStore;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class DataRetriever {

    private PetStoreConnection miConnection = new PetStoreConnection();
    private String userName;

    /**
     * Constructor de la clase DataRetriever que recibe el nombre de usuario.
     */
    public DataRetriever(String username){
        this.userName =username;
    }

    public DataRetriever(){};


    /**
     * Recupera los datos del usuario de la tienda de mascotas utilizando la conexión y el nombre de usuario proporcionados.
     */
    public void getUserData (){
        // Establecer la conexión, realizar la solicitud GET y procesar la respuesta
        try {
            HttpURLConnection urlConnection = miConnection.buildHttpURLConnection("/user/"+ userName);
            miConnection.doGET(urlConnection);

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                processGetUserDataResponse(urlConnection);
            } else {
                System.out.println("Error al recuperar los datos del usuario");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Procesa la respuesta de la solicitud GET y muestra los datos del usuario.
     * Oculta la contraseña del usuario reemplazándola con asteriscos.
     */
    private void processGetUserDataResponse(HttpURLConnection urlConnection) throws IOException {
        StringBuilder response = getHttpGetResponse(urlConnection);

        JSONObject userJson = new JSONObject(response.toString());

        if (userJson.has("password")) {
            userJson.put("password", "********");
        }
        System.out.println("Datos del usuario: " + userJson.toString());
    }

    /**
     * Retorna la respuesta de la solicitud GET en forma de StringBuilder.
     *
     * BufferedReader  se utiliza para leer la respuesta de la solicitud HTTP
     * inputLine que se utilizará para almacenar cada línea leída de la respuesta.
     * StringBuilder permite construir una cadena de caracteres
     * Se inicia un bucle while que continúa hasta que no haya más líneas en la respuesta (inputLine es nulo).
     * Dentro del bucle, se lee cada línea de la respuesta y se agrega al StringBuilder utilizando el método append.
     */
    private static StringBuilder getHttpGetResponse(HttpURLConnection urlConnection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response;
    }

    /**
     * Envoltura para getHttpGetResponse().
     * Utilizado para obtener la respuesta de la solicitud GET desde otras clases.
     */
    public static StringBuilder retrieveHttpGetResponse(HttpURLConnection urlConnection) throws IOException {
        return getHttpGetResponse(urlConnection);
    }
}
