package com.ainlovescode.todolist.service;

import com.ainlovescode.todolist.model.TodoItemDetails;
import com.ainlovescode.todolist.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public TodoItemDetails create(String title){
        TodoItemDetails todoCreate = new TodoItemDetails();
        todoCreate.setTitle(title);

        TodoItemDetails createdTodo = todoItemRepository.save(todoCreate);

        return createdTodo;

    }
    public List<TodoItemDetails> getTodos(){
        List<TodoItemDetails> allTodos = todoItemRepository.findAll();

        return allTodos;

    }

}
