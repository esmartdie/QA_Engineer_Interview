package petStore;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class PetStatus {

    private PetStoreConnection miConnection = new PetStoreConnection();
    private Map<Integer, String> soldPetsMap = new HashMap<>();

    /**
     * Recupera las mascotas vendidas desde la API.
     *
     * @return Un mapa de mascotas vendidas, donde la clave es el ID de la mascota y el valor es su nombre.
     */
    public Map<Integer, String> soldPets() {
        try {
            HttpURLConnection urlConnection = miConnection.buildHttpURLConnection("/pet/findByStatus?status=sold");
            miConnection.doGET(urlConnection);

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                soldPetsMap = processGetSoldPets(urlConnection);
            } else {
                System.out.println("Error al recuperar las mascotas vendidas");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soldPetsMap;
    }

    /**
     * Procesa la respuesta obtenida al recuperar las mascotas vendidas.
     *
     * Obtiene la respuesta HTTP como una cadena utilizando el método retrieveHttpGetResponse()=> clase DataRetriever.
     * Convierte la respuesta en un objeto JSONArray utilizando la clase JSONArray de la biblioteca JSON.
     * Invoca al método renamePets() para renombrar las mascotas y almacenarlas en el mapa soldPetsMap.
     * Retorna el mapa soldPetsMap actualizado.
     *
     * @param urlConnection La conexión HTTP utilizada para realizar la solicitud.
     * @return Un mapa de mascotas vendidas, donde la clave es el ID de la mascota y el valor es su nombre.
     * @throws IOException Si ocurre un error al procesar la respuesta HTTP.
     */
    private  Map<Integer, String> processGetSoldPets(HttpURLConnection urlConnection) throws IOException {
        StringBuilder response = DataRetriever.retrieveHttpGetResponse(urlConnection);
        JSONArray pets = new JSONArray(response.toString());

        // nombres de mascotas vendidas
        renamePets(pets);
        return soldPetsMap;
    }

    /**
     * Renombra las mascotas sin nombre y las agrega al mapa de mascotas vendidas.
     *
     * @param pets Un arreglo JSON de mascotas vendidas.
     */
    private void renamePets(JSONArray pets) {
        for (int i = 0; i < pets.length(); i++) {
            JSONObject pet = pets.getJSONObject(i);
            long id = pet.getLong("id");
            String name = pet.optString("name");
            if (name == null || name.isEmpty()) {
                name = "noName";
            }
            System.out.println("id: " + id +", "+"name:"+name);
            soldPetsMap.put((int) id, name);
        }
    }
}
