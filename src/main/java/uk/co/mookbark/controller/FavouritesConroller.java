package uk.co.mookbark.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.mookbark.model.DAOUser;
import uk.co.mookbark.service.FavouriteService;

@RestController
public class FavouritesConroller {

    private final FavouriteService favouriteService;

    public FavouritesConroller(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @GetMapping("/favourites/all")
    public String allFavourites(@AuthenticationPrincipal DAOUser user) {
        return this.favouriteService.findByUser(user.getId()).toString();
    }

}
