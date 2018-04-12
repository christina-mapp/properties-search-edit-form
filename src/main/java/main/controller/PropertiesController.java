package main.controller;

import main.model.Property;
import main.service.PropertiesService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/props") // This means URL's start with /props (after Application path)
public class PropertiesController {

    private PropertiesService propertiesService;

    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String firstName
            , @RequestParam String lastName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Property n = new Property(firstName, lastName);
        propertiesService.save(n);
        return "Saved";
    }

    @GetMapping(path="/findbypropname")
    public @ResponseBody Property findByPropName (@RequestParam String propName) {
        return propertiesService.findByPropName(propName).orElse(null);
    }

    @GetMapping(path="/findbyid")
    public @ResponseBody Property findById (@RequestParam int id) {
        return propertiesService.findById(id).orElse(null);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Property> getAllUsers() {
        // This returns a JSON or XML with the users
        return propertiesService.findAll();
    }
}