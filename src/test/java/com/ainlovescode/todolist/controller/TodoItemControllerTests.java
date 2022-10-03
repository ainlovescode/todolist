package com.ainlovescode.todolist.controller;

import com.ainlovescode.todolist.model.TodoItemDetails;
import com.ainlovescode.todolist.service.TodoItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoItemController.class)
public class TodoItemControllerTests {

    @MockBean
    private TodoItemService todoItemService;

    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateTodoGivenTitle() throws Exception {
        String title = "Todo item 1";

        when(todoItemService.create(any(String.class))).thenReturn(new TodoItemDetails());

        MvcResult mvcResult= mockMvc.perform(post("/createTodo")
                        .content(mapper.writeValueAsString(title))
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertTrue(mvcResult.getResponse().getContentAsString().contains(title));

    }

    @Test
    public void shouldRejectTodoGivenNoTitle() throws Exception {
        MvcResult mvcResult= mockMvc.perform(post("/createTodo")
                        .content("")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void shouldRetrieveAllTodos() throws Exception {
        when(todoItemService.getTodos()).thenReturn(Arrays.asList(new TodoItemDetails(), new TodoItemDetails()));

        MvcResult mvcResult = mockMvc.perform(get("/allTodos"))
                .andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }





}
