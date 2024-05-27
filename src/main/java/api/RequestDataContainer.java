package api;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class RequestDataContainer<T> {
    private T requestBody;
    private Map<String, String> requestHeaders = new HashMap<>();
    private Map<String, String> requestQueryParams = new HashMap<>();


    public void addHeader(String header, String value) {
        requestHeaders.put(header, value);
    }

    public void addQueryPram(String param, String value) {
        requestQueryParams.put(param, value);
    }

}
