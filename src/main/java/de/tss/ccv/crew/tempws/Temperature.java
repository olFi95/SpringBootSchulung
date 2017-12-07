package de.tss.ccv.crew.tempws;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String deviceId;
    public String deviceName;
    public Double value;
    public Date timestamp;
}