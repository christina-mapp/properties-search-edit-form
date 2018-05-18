package org.propproj.web.service;

import org.propproj.web.entity.Property;
import org.propproj.web.model.SearchStrategy;

public interface PropertiesService {
    Iterable<Property> findAll();

    void save(Property property);

    Iterable<Property> search(String searchString);

    void setSearchStrategy(SearchStrategy searchStrategy);
}
