package at.nacs.todo.logic;

import at.nacs.todo.persistance.ToDoRepository;
import at.nacs.todo.persistance.domain.ToDo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ToDosManagerTest {

    @Autowired
    ToDosManager toDosManager;

    @Autowired
    ToDoRepository repository;

    @BeforeEach
    void before() {
        repository.deleteAll();
    }

    @AfterEach
    void after() {
        repository.deleteAll();
    }

    String id = UUID.randomUUID().toString();

    @Test
    void storeNewToDo() {
        String title = "doing yoga";
        toDosManager.storeNewToDo(title);

        assertThat(repository.count()).isEqualTo(1);
    }

    @Test
    void getToDosWithId() {
        ToDo doing_yoga = ToDo.builder().title("doing yoga").id(id).build();
        repository.save(doing_yoga);

        Optional<ToDo> toDosWithId = toDosManager.getToDosById(id);

        assertThat(repository.count()).isEqualTo(1);
        assertThat(toDosWithId.get().getId()).isEqualTo(id);

    }

    @Test
    void displayAllExistingToDos() {

        repository.save(ToDo.builder().title("do yoga").build());
        repository.save(ToDo.builder().title("do coding").build());

        List<ToDo> toDoList = toDosManager.displayAllExistingToDos();

        assertThat(toDoList.size()).isEqualTo(2);
    }


    @Test
    void deleteToDo() {
        repository.save(ToDo.builder().title("do yoga").id(id).build());
        toDosManager.deleteToDo(id);

        assertThat(repository.count()).isEqualTo(0);
    }
}