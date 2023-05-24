package PetStoreTest;

import org.testng.annotations.Test;
import petStore.PetStatus;

import java.util.Map;

import static org.testng.Assert.assertFalse;

public class PetStatusSoldTest {
    @Test
    public void testSoldPets() {

        PetStatus petStatusSold = new PetStatus();
        Map<Integer, String> soldPetsMap = petStatusSold.soldPets();

        // Verificar si el mapa de mascotas vendidas no está vacío
        assertFalse(soldPetsMap.isEmpty());

    }
}
