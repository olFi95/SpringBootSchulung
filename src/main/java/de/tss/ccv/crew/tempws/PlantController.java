package de.tss.ccv.crew.tempws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class PlantController {
    private static Logger LOGGER = LoggerFactory.getLogger(PlantController.class);
    private final PlantRepository repository;

    @Autowired
    public PlantController(final PlantRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "/plant", method = RequestMethod.GET)
    public Collection<Plant> findAll() {
        return this.repository.findAll();
    }

    @RequestMapping(path = "/plant/byDeviceName", method = RequestMethod.GET)
    public Collection<Plant> byDeviceName(@RequestParam(required = true) final String deviceName) {
        return this.repository.getByDeviceName(deviceName);
    }

    @RequestMapping(path = "/plant", method = RequestMethod.POST)
    public void put(@RequestBody final Plant plant) {
        if (plant.timestamp == null)
            plant.timestamp = new Date();
        if (plant.value == null)
            throw new IllegalArgumentException("The 'value' parameter must not be null");
        if (StringUtils.isEmpty(plant.deviceName))
            throw new IllegalArgumentException("The 'deviceName' parameter must not be null");
        this.repository.save(plant);
        LOGGER.debug("Saved plant()");
    }
}
