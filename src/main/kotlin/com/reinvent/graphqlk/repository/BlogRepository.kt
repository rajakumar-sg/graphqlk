package com.reinvent.graphqlk.repository

import com.expediagroup.graphql.generator.scalars.ID
import com.reinvent.graphqlk.model.Blog
import org.springframework.stereotype.Component

@Component
class BlogRepository {
    private val blogs = listOf<Blog>(
            Blog(ID("1"), "My first blog", ID("1")),
            Blog(ID("2"), "My second blog", ID("1")),
            Blog(ID("3"), "My third blog", ID("2"))
    )

    fun getById(id: ID) = blogs.find { id == it.authorId }
    fun all() = blogs
}