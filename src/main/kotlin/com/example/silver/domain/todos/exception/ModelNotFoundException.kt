package com.example.silver.domain.todos.exception

import org.springframework.data.jpa.domain.AbstractPersistable_.id

data class ModelNotFoundException(
    val modelName: String,
    val Id: Long?):
    RuntimeException(
        "Model $modelName not found with given id: $id"
    )

