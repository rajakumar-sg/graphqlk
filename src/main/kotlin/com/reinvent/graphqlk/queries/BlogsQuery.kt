package com.reinvent.graphqlk.queries

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.reinvent.graphqlk.repository.BlogRepository
import org.springframework.stereotype.Component

@Component
class BlogsQuery(val blogRepository: BlogRepository) : Query {
    fun blog(id: ID) = blogRepository.getById(id)
    fun blogs() = blogRepository.all()
}