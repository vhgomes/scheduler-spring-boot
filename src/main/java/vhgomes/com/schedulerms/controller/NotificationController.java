package vhgomes.com.schedulerms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vhgomes.com.schedulerms.dtos.SchedulerNotificationDTO;
import vhgomes.com.schedulerms.entities.Notification;
import vhgomes.com.schedulerms.services.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<?> schedulerNotification(@RequestBody SchedulerNotificationDTO dto) {
        notificationService.scheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notification_id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long notification_id) {
        var notification = notificationService.getNotification(notification_id);

        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(notification.get());

    }

    @PutMapping("/{notification_id}")
    public ResponseEntity<?> deleteNotificationById(@PathVariable Long notification_id) {
        notificationService.cancelNotification(notification_id);
        return ResponseEntity.noContent().build();
    }
}
