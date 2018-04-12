package main.service;

import main.model.Property;

import java.util.Optional;

public interface PropertiesService {
    Iterable<Property> findAll();

    void save(Property property);

    Optional<Property> findById(int id);

    Optional<Property> findByPropName(String propName);
}
