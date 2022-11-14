package uk.co.mookbark.controller;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.mookbark.model.DAOUser;
import uk.co.mookbark.service.FavouriteService;
import uk.co.mookbark.service.UserService;

import java.util.Optional;

@RestController
public class FavouritesController {

    private final FavouriteService favouriteService;
    private final UserService userService;

    public FavouritesController(FavouriteService favouriteService, UserService userService) {
        this.favouriteService = favouriteService;
        this.userService = userService;
    }

    @GetMapping("/favourites/all")
    public String allFavourites(JwtAuthenticationToken authentication) {
        // Can't do @AuthenticationPrincipal because what we actually get is a JwtAuthenticationToken
        System.out.println("User is " + authentication.getName() + " with attributes " + authentication.getTokenAttributes());
        Optional<DAOUser> user = userService.loadUserByUsername(authentication.getName());
        if (user.isPresent()) {
            return this.favouriteService.findByUser(user.get().getId()).toString();
        }
        throw new IllegalArgumentException("Can't remember the exception for unauthorised");
    }

}
