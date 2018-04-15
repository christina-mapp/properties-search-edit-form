package main.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String propName;
    private String description;
    private String type;

    protected Property() {}

    public Property(String propName, String description, String type) {
        this.propName = propName;
        this.description = description;
        this.type = type;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Property;
    }
}