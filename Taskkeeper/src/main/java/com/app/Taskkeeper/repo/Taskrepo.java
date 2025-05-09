package com.app.Taskkeeper.repo;

import com.app.Taskkeeper.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Taskrepo extends JpaRepository<Task,Long> {
}
