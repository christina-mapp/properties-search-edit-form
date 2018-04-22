package org.propproj.web.service;

import org.propproj.web.entity.Property;

public interface PropertiesService {
    Iterable<Property> findAll();

    void save(Property property);

    Iterable<Property> searchByPropName(String propName);

    Iterable<Property> searchByType(String type);

    Iterable<Property> searchByDescription(String description);

    Iterable<Property> searchById(Long id);
}
