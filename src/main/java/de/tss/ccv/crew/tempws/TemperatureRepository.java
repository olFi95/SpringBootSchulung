package de.tss.ccv.crew.tempws;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;

public interface TemperatureRepository extends MongoRepository<Temperature, String> {
    @Query("{'deviceName':  ?0}")
    Collection<Plant> getByDeviceName(String deviceName);
}
