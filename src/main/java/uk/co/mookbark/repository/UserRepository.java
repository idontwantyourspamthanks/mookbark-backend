package uk.co.mookbark.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co.mookbark.model.DAOUser;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<DAOUser, Long> {

    Optional<DAOUser> findByUsername(String username);

}
