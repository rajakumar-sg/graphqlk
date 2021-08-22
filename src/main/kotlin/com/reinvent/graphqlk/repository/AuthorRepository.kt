package com.reinvent.graphqlk.repository

import com.expediagroup.graphql.generator.scalars.ID
import com.reinvent.graphqlk.model.Author
import org.springframework.stereotype.Component

@Component
class AuthorRepository {
    private val authors = listOf(
            Author(ID("1"), "AuthorOne"),
            Author(ID("2"), "AuthorTwo"),
    )

    fun getById(id : ID) = authors.find { id == it.id}
    fun all() = authors
}