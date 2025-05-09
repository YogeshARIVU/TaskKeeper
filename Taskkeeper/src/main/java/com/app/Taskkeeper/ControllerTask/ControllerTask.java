package com.app.Taskkeeper.ControllerTask;

import com.app.Taskkeeper.ServiceTask.ServiceTask;
import com.app.Taskkeeper.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class ControllerTask  {

    private final ServiceTask Taskservice;

    public ControllerTask(ServiceTask taskservice) {
        Taskservice = taskservice;
    }
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks =Taskservice.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "task";
    }
    @PostMapping
    public String createTask(@RequestParam String tittle){
        Taskservice.createTask(tittle);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id) {
        Taskservice.deleteTasks(id);
        return "redirect:/";
    }
        @GetMapping("/{id}/done")
        public String doneTasks(@PathVariable Long id){
            Taskservice.doneTasks(id);
            return "redirect:/";
        }
    }
