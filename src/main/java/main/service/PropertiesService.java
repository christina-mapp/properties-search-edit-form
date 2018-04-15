package main.service;

import main.model.Property;

import java.util.Optional;

public interface PropertiesService {
    Iterable<Property> findAll();

    void save(Property property);

    Optional<Property> findById(Long id);

    Optional<Property> findByPropName(String propName);
}
