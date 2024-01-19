package com.example.silver.domain.todos.dto.response

import java.time.LocalDateTime

data class TodoResponse(
    val todoId : Long,
    val title : String,
    val contents : String,
    val todoTime : LocalDateTime,
    val userName : String
)
