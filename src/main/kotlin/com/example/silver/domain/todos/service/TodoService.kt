package com.example.silver.domain.todos.service

import com.example.silver.domain.todos.dto.reqest.TodosRequest
import com.example.silver.domain.todos.dto.response.TodoResponse


interface TodoService {
    fun getAllTodoList() : List<TodoResponse>
    fun getTodoById(todoId: Long) : TodoResponse
    fun todoCreat(request: TodosRequest) : TodoResponse
    fun todoUpdate(todoId: Long, request: TodosRequest) : TodoResponse
    fun todoDelete(todoId:Long)
}