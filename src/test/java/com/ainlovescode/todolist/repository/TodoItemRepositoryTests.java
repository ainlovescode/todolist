package com.ainlovescode.todolist.repository;

import com.ainlovescode.todolist.model.TodoItemDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoItemRepositoryTests {

    @Autowired
    private TodoItemRepository testTodoItemRepository;

    @Test
    public void shouldCreateTodoGivenValidDetails(){

        // Arrange, Act, Assert
        TodoItemDetails todoItemCreate = new TodoItemDetails();

        todoItemCreate.setTitle("Todo item 1");

        TodoItemDetails createdTodoItem = testTodoItemRepository.save(todoItemCreate);

        assertEquals(todoItemCreate, createdTodoItem);
    }

}
