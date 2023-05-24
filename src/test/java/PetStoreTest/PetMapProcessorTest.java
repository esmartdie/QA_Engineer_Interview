package PetStoreTest;

import org.testng.annotations.Test;
import petStore.PetMapProcessor;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PetMapProcessorTest {

    @Test
    public void testCountPetsByName() {
        // simulación mascotas vendidas
        Map<Integer, String> petMap = new HashMap<>();
        petMap.put(1, "Dog");
        petMap.put(2, "Cat");
        petMap.put(3, "Dog");
        petMap.put(4, "Bird");

        PetMapProcessor petMapProcessor = new PetMapProcessor(petMap);
        Map<String, Integer> result = petMapProcessor.countPetsByName();

        // Verificar si el mapa de conteo de mascotas por nombre contiene los valores esperados
        assertEquals(2, result.get("Dog").intValue());
        assertEquals(1, result.get("Cat").intValue());
        assertEquals(1, result.get("Bird").intValue());

    }
}
