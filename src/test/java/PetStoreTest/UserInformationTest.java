package PetStoreTest;

import org.json.JSONObject;
import org.testng.annotations.Test;
import petStore.UserInformation;

import static org.testng.Assert.assertEquals;

public class UserInformationTest {

    @Test
    public void testUserEntry() {
        // Crear un objeto UserInformation
        UserInformation userInformation = new UserInformation(88, "EzequielD", "Ezequiel", "Camacho", "ezequield@example.com", "pass123", "999888777");

        // Llamar al método UserEntry
        JSONObject userEntry = userInformation.UserEntry();

        // Verificar si el objeto JSONObject contiene los valores esperados
        assertEquals(88, userEntry.getLong("id"));
        assertEquals("EzequielD", userEntry.getString("username"));
        assertEquals("Ezequiel", userEntry.getString("firstName"));
        assertEquals("Camacho", userEntry.getString("lastName"));
        assertEquals("ezequield@example.com", userEntry.getString("email"));
        assertEquals("pass123", userEntry.getString("password"));
        assertEquals("999888777", userEntry.getString("phone"));
    }
}
