package com.example.api.controller;

import com.example.api.entity.ToDoList;
import com.example.api.exeption.ResourceNotFoundException;
import com.example.api.repository.ToDoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/todo")
public class ToDoListController {

    @Autowired
    private ToDoListRepository todoListRepository;

    @GetMapping("/todolist")
    public List<ToDoList> getAllTodoList(){
        return todoListRepository.findAll();
    }

    @GetMapping("/todolist{id}")
    public ResponseEntity<ToDoList> getTodoListById(@PathVariable(value = "id") Long todoId)
            throws ResourceNotFoundException {
        ToDoList todoList = todoListRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("TodoList not found for this id :: " + todoId));
        return ResponseEntity.ok().body(todoList);
    }

    @PostMapping("/todolist")
    public ToDoList createTodoList(@Valid @RequestBody ToDoList todoList) {
        return todoListRepository.save(todoList);
    }

    @PutMapping("/todolist{id}")
    public ResponseEntity <ToDoList> updateTodoList(@PathVariable(value = "id") Long todoId, @Valid @RequestBody ToDoList todoListDetails)
            throws ResourceNotFoundException {
        ToDoList todoList = todoListRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todolist not found for this id :: " + todoId));

        todoList.setTaskName(todoListDetails.getTaskName());
        todoList.setDescription(todoListDetails.getDescription());

        final ToDoList updatedTodoList = todoListRepository.save(todoList);
        return ResponseEntity.ok(updatedTodoList);
    }

    @DeleteMapping("/todolist{id}")
    public Map<String, Boolean> deleteTodoList(@PathVariable(value = "id") Long todoId)
            throws ResourceNotFoundException {
        ToDoList todoList = todoListRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todolist not found for this id :: " + todoId));

        todoListRepository.delete(todoList);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
