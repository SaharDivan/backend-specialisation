package at.nac.todosui.communication;

import at.nac.todosui.ui.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ToDoClient {

    private final RestTemplate restTemplate;

    @Value("${server.address.url}")
    private String url;


    public List<ToDo> getAll() {
        return Arrays.asList(restTemplate.getForObject(url, ToDo[].class));

    }

    public void sendForAdding(String title)
    {
        restTemplate.postForObject(url, title, void.class);
    }

    public void sendForMarkingDone(String id) {
        String doneUrl = url + "/" + id + "/done";
        restTemplate.put(doneUrl, void.class);
    }
}
