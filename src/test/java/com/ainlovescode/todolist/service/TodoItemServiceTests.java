package com.ainlovescode.todolist.service;

import com.ainlovescode.todolist.model.TodoItemDetails;
import com.ainlovescode.todolist.repository.TodoItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TodoItemServiceTests {
    @Mock
    private TodoItemRepository testTodoItemRepository;

    @InjectMocks
    private TodoItemService testTodoItemService;

    @Test
    public void shouldCreateTodoGivenValidDetails(){
        // Arrange - Set up items to be tested
        TodoItemDetails todoItemCreate = new TodoItemDetails();
        todoItemCreate.setTitle("todo item 1");

        when(testTodoItemRepository.save(any(TodoItemDetails.class))).thenReturn(todoItemCreate);
        // Act - Run the methods to be tested
        TodoItemDetails createdTodoItem = testTodoItemService.create("todo item 1");

        // Assert - Check that methods run as expect
        assertEquals("todo item 1", createdTodoItem.getTitle());
    }

    @Test
    public void shouldGetAllTodos(){
//        // Arrange - Set up items to be tested
//        TodoItemDetails todoItemCreate1 = new TodoItemDetails();
//        todoItemCreate1.setTitle("todo item 1");
//        TodoItemDetails todoItemCreate2 = new TodoItemDetails();
//        todoItemCreate1.setTitle("todo item 2");
        when(testTodoItemRepository.findAll()).thenReturn(Arrays.asList(new TodoItemDetails(), new TodoItemDetails()));
        // Act - Run the methods to be tested
        List<TodoItemDetails> allTodos= testTodoItemService.getTodos();

        // Assert - Check that methods run as expect
        assertEquals(2, allTodos.size());
    }
}
