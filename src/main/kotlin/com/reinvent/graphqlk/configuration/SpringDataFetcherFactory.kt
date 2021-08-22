package com.reinvent.graphqlk.configuration

import com.expediagroup.graphql.generator.extensions.deepName
import graphql.schema.DataFetcher
import graphql.schema.DataFetcherFactory
import graphql.schema.DataFetcherFactoryEnvironment
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class SpringDataFetcherFactory : DataFetcherFactory<Any?>, ApplicationContextAware {
    private lateinit var applicationContext: ApplicationContext;

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(environment: DataFetcherFactoryEnvironment?): DataFetcher<Any?> {
        // Strip out possible `Input` and `!` suffixes added to by the SchemaGenerator
        val targetedTypeName = environment?.fieldDefinition?.type?.deepName?.removeSuffix("!")?.removeSuffix("Input")
        return applicationContext.getBean("${targetedTypeName}DataFetcher") as DataFetcher<Any?>
    }
}