package main.service;

import main.model.Property;
import main.repository.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertiesServiceImpl implements PropertiesService{

    @Autowired
    private PropertiesRepository propertiesRepository;

    @Override
    public Iterable<Property> findAll() {
        return propertiesRepository.findAll();
    }

    @Override
    public void save(Property property){
        propertiesRepository.save(property);
    }

    @Override
    public Optional<Property> findById(Long id) {
        return propertiesRepository.findById(id);
    }

    @Override
    public Optional<Property> findByPropName(String propName) {
        return propertiesRepository.findByPropName(propName);
    }

}
