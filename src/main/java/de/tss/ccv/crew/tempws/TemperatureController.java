package de.tss.ccv.crew.tempws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class TemperatureController {
    private final TemperatureRepository repository;

    @Autowired
    public TemperatureController(final TemperatureRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "/temperature", method = RequestMethod.GET)
    public Collection<Temperature> findAll() {
        return this.repository.findAll();
    }
}
