import io.qameta.allure.Step;
import io.restassured.response.Response;
import practicum.Utils;
import practicum.api.UserApi;
import practicum.api.UserLogin;
import practicum.api.UserRegister;

import static practicum.Constants.USER_PWD;

public class UserSteps {

    private Response response;

    private UserRegister userRegister;

    private UserApi userApi = new UserApi();

    public String getUserEmail(){
        return userRegister.getEmail().toString();
    }

    @Step("Аутентификация пользователя в системе. Данные берутся из объекта UserSteps")
    public UserSteps userLogin(String email, String pwd){
        UserLogin body = new UserLogin(email, pwd);
        response = userApi.userLogin(body);
        return this;
    }

    @Step("Удаляем пользователя из системы")
    public UserSteps deleteUser(){
        userApi.deleteUser(response.getBody().jsonPath().get("accessToken").toString().split(" ")[1]);
        return this;
    }

    @Step("Генерируем данные пользователя и создаем объект")
    public UserSteps createRandomUser(){
        String userName = Utils.generateFirstName();
        userRegister = new UserRegister(Utils.generateEmail(userName), USER_PWD, userName);
        return this;
    }
    @Step("Отправляем запрос на регистрацию пользователя в системе")
    public UserSteps registerUser(){
        response = userApi.userRegister(userRegister);
        return this;
    }
}
