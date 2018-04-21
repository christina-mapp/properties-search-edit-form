package main.model.repository;

import main.model.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("myRepo")
public interface PropertiesRepository extends CrudRepository<Property, Long> {
    Iterable<Property> findByPropNameContaining(String propName);

    Iterable<Property> findByTypeContaining(String type);

    Iterable<Property> findByDescriptionContaining(String description);

    Iterable<Property> findById(Long id);

}