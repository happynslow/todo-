package com.example.silver.domain.todos.controller

import com.example.silver.domain.todos.dto.response.TodoResponse
import com.example.silver.domain.todos.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/todo")
@RestController
class TodoController (
    private val todoService: TodoService){


    @GetMapping
    fun getTodoList(): ResponseEntity<List<TodoResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getAllTodoList())
    }

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getTodoById(todoId))

    }


    @DeleteMapping("/{todoId}")
    fun deleteTodos(@PathVariable todoId: Long): ResponseEntity<Unit> {
        todoService.todoDelete(todoId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}