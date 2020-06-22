package io.benxar.microservices.service;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@RequestMapping("/pets")
public interface PetsResource {
  /**
   * Returns all pets from the system that the user has access to
   *
   */
  @GetMapping()
  List<Pet> findPets(@RequestParam("tags") List<String> tags, @RequestParam("limit") Integer limit);

  /**
   * Creates a new pet in the store.  Duplicates are allowed
   */
  @PostMapping()
  Pet addPet(Pet data);

  /**
   * Returns a user based on a single ID, if the user does not have
   * access to the pet
   */
  @GetMapping("/{id}")
  Pet findPetById(@PathVariable("id") Integer id);

  /**
   * deletes a single pet based on the ID supplied
   */
  @DeleteMapping("/{id}")
  void deletePet(@PathVariable("id") Integer id);
}
