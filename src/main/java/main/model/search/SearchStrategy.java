package main.model.search;

import main.model.Property;

public interface SearchStrategy {
    Iterable<Property> search(String searchText);
}
