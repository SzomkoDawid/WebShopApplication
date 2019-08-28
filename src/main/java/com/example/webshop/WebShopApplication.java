package com.example.webshop;
import com.example.webshop.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
/*@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)*/
public class WebShopApplication {
    private static final Logger logger = LoggerFactory.getLogger(WebShopApplication.class);

    private UserService userService;

    @Autowired
    public WebShopApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        logger.info("main test");
        SpringApplication.run(WebShopApplication.class, args);
    }
}
