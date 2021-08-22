package com.reinvent.graphqlk.queries;

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.reinvent.graphqlk.repository.AuthorRepository
import org.springframework.stereotype.Component

@Component
class AuthorQuery(val authorRepository: AuthorRepository) : Query {
    fun author(id: ID) = authorRepository.getById(id)
    fun authors() = authorRepository.all()
}