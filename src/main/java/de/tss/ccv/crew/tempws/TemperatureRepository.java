package de.tss.ccv.crew.tempws;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<Temperature, String> {
    Temperature getByDeviceName(String deviceName);
}
