package com.example.webshop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class WebShopApplication {
    private static final Logger logger = LoggerFactory.getLogger(WebShopApplication.class);

    public static void main(String[] args) {
        logger.info("main test");
        SpringApplication.run(WebShopApplication.class, args);
    }
}
