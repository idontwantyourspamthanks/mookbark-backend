package uk.co.mookbark.controller.input;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import uk.co.mookbark.model.DAOUser;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public DAOUser toUser(PasswordEncoder passwordEncoder) {
        return new DAOUser(username, passwordEncoder.encode(password), firstName, lastName, email);
    }

}
