package andersonfflores.crudjsonplaceholder.Services;


import andersonfflores.crudjsonplaceholder.Models.Comment;
import andersonfflores.crudjsonplaceholder.Repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findById(UUID id) {
        return commentRepository.findById(id);
    }

    public Optional<Comment> update(Comment comment, UUID id) {
        Optional<Comment> updatedComment = commentRepository.findById(id);
        if (updatedComment.isPresent()) {
            updatedComment.get().setName(comment.getName());
            updatedComment.get().setBody(comment.getBody());
            updatedComment.get().setEmail(comment.getEmail());
            return Optional.of(commentRepository.save(updatedComment.get()));
        }
        return Optional.empty();
    }

    public void delete(UUID id) {
        commentRepository.deleteById(id);
    }


}
