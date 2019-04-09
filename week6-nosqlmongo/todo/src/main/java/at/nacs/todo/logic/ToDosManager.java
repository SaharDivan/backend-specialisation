package at.nacs.todo.logic;

import at.nacs.todo.persistance.ToDoRepository;
import at.nacs.todo.persistance.domain.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDosManager {

    private final ToDoRepository repository;


    public List<ToDo> displayAllExistingToDos() {
        return repository.findAll();
    }

    public Optional<ToDo> getToDosById(String id) {
        return repository.findById(id);
    }

    public void storeNewToDo(String toDoTitle) {
        ToDo toDo = ToDo.builder().title(toDoTitle).build();
        repository.save(toDo);
    }

    public void deleteToDo(String id) {
        repository.delete(getToDosById(id).get());
    }


}
