package vhgomes.com.schedulerms.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vhgomes.com.schedulerms.entities.Channel;
import vhgomes.com.schedulerms.entities.Status;
import vhgomes.com.schedulerms.repositories.ChannelRepository;
import vhgomes.com.schedulerms.repositories.StatusRepository;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values()).map(Channel.Values::toChannel).forEach(channelRepository::save);
        Arrays.stream(Status.Values.values()).map(Status.Values::toStatus).forEach(statusRepository::save);
    }
}
