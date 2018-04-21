package main.model.search;

import main.model.Property;
import main.model.repository.PropertiesRepository;
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
