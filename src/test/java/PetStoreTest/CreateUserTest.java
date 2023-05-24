package PetStoreTest;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import petStore.CreateUser;

import static org.testng.Assert.assertNotNull;

public class CreateUserTest {

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][]{
                {66, "DiegoM", "Martins", "Diego", "diegom@qaautomation.com", "securepassword", "666777888"},
                {67, "AliceS", "Alice", "Smith", "alice@example.com", "password123", "555444333"},
                {68, "JohnD", "John", "Doe", "johndoe@gmail.com", "pass123", "123456789"},
                {69, "EmmaW", "Emma", "Watson", "emma.watson@example.com", "p@ssw0rd", "987654321"},
                {70, "MikeT", "Mike", "Taylor", "mike@example.com", "secret123", "123123123"}
        };
    }

    @Test(dataProvider = "userData")
    public void testCreateNewUser(int id, String username, String firstName, String lastName, String email, String password, String phone) {
        // Crear un objeto JSONObject con los datos del usuario
        JSONObject userTest = new JSONObject();
        userTest.put("id", id);
        userTest.put("username", username);
        userTest.put("firstName", firstName);
        userTest.put("lastName", lastName);
        userTest.put("email", email);
        userTest.put("password", password);
        userTest.put("phone", phone);

        // Crear un objeto CreateUser
        CreateUser createUser = new CreateUser(userTest);

        // Llamar al método createNewUser
        CreateUser result = createUser.createNewUser();

        // Verificar si el resultado es nulo o no
        assertNotNull(result);
    }
}
