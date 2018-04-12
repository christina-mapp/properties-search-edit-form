package main.repository;

import main.model.Property;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface PropertiesRepository extends CrudRepository<Property, Long> {
    Optional<Property> findByPropName(String propName);

    Optional<Property> findById(long id);
}