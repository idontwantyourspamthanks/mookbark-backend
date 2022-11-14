package uk.co.mookbark.service;

import org.springframework.data.repository.CrudRepository;
import uk.co.mookbark.model.DAOBase;

import java.util.Optional;

public abstract class BaseService <T extends DAOBase> {

    CrudRepository<T, Long> repository;

    public T create(T item) {
        if (this.repository.existsById(item.getId())) {
            return this.repository.save(item);
        }
        throw new IllegalArgumentException("This item already exists");
    }

    public void delete(T item) {
        if (this.repository.existsById(item.getId())) {
            this.repository.delete(item);
            return;
        }
        throw new IllegalArgumentException("This item does not exist");
    }

    public Optional<T> get(long id) {
        return this.repository.findById(id);
    }

}
