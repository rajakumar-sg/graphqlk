package com.reinvent.graphqlk.configuration

import com.expediagroup.graphql.server.spring.execution.SpringDataFetcher
import com.fasterxml.jackson.databind.ObjectMapper
import graphql.schema.DataFetchingEnvironment
import org.springframework.context.ApplicationContext
import reactor.core.publisher.Mono
import kotlin.reflect.KFunction

class CustomFunctionDataFetcher(
        target: Any?,
        fn: KFunction<*>,
        objectMapper: ObjectMapper,
        appContext: ApplicationContext
) : SpringDataFetcher(target, fn, objectMapper, appContext) {

    override fun get(environment: DataFetchingEnvironment): Any? = when (val result = super.get(environment)) {
        is Mono<*> -> result.toFuture()
        else -> result
    }
}