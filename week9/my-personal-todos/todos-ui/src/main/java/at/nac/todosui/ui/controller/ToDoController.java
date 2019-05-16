package at.nac.todosui.ui.controller;

import at.nac.todosui.communication.ToDoClient;
import at.nac.todosui.ui.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoClient client;

    @ModelAttribute("todo")
    ToDo todo() {
        return new ToDo();
    }

    @ModelAttribute("todoslist")
    List<ToDo> todoList() {
        return client.getAll();
    }


    @GetMapping()
    String page() {
        return "my-todo-list";
    }


    @PostMapping("done")
    String postDone(String id) {

        client.sendForMarkingDone(id);
        return "redirect:/";
    }

    @PostMapping()
    String postAdd(@Valid ToDo toDo, BindingResult result) {
        if (result.hasFieldErrors()) {
            return page();
        }
        client.sendForAdding(toDo.getTitle());
        return "redirect:/";
    }

}
