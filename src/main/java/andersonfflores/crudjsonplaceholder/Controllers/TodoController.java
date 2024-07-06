package andersonfflores.crudjsonplaceholder.Controllers;

import andersonfflores.crudjsonplaceholder.Models.Todo;
import andersonfflores.crudjsonplaceholder.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping(value = "/todos")
    public List<Todo> getTodos() {
        return todoService.findAll();
    }

    @GetMapping(value = "/todo/{id}")
    public Optional<Todo> getTodoById(@PathVariable UUID id) {
        return todoService.findById(id);
    }

    @PostMapping(value = "/todo")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PutMapping(value = "/todo/{id}")
    public Todo updateTodo(@PathVariable UUID id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping(value = "/todo/{id}")
    public void deleteTodo(@PathVariable UUID id) {
        todoService.delete(id);
    }
}
