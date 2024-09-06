package vhgomes.com.schedulerms.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vhgomes.com.schedulerms.services.NotificationService;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class VHTaskScheduler {

    private static final Logger logger = LoggerFactory.getLogger(VHTaskScheduler.class);

    private final NotificationService service;

    public VHTaskScheduler(NotificationService service) {
        this.service = service;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void runTasks() {
        var date = LocalDateTime.now();
        logger.info("Running tasks {}", date);
        service.checkAndSend(date);
    }
}
