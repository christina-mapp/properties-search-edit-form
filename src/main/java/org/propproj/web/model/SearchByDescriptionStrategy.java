package org.propproj.web.model;

import org.propproj.web.dao.PropertiesRepository;
import org.propproj.web.entity.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("searchByDescriptionStrategy")
public class SearchByDescriptionStrategy implements SearchStrategy {

    @Autowired
    @Qualifier("myRepo")
    private PropertiesRepository propertiesRepository;

    public SearchByDescriptionStrategy(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }

    @Override
    public Iterable<Property> search(String searchText) {
        return propertiesRepository.findByDescriptionContaining(searchText);
    }
}
