package uk.co.mookbark.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.mookbark.model.User;
import uk.co.mookbark.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController()
public class TestController {

    private final Logger LOG = LoggerFactory.getLogger(TestController.class);

    private final UserRepository userRepository;

    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/test")
    public String getUsers() {
        LOG.warn("Got to /test");
        List<User> users = StreamSupport.stream(this.userRepository.findAll().spliterator(), false).toList();
        return "Users are " + users.stream().map(u -> u.getUsername() + " - " + u.getEmail()).collect(Collectors.joining(" :: "));
    }

    @RequestMapping("/test/root")
    public String getRoot() {
        LOG.warn("Called /test/root");
        Optional<User> user = userRepository.findByUsername("root");
        String response = user.isPresent() ? user.get().getEmail() : "MISSING";
        LOG.warn("Response is " + response);
        return response;
    }

}