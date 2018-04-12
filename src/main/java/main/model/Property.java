package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String propName;
    private String propDesc;

    protected Property() {}

    public Property(String propName, String propDesc) {
        this.propName = propName;
        this.propDesc = propDesc;
    }

    @Override
    public String toString() {
        return String.format(
                "Property[id=%d, firstName='%s', lastName='%s']",
                id, propName, propDesc);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getDescription() {
        return propDesc;
    }

    public void setDescription(String description) {
        this.propDesc = description;
    }
}