package com.ainlovescode.todolist.repository;

import com.ainlovescode.todolist.model.TodoItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItemDetails, Integer> {

    List<TodoItemDetails> findAll();

}
