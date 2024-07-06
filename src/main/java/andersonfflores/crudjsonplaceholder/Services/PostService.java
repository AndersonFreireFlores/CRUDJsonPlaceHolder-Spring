package andersonfflores.crudjsonplaceholder.Services;

import andersonfflores.crudjsonplaceholder.Models.Post;
import andersonfflores.crudjsonplaceholder.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public Optional<Post> findById(UUID id) {
        return postRepository.findById(id);
    }

    public Post update(UUID id, Post post) {
        Optional<Post> updatedPost = postRepository.findById(id);
        if (updatedPost.isPresent()) {
            updatedPost.get().setTitle(post.getTitle());
            updatedPost.get().setBody(post.getBody());
            return postRepository.save(updatedPost.get());
        }
    return null;
    }

    public void delete(UUID id) {
        postRepository.deleteById(id);
    }
}
