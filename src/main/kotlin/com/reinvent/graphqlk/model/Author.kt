package com.reinvent.graphqlk.model

import com.expediagroup.graphql.generator.scalars.ID

data class Author(
        val id: ID,
        val name: String
) {
    companion object {
        val none = Author(ID(""), "")
    }

    fun caseName(caseType: CaseType) = caseType.apply(name)
}

enum class CaseType(private val converter : (String) -> String) {
    UPPER(String::uppercase), LOWER(String::lowercase);

    fun apply(name: String) = converter(name)
}
