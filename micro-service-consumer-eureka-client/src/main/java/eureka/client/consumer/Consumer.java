package eureka.client.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class Consumer {
    @Autowired
    private RestTemplate restTemplate;

    public void getMessageFromEurekaClient(){
        final String response = restTemplate.exchange(
                "http://eureka-client/greeting",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                })
                .getBody();

        System.out.println(response);
    }
}
