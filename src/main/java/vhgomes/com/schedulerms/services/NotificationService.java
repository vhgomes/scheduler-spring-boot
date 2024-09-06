package vhgomes.com.schedulerms.services;

import org.springframework.stereotype.Service;
import vhgomes.com.schedulerms.dtos.SchedulerNotificationDTO;
import vhgomes.com.schedulerms.entities.Notification;
import vhgomes.com.schedulerms.entities.Status;
import vhgomes.com.schedulerms.repositories.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(SchedulerNotificationDTO dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> getNotification(Long id) {
        return notificationRepository.findById(id);
    }

    public void cancelNotification(Long id) {
        var notification = notificationRepository.findById(id);

        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()
        ), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {
            notification.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(notification);
        };
    }
}
