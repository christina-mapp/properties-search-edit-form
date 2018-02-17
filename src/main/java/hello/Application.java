package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String [] args) {
        SpringApplication.run(Application.class, args);
    }

    // ... continue adding command line runner to text maven in command line.
    // "The class is flagged as a @RestController, meaning ... "
    // https://spring.io/guides/gs/spring-boot/
}
