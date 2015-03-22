package jp.pnsk.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Application settings.
 * Created by okuda_junko on 14/06/24.
 */
@EnableAutoConfiguration
@ComponentScan("jp.pnsk")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("run start:)");
    }
}
