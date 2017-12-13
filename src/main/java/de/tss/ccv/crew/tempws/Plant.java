package de.tss.ccv.crew.tempws;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@JsonAutoDetect
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    public String deviceId;
    public String deviceName;
    public Double value;
    public Date timestamp;
}
