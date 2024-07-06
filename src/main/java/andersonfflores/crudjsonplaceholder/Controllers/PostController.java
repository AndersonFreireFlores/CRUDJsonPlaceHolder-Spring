package andersonfflores.crudjsonplaceholder.Controllers;

import andersonfflores.crudjsonplaceholder.Models.Post;
import andersonfflores.crudjsonplaceholder.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping(value = "/posts")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping(value = "/post/{id}")
    public Optional<Post> getPostById(@PathVariable UUID id) {
        return postService.findById(id);
    }

    @PostMapping(value = "/post")
    public Post createPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @PutMapping(value = "/post/{id}")
    public Post updatePost(@PathVariable UUID id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping(value = "/post/{id}")
    public void deletePost(@PathVariable UUID id) {
        postService.delete(id);
    }

}
