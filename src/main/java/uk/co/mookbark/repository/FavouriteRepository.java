package uk.co.mookbark.repository;

import org.springframework.data.repository.CrudRepository;
import uk.co.mookbark.model.DAOFavourite;

import java.util.List;
import java.util.Optional;

public interface FavouriteRepository extends CrudRepository<DAOFavourite, Long> {

    Optional<DAOFavourite> findByName(String name);

    List<DAOFavourite> findByOwnerId(Long id);
}
