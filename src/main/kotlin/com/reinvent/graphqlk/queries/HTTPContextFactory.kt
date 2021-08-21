package com.reinvent.graphqlk.queries

import com.expediagroup.graphql.server.spring.execution.SpringGraphQLContext
import com.expediagroup.graphql.server.spring.execution.SpringGraphQLContextFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest

@Component
class HTTPContextFactory : SpringGraphQLContextFactory<HTTPContext>() {
    override suspend fun generateContext(request: ServerRequest): HTTPContext {
        return HTTPContext(request);
    }
}

data class HTTPContext(val request: ServerRequest) : SpringGraphQLContext(request) {
    fun getRequestParam(name: String) : String? = request.queryParam(name).orElse(null);
}