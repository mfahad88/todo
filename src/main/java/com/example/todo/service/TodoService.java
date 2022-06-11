package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Todo> getTodos(){
        return this.repository.findAll();
    }

    public Optional<Todo> getTodoById(Integer id){
        return this.repository.findById(id);
    }

    public Todo updateTodo(Todo todo){
        Todo todo1 = this.repository.findById(todo.getId()).get();
        if(todo.getId()==todo1.getId()){
            todo1.setTitle(todo.getTitle());
            todo1.setContent(todo.getContent());
            todo1.setVisible(todo.getVisible());
        }
        return this.repository.save(todo1);
    }

    public Todo deleteTodo(Integer id){
        Todo todo=this.repository.findById(id).get();
        todo.setVisible(false);
        return this.repository.save(todo);
    }

    public Todo saveTodo(Todo todo){
        System.out.println(todo.toString());
        return this.repository.save(todo);
    }

}
