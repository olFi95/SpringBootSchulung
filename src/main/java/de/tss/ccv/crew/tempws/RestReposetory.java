package de.tss.ccv.crew.tempws;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
interface RestReposetory extends CrudRepository<Temperature, String> {

}
