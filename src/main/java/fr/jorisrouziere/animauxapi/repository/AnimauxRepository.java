package fr.jorisrouziere.animauxapi.repository;

import fr.jorisrouziere.animauxapi.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimauxRepository extends CrudRepository<Animal, Long> {

}
