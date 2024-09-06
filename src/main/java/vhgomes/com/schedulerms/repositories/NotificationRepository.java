package vhgomes.com.schedulerms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vhgomes.com.schedulerms.entities.Notification;
import vhgomes.com.schedulerms.entities.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
