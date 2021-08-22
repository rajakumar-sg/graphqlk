package com.reinvent.graphqlk.model

import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.generator.scalars.ID

data class Blog(
        val id: ID,
        val name: String,
        @GraphQLIgnore val authorId: ID
) {
    lateinit var author: Author
}