package com.reinvent.graphqlk.resolvers

import com.reinvent.graphqlk.model.Author
import com.reinvent.graphqlk.model.Blog
import com.reinvent.graphqlk.repository.AuthorRepository
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component("AuthorDataFetcher")
class AuthorDataFetcher(val authorRepository: AuthorRepository) : DataFetcher<Author> {
    override fun get(environment: DataFetchingEnvironment?): Author? {
        val authorId = environment?.getSource<Blog>()?.authorId
        return if (authorId != null) authorRepository.getById(authorId) else Author.none
    }
}
