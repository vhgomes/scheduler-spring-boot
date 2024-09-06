package vhgomes.com.schedulerms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vhgomes.com.schedulerms.entities.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
