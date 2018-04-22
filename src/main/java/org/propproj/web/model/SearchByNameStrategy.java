package org.propproj.web.model;

import org.propproj.web.entity.Property;
import org.propproj.web.dao.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("searchByNameStrategy")
public class SearchByNameStrategy implements SearchStrategy {

    @Autowired
    @Qualifier("myRepo")
    private PropertiesRepository propertiesRepository;

    @Override
    public Iterable<Property> search(String searchText) {
        return propertiesRepository.findByPropNameContaining(searchText);
    }
}
