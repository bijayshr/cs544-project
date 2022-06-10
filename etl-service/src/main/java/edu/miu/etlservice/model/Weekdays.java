package edu.miu.etlservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Weekdays implements Serializable {
    @Id
    @GeneratedValue
    private Short id;
    private String weekday;
}
