package de.tss.ccv.crew.tempws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TempWsApplication {
    @Autowired
    public RestRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TempWsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TempWsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
	    return (args) -> {
            final Temperature temp = new Temperature();
            temp.deviceId = "someDevie";
            temp.value = 20.4532d;
            temp.timestamp = String.valueOf(System.currentTimeMillis());
            this.repository.save(temp);
            System.out.println("saved");
        };
    }
}
