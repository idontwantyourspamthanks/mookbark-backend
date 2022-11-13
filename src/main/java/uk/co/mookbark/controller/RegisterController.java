package uk.co.mookbark.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.mookbark.controller.input.RegistrationForm;
import uk.co.mookbark.model.User;
import uk.co.mookbark.repository.UserRepository;

@RestController()
public class RegisterController {

    private final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String processRegistration(RegistrationForm form) {
        LOG.warn("Reached register with " + form);
        User user = userRepository.save(form.toUser(passwordEncoder));
        return user.getId() + "";
    }

}
