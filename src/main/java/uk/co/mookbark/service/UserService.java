package uk.co.mookbark.service;

import org.springframework.stereotype.Service;
import uk.co.mookbark.model.DAOUser;
import uk.co.mookbark.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService extends BaseService<DAOUser> {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<DAOUser> loadUserByUsername(String username) {
        return this.repository.findByUsername(username);
    }
}
