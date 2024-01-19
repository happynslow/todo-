package com.example.silver.domain.todos.model

import com.example.silver.domain.todos.dto.response.TodoResponse
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "todos")
class Todo(

    @Column(name = "title")
    var title: String,
    @Column(name = "contents")
    var contents: String,
    @Column(name = "todotime")
    val todoTime: LocalDateTime = LocalDateTime.now(),
    @Column(name = "username")
    var userName: String,

    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todoid")
    var todoId: Long? = null
}

fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
        todoId = todoId!!,
        title = title,
        contents = contents,
        todoTime = todoTime,
        userName = userName,
    )
}