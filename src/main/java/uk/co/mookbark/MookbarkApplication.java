package uk.co.mookbark;

import uk.co.mookbark.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class MookbarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MookbarkApplication.class, args);
    }

}
