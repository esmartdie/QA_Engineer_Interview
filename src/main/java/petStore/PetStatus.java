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

    private  Map<Integer, String> processGetSoldPets(HttpURLConnection urlConnection) throws IOException {
        StringBuilder response = DataRetriever.retrieveHttpGetResponse(urlConnection);
        JSONArray pets = new JSONArray(response.toString());

        // nombres de mascotas vendidas
        renamePets(pets);
        return soldPetsMap;
    }

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
