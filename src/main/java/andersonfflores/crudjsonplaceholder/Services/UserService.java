package andersonfflores.crudjsonplaceholder.Services;

import andersonfflores.crudjsonplaceholder.Models.User;
import andersonfflores.crudjsonplaceholder.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<User> update(User user, UUID id) {
        Optional<User> updatedUser = userRepository.findById(id);

        if (updatedUser.isPresent()) {
            updatedUser.get().setName(user.getName());
            updatedUser.get().setEmail(user.getEmail());
            return Optional.of(userRepository.save(updatedUser.get()));
        }
        return Optional.empty();
    }
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
