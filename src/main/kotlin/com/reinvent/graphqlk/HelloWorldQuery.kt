package com.reinvent.graphqlk

import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Component
class HelloWorldQuery: Query {
    fun helloWorld(
            value: Int
    ) = "Hello World!, context.name=${value}"
}