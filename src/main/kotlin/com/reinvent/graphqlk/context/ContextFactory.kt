package com.reinvent.graphqlk.context

import com.expediagroup.graphql.generator.execution.GraphQLContext
import com.expediagroup.graphql.server.execution.GraphQLContextFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest

@Component
class ContextFactory: GraphQLContextFactory<MyContext, ServerRequest> {
    override suspend fun generateContext(request: ServerRequest): MyContext? {
        return MyContext(
                name = request.queryParam("name").orElse("no-name")
        );
    }
}

data class MyContext(val name: String?) : GraphQLContext