package vhgomes.com.schedulerms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vhgomes.com.schedulerms.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
