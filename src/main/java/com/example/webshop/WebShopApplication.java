package com.example.webshop;
import com.example.webshop.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.webshop")
public class WebShopApplication  {
    private static final Logger logger = LoggerFactory.getLogger(WebShopApplication.class);

    public static void main(String[] args) {
        logger.info("main test");
        SpringApplication.run(WebShopApplication.class, args);
        User user = new User();
    }
}
