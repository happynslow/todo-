package com.example.silver.domain.todos.dto.reqest

import org.springframework.context.annotation.Description

data class TodosRequest(
    val title : String,
    val contents : String,
    val userName : String,
    val description: Description

)
