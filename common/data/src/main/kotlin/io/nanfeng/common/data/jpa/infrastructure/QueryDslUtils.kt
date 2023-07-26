package io.nanfeng.common.data.jpa.infrastructure

import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.core.types.dsl.SimpleExpression
import com.querydsl.core.types.dsl.StringExpression

fun <T : Any> SimpleExpression<T>.eqIfNotNull(value: T?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.eq(value)
    }
}

fun <T : Any> SimpleExpression<T>.neIfNotNull(value: T?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.ne(value)
    }
}

fun <T : Any> StringExpression.likeIfNotNull(value: String?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.like(value.toString())
    }
}

fun <T : Any> StringExpression.notLikeIfNotNull(value: String?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.notLike(value.toString())
    }
}

fun <T : Any> StringExpression.containsIfNotNull(value: String?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.contains(value.toString())
    }
}

fun <T : Any> StringExpression.notContainsIfNotNull(value: String?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.contains(value.toString()).not()
    }
}

fun <T : Any> StringExpression.startsWithIfNotNull(value: String?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.startsWith(value.toString())
    }
}

fun <T : Any> StringExpression.notStartsWithIfNotNull(value: String?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.startsWith(value.toString()).not()
    }
}

fun <T : Any> StringExpression.endsWithIfNotNull(value: String?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.endsWith(value.toString())
    }
}

fun <T : Any> StringExpression.notEndsWithIfNotNull(value: String?): BooleanExpression {
    return if (value == null) {
        Expressions.TRUE
    } else {
        this.endsWith(value.toString()).not()
    }
}

fun <T : Any> StringExpression.eqIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.eq(value.toString())
    }
}

fun <T : Any> StringExpression.neIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.ne(value.toString())
    }
}

fun <T : Any> StringExpression.likeIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.like(value.toString())
    }
}

fun <T : Any> StringExpression.notLikeIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.notLike(value.toString())
    }
}

fun <T : Any> StringExpression.containsIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.contains(value.toString())
    }
}

fun <T : Any> StringExpression.notContainsIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.contains(value.toString()).not()
    }
}

fun <T : Any> StringExpression.startsWithIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.startsWith(value.toString())
    }
}

fun <T : Any> StringExpression.notStartsWithIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.startsWith(value.toString()).not()
    }
}

fun <T : Any> StringExpression.endsWithIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.endsWith(value.toString())
    }
}

fun <T : Any> StringExpression.notEndsWithIfNotNullOrBlank(value: String?): BooleanExpression {
    return if (!value.isNullOrBlank()) {
        Expressions.TRUE
    } else {
        this.endsWith(value.toString()).not()
    }
}
