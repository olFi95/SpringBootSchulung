package de.tss.ccv.crew.tempws;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, String> {
    Plant getByDeviceName(String deviceName);
}
