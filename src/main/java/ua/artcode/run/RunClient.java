package ua.artcode.run;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ua.artcode"})
public class RunClient {
    public static void main(String[] args) {
        SpringApplication.run(RunClient.class, args);
    }
}
