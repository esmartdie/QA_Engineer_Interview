package petStore;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class DataRetriever {

    private PetStoreConnection miConnection = new PetStoreConnection();
    private String userName;

    public DataRetriever(String username){
        this.userName =username;
    }
    public DataRetriever(){};


    public void getUserData (){
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

    private void processGetUserDataResponse(HttpURLConnection urlConnection) throws IOException {
        StringBuilder response = getHttpGetResponse(urlConnection);

        JSONObject userJson = new JSONObject(response.toString());

        if (userJson.has("password")) {
            userJson.put("password", "********");
        }
        System.out.println("Datos del usuario: " + userJson.toString());
    }

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

    public static StringBuilder retrieveHttpGetResponse(HttpURLConnection urlConnection) throws IOException {
        return getHttpGetResponse(urlConnection);
    }
}
