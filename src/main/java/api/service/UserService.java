package api.service;

import api.BaseApi;
import api.RequestDataContainer;
import api.ResponseDataContainer;
import objects.User;

import java.io.Serializable;

public class UserService implements Serializable {


    public static ResponseDataContainer<User> getUserByName(String name) {
        BaseApi api = new BaseApi("http://127.0.0.1");
        RequestDataContainer requestDataContainer = new RequestDataContainer<>();
        requestDataContainer.addQueryPram("name", name);
        return api.getEntity("/currentUser", requestDataContainer, User.class);

    }

}
