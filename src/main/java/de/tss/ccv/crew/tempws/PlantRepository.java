package de.tss.ccv.crew.tempws;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;

public interface PlantRepository extends MongoRepository<Plant, String> {
    @Query("{'deviceName':  ?0}")
    Collection<Plant> getByDeviceName(String deviceName);
}
