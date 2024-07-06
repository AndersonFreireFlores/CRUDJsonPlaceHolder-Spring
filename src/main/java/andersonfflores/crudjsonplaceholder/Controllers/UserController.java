package andersonfflores.crudjsonplaceholder.Controllers;

import andersonfflores.crudjsonplaceholder.Models.User;
import andersonfflores.crudjsonplaceholder.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User user) {
        return userService.update(user,id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteById(id);
    }
}
