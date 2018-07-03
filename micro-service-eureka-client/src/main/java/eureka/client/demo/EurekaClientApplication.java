package eureka.client.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @RequestMapping("/greeting")
    public String greeting() {
        final StringBuilder msgBuilder = new StringBuilder(LocalDateTime.now().toString())
                .append("---")
                .append("[EurekaClientApplication]")
                .append("--- : Processing greeting request.");
        System.out.println(msgBuilder.toString());
        return "Hello!! This response is from \"/greeting\" endpoint located inside eureka.client.demo.EurekaClientApplication. Application Port: " + System.getProperty("server.port");
    }
}
