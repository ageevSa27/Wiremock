package steps;

import api.ResponseDataContainer;
import api.service.UserService;
import objects.User;
import org.junit.jupiter.api.Assertions;

public class WireMockTestSteps {

    //@Step()
    // p s User qwe(){
    //
    // }


    //@Step()
    public static User getUserFromStub(String userName){

        user = qwe();
        ResponseDataContainer<User> response = UserService.getUserByName("Sergey");
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getData());
        return response.getData();

    }


}
