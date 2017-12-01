package hrs.features.user;

import java.util.Optional;

/**
 * @author Marta Motyka
 * @since 21.11.2017
 */
public interface UserManager {
    void addUser(User user);

    void deleteUser(User user);

    Optional<User> getUser(String username);
}
