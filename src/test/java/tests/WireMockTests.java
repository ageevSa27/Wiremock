package tests;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import objects.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import steps.WireMockTestSteps;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;



public class WireMockTests {



    @RegisterExtension
    static WireMockExtension wm1 = WireMockExtension.newInstance()
            .options(wireMockConfig().port(9897))
            .build();


    @Test
    public void tqw() throws Exception {
        User my = WireMockTestSteps.getUserFromStub("Sergey");
        System.out.println();

    }


}
