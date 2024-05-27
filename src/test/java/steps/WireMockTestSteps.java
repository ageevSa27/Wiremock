package steps;

import api.ResponseDataContainer;
import api.service.UserService;
import objects.User;
import org.junit.jupiter.api.Assertions;

public class WireMockTestSteps {

    public static User getUserFromStub(String userName){

        ResponseDataContainer<User> response = UserService.getUserByName("Sergey");
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getData());
        return response.getData();

    }


}
