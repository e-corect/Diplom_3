import io.qameta.allure.Step;
import io.restassured.response.Response;
import practicum.api.UserApi;
import practicum.api.UserLogin;

public class UserSteps {

    Response response;

    UserApi userApi = new UserApi();

    @Step("Аутентификация пользователя в системе. Данные берутся из объекта Users.UserSteps")
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
}
