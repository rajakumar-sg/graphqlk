package com.reinvent.graphqlk.model

import com.expediagroup.graphql.generator.scalars.ID

data class Author(
        val id: ID,
        val name: String
) {
    companion object {
        val none = Author(ID(""), "")
    }
}