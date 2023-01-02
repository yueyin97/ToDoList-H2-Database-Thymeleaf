package com.yy.todolist.service;

import com.yy.todolist.dao.TodoItemRepository;
import com.yy.todolist.domain.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository repository;

    public List<TodoItem> findAll() {
        return repository.findAll();
    }

    public Optional<TodoItem> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public TodoItem save(TodoItem item) {
        return repository.save(item);
    }
}
