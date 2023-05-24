package petStore;

import org.json.JSONObject;

public class ManageNewUsers {

    public static void main(String[] args) {
        System.out.println("-----Creacion del usuario--------");
        UserInformation userInformation = new UserInformation(3, "Mariela", "MarielaPa", "Pariata", "marielaP@example.com", "password123", "123456789");
        JSONObject userEntry = userInformation.UserEntry();
        CreateUser newUser = new CreateUser(userEntry).createNewUser();
        System.out.println("-----Consulta del usuario creado--------");
        DataRetriever getUser = new DataRetriever(userInformation.getUsername());
        getUser.getUserData();
    }

}

