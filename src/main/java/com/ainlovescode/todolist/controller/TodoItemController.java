package com.ainlovescode.todolist.controller;

import com.ainlovescode.todolist.model.TodoItemDetails;
import com.ainlovescode.todolist.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class TodoItemController {
    @Autowired
    TodoItemService todoItemService;

    @PostMapping("/createTodo")
    public TodoItemDetails createTodo(@RequestBody String title){
        if(!title.isEmpty()) {
            TodoItemDetails createdTodo = todoItemService.create(title);

            return createdTodo;
        } else {
            return null;
        }
    }

    @GetMapping("/allTodos")
    public List<TodoItemDetails> getTodos(){
        List<TodoItemDetails> allTodos = todoItemService.getTodos();

        return allTodos;
    }



}
