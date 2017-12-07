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
public class TemperatureController {
    private final TemperatureRepository repository;
    private static Logger LOGGER = LoggerFactory.getLogger(TemperatureController.class);

    @Autowired
    public TemperatureController(final TemperatureRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "/temperature", method = RequestMethod.GET)
    public Collection<Temperature> findAll() {
        return this.repository.findAll();
    }

    @RequestMapping(path = "/temperature", method = RequestMethod.POST)
    public void put(@RequestBody final Temperature temp) {
        temp.timestamp = new Date();
        this.repository.save(temp);
        LOGGER.debug("Saved temp()");
    }
}
