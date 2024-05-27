package api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class BaseApi {
    private final RequestSpecification requestSpecification;

    protected final ObjectMapper mapper = JsonMapper.builder()
            .build();

    public BaseApi(String url) {
        this.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(url)
                .setPort(9897)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setRelaxedHTTPSValidation()
                .build();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }


    public Response sendGet(String endPoint, RequestDataContainer requestDataContainer) {
        Response resp = RestAssured.given()
                .spec(requestSpecification)
                .queryParams(requestDataContainer.getRequestQueryParams())
                .headers(requestDataContainer.getRequestHeaders())
                .when()
                .get(endPoint)
                .thenReturn();
        return resp;
    }

    public <T> Response sendPost(String endPoint, RequestDataContainer<T> requestDataContainer) {
        Response resp = RestAssured.given()
                .spec(requestSpecification)
                .queryParams(requestDataContainer.getRequestQueryParams())
                .headers(requestDataContainer.getRequestHeaders())
                .when()
                .post(endPoint)

                .thenReturn();
        return resp;
    }

    public <T> ResponseDataContainer<T> getEntity(String endPoint, RequestDataContainer requestDataContainer, Class<T> clazz) {
        Response response = sendGet(endPoint, requestDataContainer);
        ResponseDataContainer<T> createItemResponse = new ResponseDataContainer<>();
        try {
            createItemResponse.setData(mapper.readValue(response.asString(), clazz));
            createItemResponse.setStatusCode(response.getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createItemResponse;

    }

}
