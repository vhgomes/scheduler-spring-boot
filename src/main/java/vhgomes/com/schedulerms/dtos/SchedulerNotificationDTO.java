package vhgomes.com.schedulerms.dtos;

import vhgomes.com.schedulerms.entities.Channel;
import vhgomes.com.schedulerms.entities.Notification;
import vhgomes.com.schedulerms.entities.Status;

import java.time.LocalDateTime;

public record SchedulerNotificationDTO(LocalDateTime dateTime,
                                       String destination,
                                       String message,
                                       Channel.Values channel) {

    public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
