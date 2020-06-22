package io.benxar.microservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetsEndpoint  {

    @PostMapping()
    public Pet addPet(Pet data) {
		return null;
	}

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable("id") Integer id) {}
    

    @GetMapping("/{id}")
    public Pet findPetById(@PathVariable("id") Integer id) {
		return null;
	}

    @GetMapping()
    public List<Pet> findPets(
        @RequestParam(name = "tags", required = false) List<String> tags,
        @RequestParam(name = "limit", required = false) Integer limit) {
        List<Pet> results = new ArrayList<Pet>();
        results.add(new Pet(1, "Zaza", "cat"));
        results.add(new Pet(2, "Tigresse", "cat"));
        results.add(new Pet(3, "Maki", "cat"));
        results.add(new Pet(4, "Toufik", "cat"));
        return results;
	}
    
}