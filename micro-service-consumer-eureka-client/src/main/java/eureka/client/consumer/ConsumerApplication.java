package eureka.client.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConsumerApplication {
    @Autowired
    private Consumer consumer;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/eureka/client/consume")
    public void consume() {
        consumer.getMessageFromEurekaClient();
    }
}
