package org.propproj.web.service;

import org.propproj.web.entity.Property;
import org.propproj.web.dao.PropertiesRepository;
import org.propproj.web.model.SearchStrategyFactory;
import org.propproj.web.model.SearchStrategyType;
import org.propproj.web.model.SearchStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    @Qualifier("myRepo")
    private PropertiesRepository propertiesRepository;

    private SearchStrategy searchStrategy;

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    @Override
    public Iterable<Property> findAll() {
        return propertiesRepository.findAll();
    }

    @Override
    public void save(Property property){
        propertiesRepository.save(property);
    }

    @Override
    public Iterable<Property> search(String searchString) {
        return searchStrategy.search(searchString);
    }
}
