package petStore;

import org.json.JSONObject;

public class UserInformation {

    private long id;
    private String username, firstName, lastName, email, password, phone;

    public UserInformation(long id, String username, String firstName, String lastName, String email, String password, String phone) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public JSONObject UserEntry(){
        JSONObject userEntry = new JSONObject();
        userEntry.put("id", id);
        userEntry.put("username", username);
        userEntry.put("firstName", firstName);
        userEntry.put("lastName", lastName);
        userEntry.put("email", email);
        userEntry.put("password", password);
        userEntry.put("phone", phone);
        return userEntry;
    }
}
