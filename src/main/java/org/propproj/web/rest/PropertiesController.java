package org.propproj.web.rest;

import org.propproj.web.entity.Property;
import org.propproj.web.model.SearchStrategy;
import org.propproj.web.model.SearchStrategyFactory;
import org.propproj.web.model.SearchStrategyType;
import org.propproj.web.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping(path="/props") // This means URL's start with /props (after Application path)
public class PropertiesController {

    @Autowired
    private PropertiesService propertiesService;

    @Resource(name = "searchStrategyFactory")
    private SearchStrategyFactory searchStrategyFactory;

    @GetMapping("/")
    public @ResponseBody String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/resource")
    public @ResponseBody Map<String,Object> greeting() {
        Map<String,Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Greetings from Spring Boot!");
        return model;
    }

    @GetMapping(path="/add")
    public @ResponseBody ResponseEntity<String> addNewProp(@RequestParam String propName
            , @RequestParam String description, @RequestParam String type) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Property n = new Property(propName, description, type);
        propertiesService.save(n);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Property> getAllProperties() {
        // This returns a JSON or XML with the users
        return propertiesService.findAll();
    }

    @GetMapping(path="/searchbypropname")
    public @ResponseBody Iterable<Property> searchByPropName (@RequestParam String propName) {
        propertiesService.setSearchStrategy(searchStrategyFactory.getSearchStrategy(SearchStrategyType.BYNAME));
        return propertiesService.search(propName);
    }

    @GetMapping(path="/searchbytype")
    public @ResponseBody Iterable<Property> searchByType (@RequestParam String type) {
        propertiesService.setSearchStrategy(searchStrategyFactory.getSearchStrategy(SearchStrategyType.BYTYPE));
        return propertiesService.search(type);
    }

    @GetMapping(path="/searchbydescription")
    public @ResponseBody Iterable<Property> searchByDescription (@RequestParam String description) {
        propertiesService.setSearchStrategy(searchStrategyFactory.getSearchStrategy(SearchStrategyType.BYDESCRIPTION));
        return propertiesService.search(description);
    }

    @GetMapping(path="/searchbyid")
    public @ResponseBody Iterable<Property> searchById (@RequestParam Long id) {
        propertiesService.setSearchStrategy(searchStrategyFactory.getSearchStrategy(SearchStrategyType.BYID));
        return propertiesService.search(""+id);
    }
}