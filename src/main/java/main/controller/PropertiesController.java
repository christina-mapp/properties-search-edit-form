package main.controller;

import main.model.Property;
import main.service.PropertiesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/props") // This means URL's start with /props (after Application path)
public class PropertiesController {

    private PropertiesService propertiesService;

    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/resource")
    public Map<String,Object> greeting() {
        Map<String,Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Greetings from Spring Boot!");
        return model;
    }

    @GetMapping(path="/add")
    public ResponseEntity<String> addNewProp(@RequestParam String propName
            , @RequestParam String propDesc, @RequestParam String type) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Property n = new Property(propName, propDesc, type);
        propertiesService.save(n);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path="/findbypropname")
    public @ResponseBody Property findByPropName (@RequestParam String propName) {
        return propertiesService.findByPropName(propName).orElse(null);
    }

    @GetMapping(path="/findbyid")
    public @ResponseBody Property findById (@RequestParam Long id) {
        return propertiesService.findById(id).orElse(null);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Property> getAllProperties() {
        // This returns a JSON or XML with the users
        return propertiesService.findAll();
    }
}