package com.example.silver.domain.todos.repository

import com.example.silver.domain.todos.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepostory : JpaRepository<Todo, Long>{
}