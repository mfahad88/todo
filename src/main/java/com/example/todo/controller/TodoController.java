package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {
    TodoService service;
    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    @CrossOrigin("*")
    public Iterable<Todo> getTodos(){
        return this.service.getTodos();
    }

    @GetMapping("/todo")
    @CrossOrigin("*")
    public Optional<Todo> getTodoById(@RequestParam("id")Integer id){
        return this.service.getTodoById(id);
    }

    @PostMapping("/update")
    @CrossOrigin("*")
    public Todo updateTodoById(@RequestBody Todo todo){
        return this.service.updateTodo(todo);
    }

    @GetMapping("/delete")
    @CrossOrigin("*")
    public Todo deleteTodoById(@RequestParam("id") Integer id){
        System.out.println(id);
        return this.service.deleteTodo(id);
    }

    @PostMapping("/save")
    @CrossOrigin("*")
    public Todo saveTodo(@RequestBody Todo todo){

        return this.service.saveTodo(todo);
    }
}
