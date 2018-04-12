package main.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String propName;
    private String description;

    protected Property() {}

    public Property(String propName, String description) {
        this.propName = propName;
        this.description = description;
    }

}