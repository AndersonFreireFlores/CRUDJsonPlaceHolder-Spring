package andersonfflores.crudjsonplaceholder.Services;

import andersonfflores.crudjsonplaceholder.Models.Todo;
import andersonfflores.crudjsonplaceholder.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findById(UUID id) {
        return todoRepository.findById(id);
    }

    public Todo update(UUID id, Todo todo) {
        Optional<Todo> updatedTodo = todoRepository.findById(id);
        if (updatedTodo.isPresent()) {
            updatedTodo.get().setTitle(todo.getTitle());
            updatedTodo.get().setCompleted(todo.getCompleted());
            return todoRepository.save(updatedTodo.get());
        }
        return null;
    }

    public void delete(UUID id) {
        todoRepository.deleteById(id);
    }
}
