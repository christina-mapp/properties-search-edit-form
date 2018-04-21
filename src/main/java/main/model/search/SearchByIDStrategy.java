package main.model.search;

import main.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import main.model.repository.PropertiesRepository;
import org.springframework.stereotype.Component;

@Component("searchByIDStrategy")
public class SearchByIDStrategy implements SearchStrategy {

    @Autowired
    @Qualifier("myRepo")
    private PropertiesRepository propertiesRepository;

    public SearchByIDStrategy(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }

    @Override
    public Iterable<Property> search(String searchText) {
        return propertiesRepository.findById(Long.valueOf(searchText));
    }
}
