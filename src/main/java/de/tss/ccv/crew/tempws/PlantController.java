package de.tss.ccv.crew.tempws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(path = "/plant", method = RequestMethod.POST)
    public void put(@RequestBody final Plant plant) {
        plant.timestamp = new Date();
        this.repository.save(plant);
        LOGGER.debug("Saved plant()");
    }
}
