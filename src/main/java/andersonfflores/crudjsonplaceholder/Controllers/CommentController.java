package andersonfflores.crudjsonplaceholder.Controllers;

import andersonfflores.crudjsonplaceholder.Models.Comment;
import andersonfflores.crudjsonplaceholder.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/comments")
    public List<Comment> getComments() {
        return commentService.findAll();
    }

    @GetMapping(value = "/comment/{id}")
    public Optional<Comment> getComment(@PathVariable UUID id) {
        return commentService.findById(id);
    }

    @PostMapping(value = "/comment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @PutMapping(value = "/comment/{id}")
    public Comment updateComment(@PathVariable UUID id, @RequestBody Comment comment) {
        return  commentService.update(comment,id);
    }

    @DeleteMapping(value = "/comment/{id}")
    public void deleteComment(@PathVariable UUID id) {
        commentService.delete(id);
    }
}
