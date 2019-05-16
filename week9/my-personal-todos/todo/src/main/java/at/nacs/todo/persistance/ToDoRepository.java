package at.nacs.todo.persistance;

import at.nacs.todo.persistance.domain.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
}
