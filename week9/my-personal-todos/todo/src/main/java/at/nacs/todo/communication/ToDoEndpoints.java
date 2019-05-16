package at.nacs.todo.communication;

import at.nacs.todo.logic.ToDosManager;
import at.nacs.todo.persistance.domain.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoEndpoints {

    private final ToDosManager manager;

    @GetMapping
    public List<ToDo> getAllToDos() {
        return manager.displayAllExistingToDos();
    }

    @PostMapping
    public void addToDo(@RequestBody String toDoTitle) {
        manager.storeNewToDo(toDoTitle);
    }

    @GetMapping("/{id}")
    public Optional<ToDo> findToDosById(@PathVariable String id) {
        return manager.getToDosById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable String id) {
        manager.deleteToDo(id);
    }

    @PutMapping("/{id}/done")
    public void markDone(@PathVariable String id) {
        Optional<ToDo> task = manager.getToDosById(id);
        task.get().setDone(true);
    }
}
