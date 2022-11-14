package uk.co.mookbark.service;

import org.springframework.stereotype.Service;
import uk.co.mookbark.model.DAOFavourite;
import uk.co.mookbark.repository.FavouriteRepository;

import java.util.List;

@Service
public class FavouriteService extends BaseService<DAOFavourite> {

    FavouriteRepository repository;
    public List<DAOFavourite> findByUser(Long id) {
        return this.repository.findByOwnerId(id);
    }
}
