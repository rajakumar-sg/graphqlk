package com.reinvent.graphqlk

import com.expediagroup.graphql.server.operations.Query
import com.reinvent.graphqlk.queries.HTTPContext
import org.springframework.stereotype.Component

@Component
class HelloWorldQuery : Query {
    fun helloWorld(
            value: Int,
            httpContext: HTTPContext?
    ) = "Hello World!, value=${value}, " +
            "pid:${httpContext?.getRequestParam("pid")}, " +
            "header-pid: ${httpContext?.getHTTPRequestHeader("pid")}"
}