package practicum.api;

public class UserRegister extends UserLogin{

    private String name;

    public UserRegister(String email, String password, String name) {
        super(email, password);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

}
