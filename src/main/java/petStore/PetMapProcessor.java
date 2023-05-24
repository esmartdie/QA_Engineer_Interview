package petStore;

import java.util.HashMap;
import java.util.Map;

public class PetMapProcessor {
    private Map<Integer, String> petMap;

    public PetMapProcessor(Map<Integer, String> petMap) {
        this.petMap = petMap;
    }

    /**
     * Cuenta la cantidad de mascotas por nombre.
     *
     * @return Un mapa donde la clave es el nombre de la mascota y el valor es la cantidad de mascotas con ese nombre.
     */
    public Map<String, Integer> countPetsByName() {
        Map<String, Integer> result = new HashMap<>();
        for (String petName : petMap.values()) {
            int count = result.getOrDefault(petName, 0);
            result.put(petName, count + 1);
        }
        System.out.println(result);
        return result;
    }
}
