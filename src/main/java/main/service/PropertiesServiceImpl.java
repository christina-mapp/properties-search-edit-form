package main.service;

import main.model.Property;
import main.model.search.*;
import main.model.repository.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    @Qualifier("myRepo")
    private PropertiesRepository propertiesRepository;

    @Resource(name = "searchStrategyFactory")
    private SearchStrategyFactory searchStrategyFactory;

    private SearchStrategy searchStrategy;

    @Override
    public Iterable<Property> findAll() {
        return propertiesRepository.findAll();
    }

    @Override
    public void save(Property property){
        propertiesRepository.save(property);
    }

    @Override
    public Iterable<Property> searchByPropName(String propName) {
        searchStrategy = searchStrategyFactory.getSearchStrategy(SearchStrategyType.BYNAME);
        return searchStrategy.search(propName);
    }

    @Override
    public Iterable<Property> searchByType(String type) {
        searchStrategy = searchStrategyFactory.getSearchStrategy(SearchStrategyType.BYTYPE);
        return searchStrategy.search(type);
    }

    @Override
    public Iterable<Property> searchByDescription(String description) {
        searchStrategy = searchStrategyFactory.getSearchStrategy(SearchStrategyType.BYDESCRIPTION);
        return searchStrategy.search(description);
    }

    @Override
    public Iterable<Property> searchById(Long id) {
        searchStrategy = searchStrategyFactory.getSearchStrategy(SearchStrategyType.BYID);
        return searchStrategy.search(""+id);
    }
}
