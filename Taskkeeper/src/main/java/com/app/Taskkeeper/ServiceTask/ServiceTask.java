package com.app.Taskkeeper.ServiceTask;

import com.app.Taskkeeper.models.Task;
import com.app.Taskkeeper.repo.Taskrepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTask {

    private final Taskrepo taskrepo;

    public ServiceTask(Taskrepo taskrepo) {
        this.taskrepo = taskrepo;
    }

    public List<Task> getAllTasks() {
        return taskrepo.findAll();
    }

    public void createTask(String tittle) {
        Task task =new Task();
        task.setTittle(tittle);
        task.setCompleted(false);
        taskrepo.save(task);
    }

    public void deleteTasks(Long id) {
        taskrepo.deleteById(id);
    }

    public void doneTasks(Long id) {
        Task task = taskrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid task id"));
        task.setCompleted(!task.isCompleted());
        taskrepo.save(task);
    }

}

