import com.reactor.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.reactor" )
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        GreetingWebClient client = new GreetingWebClient();
        System.out.println(client.getResult());
    }

}
