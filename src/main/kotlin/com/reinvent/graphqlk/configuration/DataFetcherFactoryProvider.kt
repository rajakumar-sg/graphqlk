package com.reinvent.graphqlk.configuration

import com.expediagroup.graphql.generator.execution.SimpleKotlinDataFetcherFactoryProvider
import com.fasterxml.jackson.databind.ObjectMapper
import graphql.schema.DataFetcherFactory
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

@Component
class CustomDataFetcherFactoryProvider(
        private val springDataFetcherFactory: SpringDataFetcherFactory,
        private val objectMapper: ObjectMapper,
        private val applicationContext: ApplicationContext
) : SimpleKotlinDataFetcherFactoryProvider(objectMapper) {

    override fun functionDataFetcherFactory(target: Any?, kFunction: KFunction<*>) = DataFetcherFactory {
        CustomFunctionDataFetcher(
                target = target,
                fn = kFunction,
                objectMapper = objectMapper,
                appContext = applicationContext
        )
    }

    override fun propertyDataFetcherFactory(kClass: KClass<*>, kProperty: KProperty<*>): DataFetcherFactory<Any?> =
            if (kProperty.isLateinit) {
                springDataFetcherFactory
            } else {
                super.propertyDataFetcherFactory(kClass, kProperty)
            }
}