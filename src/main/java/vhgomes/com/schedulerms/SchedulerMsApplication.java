package vhgomes.com.schedulerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulerMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerMsApplication.class, args);
    }

}
