package com.yy.todolist.dao;
// This interface extends the JpaRepository class and provides methods for performing CRUD operations on TodoItem objects.
import com.yy.todolist.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
