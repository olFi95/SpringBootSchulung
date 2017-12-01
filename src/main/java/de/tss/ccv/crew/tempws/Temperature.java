package de.tss.ccv.crew.tempws;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Temperature {
    @Id
    public String deviceId;
    public String deviceName;
    public Double value;
    public String timestamp;
}