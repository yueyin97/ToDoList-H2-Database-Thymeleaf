package com.yy.todolist.controller;

import com.yy.todolist.domain.TodoItem;
import com.yy.todolist.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// GET /: This endpoint displays a list of to-do items.
// GET /add: This endpoint displays a form for adding a new to-do item.
// POST /add: This endpoint handles the submission of the add form, and saves the new to-do item.
// GET /edit/{id}: This endpoint displays a form for editing an existing to-do item.
// POST /edit: This endpoint handles the submission of the edit form, and updates the to-do item.
// GET /delete/{id}: This endpoint deletes an existing to-do item.

// some web browsers (such as Internet Explorer) do not support the DELETE method. This means that if you tried to use the DELETE method in the to-do list application, it would not work in these browsers.

@Controller
// @RequestMapping("/")
public class TodoController {

    @Autowired
    private TodoItemService service;

    @GetMapping("/")
    public String list(Model model) {
        List<TodoItem> items = service.findAll();
        model.addAttribute("items", items);
        return "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new TodoItem());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute TodoItem item) {
        service.save(item);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Optional<TodoItem> item = service.findById(id);
        model.addAttribute("item", item.orElse(new TodoItem()));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute TodoItem item) {
        service.save(item);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/";
    }

}
