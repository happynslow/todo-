package com.example.silver.domain.todos.service

import com.example.silver.domain.todos.dto.reqest.TodosRequest
import com.example.silver.domain.todos.dto.response.TodoResponse
import com.example.silver.domain.todos.exception.ModelNotFoundException
import com.example.silver.domain.todos.model.Todo
import com.example.silver.domain.todos.model.toResponse
import com.example.silver.domain.todos.repository.TodoRepostory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class TodoServiceImpl(
    private val todoRepostory: TodoRepostory
) : TodoService {
    override fun getAllTodoList(): List<TodoResponse> {
        return todoRepostory.findAll().map { it.toResponse() }
    }

    override fun getTodoById(todoId: Long): TodoResponse {
        val todo = todoRepostory.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        return todo.toResponse()
    }

    override fun todoCreat(request: TodosRequest): TodoResponse {
        return todoRepostory.save(
            Todo(
                title = request.contents,
                userName = request.userName,
                contents = request.contents,
                todoTime = LocalDateTime.now(),
            )
        ).toResponse()
    }

    @Transactional
    ovrride fun updateTodo(todosId: Long, request: TodoRequest): TodoResponse {
        val todos = todoRepostory.findByIdOrNull(todosId) ?: throw IllegalStateException("Todo", "Long")
//      val (title, description, nickname) = request
        todos.nickname = request.nickname
        todos.title = request.title
        todos.description = request.description

        return todoRepository.save(todo).toResponse()
        //retun TodoRespinse(1,"","",Date(),"")
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw IllegalStateException("Todo", todoId)
        TodoRepository.delete(todo)
    }
}