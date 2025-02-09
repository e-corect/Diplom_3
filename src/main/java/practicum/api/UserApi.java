package practicum.api;

import io.restassured.response.Response;
import practicum.api.responses.UserNameMail;

import static practicum.Constants.*;
import static practicum.Constants.AUTH_USER_PATH;

public class UserApi extends BaseHTTPClient{

    public Response userLogin(UserLogin body){
        return makePostRequest(USER_LOGIN_PATH, body);
    }

    public Response userRegister(UserRegister body){
        return makePostRequest(USER_REGISTER_PATH, body);
    }

    public Response deleteUser(String authToken){
        return makeDeleteRequest(AUTH_USER_PATH, authToken);
    }

    public Response editUserData(String authToken, UserNameMail body){
        return makePatchRequest(AUTH_USER_PATH, authToken, body);
    }
}
