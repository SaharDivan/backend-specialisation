package at.nacs.todo.communication;


import at.nacs.todo.persistance.ToDoRepository;
import at.nacs.todo.persistance.domain.ToDo;
import at.nacs.todo.logic.ToDosManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDoEndpointsTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    ToDosManager manager;


    String id = UUID.randomUUID().toString();

    @Test
    void getAllToDos() {

        List<ToDo> toDoList = Arrays.asList(
                ToDo.builder().title("yoga").done(false).build(),
                ToDo.builder().title("coding").done(false).build()
        );

        when(manager.displayAllExistingToDos())
                .thenReturn(toDoList);

        String url = "/todos";
        ToDo toDos = testRestTemplate.getForObject(url, ToDo.class);
    }

    @Test
    void addToDo() {
        String url = "/todos";
        testRestTemplate.postForObject(url, id, String.class);

        verify(manager).storeNewToDo(id);

    }

    @Test
    void findToDosWithId() {

        String url = "/todos/" + id;
        ToDo toDo = testRestTemplate.getForObject(url, ToDo.class);
        Assertions.assertThat(toDo.getId()).isEqualTo(id);
    }

    @Test
    void markDone() {
        String url = "/todos/{id}/done";
    }

    @Test
    void deleteToDo() {
        String url = "/todos/{id}";

    }
}