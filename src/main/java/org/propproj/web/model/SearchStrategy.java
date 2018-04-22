package org.propproj.web.model;

import org.propproj.web.entity.Property;

public interface SearchStrategy {
    Iterable<Property> search(String searchText);
}
